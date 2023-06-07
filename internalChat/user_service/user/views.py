from django.shortcuts import render, redirect
from django.http import HttpResponseRedirect
from django.contrib.auth.forms import AuthenticationForm
from decouple import config
import redis, mysql
from django.http import JsonResponse
import pybreaker
import requests
from user.services.circuit_breaker import UserListener
from user.services.user_service import UserService
from . import functions
from django.views.decorators.cache import cache_page
from django.views.decorators.csrf import csrf_exempt

userBreaker = pybreaker.CircuitBreaker(fail_max=5, reset_timeout=60, listeners=[UserListener()])
userService = UserService()

@cache_page(60 * 5)
@userBreaker #! NO ES NECESARIO SI SE USA CACHE
def user_login(request):
    """
    Función que permite el login de un usuario.
    """
    user_url = config('USER_URL')
    chat_url = config('CHAT_URL')
    if request.method == 'POST':
        email = request.POST.get('email')
        password = request.POST.get('password')
        try:
            user = userService.get_by_email(email)
        except:
            return render(request, 'login.html', {'error': 'Email do not exist.'})

        if userService.check_password(password, user.password):
            token = functions.get_tokens_for_user(user)
            try:
                response = HttpResponseRedirect(chat_url + "/token/" + "?refresh={}".format(token["refresh"]), {'user_url': user_url})
            except:
                response = render(request, 'login.html', {'error': 'Error with the chat service.'})
            return response
        else:
            return render(request, 'login.html', {'error': 'Incorrect password.'})                     
    else:
        form = AuthenticationForm()
        return render(request, 'login.html', {'form': form})   

@cache_page(60 * 5)
@userBreaker #! NO ES NECESARIO SI SE USA CACHE
def register(request):
    """
    Función que permite el registro de un usuario.
    """
    if request.method == 'POST':
        username = request.POST.get('username')
        email = request.POST.get('email')
        password = request.POST.get('password')
        # Verifico que no esten vacios
        if username and email and password:
            # Compruebo si el email ya existe
            if userService.check_user_email(email):
                return render(request, 'register.html', {'error': 'Email already exists.'})
            elif userService.check_user_username(username):
                return render(request, 'register.html', {'error': 'User already exists.'})
            else:
                userService.add(username=username, email=email, password=password)
                return redirect(config('USER_URL') + "/login/")
        else:
            return render(request, 'register.html', {'error': 'Todos los campos son obligatorios.'})
    else:
        return render(request, 'register.html')

def health_check(request):
    '''
    Función que chequea el estado de la db MySQL
    '''
    #Checkemos MySQL
    mysql_host = config('DATABASE_HOST')
    mysql_port = config('DATABASE_PORT')
    mysql_user = config('DATABASE_USER')
    mysql_password = config('DATABASE_PASSWORD')
    mysql_database = config('DATABASE_NAME')
    try:
        cnx = mysql.connector.connect(user=mysql_user, password=mysql_password, host=mysql_host, port=mysql_port, database=mysql_database)
        cnx.ping(True)
        mysql_status = 200
    except mysql.connector.Error as err:
        mysql_status = 500
    
    data = {
        'mysql': mysql_status,
    }
    
    if all(value == 200 for value in data.values()):
        return JsonResponse(data, status=200)
    else:
        return JsonResponse(data, status=500)

@csrf_exempt
def remove_token(request):
    '''
    Función que remueve el token de la blacklist
    '''
    if request.method == 'POST':
        refresh_token = request.POST.get('refresh_token')
        if functions.remove_tokens(refresh_token):
            return JsonResponse({'message': 'Token removed.'}, status=200)
        else:
            return JsonResponse({'message': 'Token not removed.'}, status=500)
    else:
        return JsonResponse({'message': 'Method not allowed.'}, status=405)

@csrf_exempt
def refresh_token(request):
    '''
    Función que refresca el token
    '''
    if request.method == 'POST':
        refresh_token = request.POST.get('refresh_token')
        access_token = functions.refresh_token(refresh_token)
        if access_token:
            return JsonResponse({'access_token': access_token["access_token"],
                                 'refresh': access_token["refresh"]
                                 }, status=200)
        else:
            return JsonResponse({'message': 'Token not refreshed.'}, status=500)
    else:
        return JsonResponse({'message': 'Method not allowed.'}, status=405)