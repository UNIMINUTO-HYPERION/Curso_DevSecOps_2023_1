#obtenemos la imagen de un kernel de Linux con python
FROM python:3.10-slim-bullseye
# ENV FLASK_ENV=production
# ENV PROD_DATABASE_URI=""
ENV PYTHONUNBUFFERED=1
ENV PATH=$PATH:/home/djangoapp/.local/bin

#crea usuario
RUN useradd --create-home --home-dir /home/djangoapp djangoapp

#seleccionar la carpeta de usuario
WORKDIR /home/djangoapp
#instala dependencias del sistema
RUN apt-get update

#! AGREGAR AQUI LAS DEPENDENCIAS REDIS??
RUN apt-get install -y curl gcc g++ libffi-dev libssl-dev build-essential default-mysql-client python3-mysqldb libmariadb-dev
RUN apt-get install -y inetutils-ping

RUN apt-get purge -y --auto-remove -o APT::AutoRemove::RecommendsImportant=false
RUN rm -rf /var/lib/apt/lists/*

USER djangoapp
RUN mkdir app
#copia la carpeta del proyecto a la imagen
COPY ./chat_service /home/djangoapp/chat_service
COPY ./chat /home/djangoapp/chat
COPY ./manage.py /home/djangoapp/
COPY ./entrypoint.sh /home/djangoapp/entrypoint.sh

# TODO: cambiar por requirements_production.txt
ADD requirements_prod.txt ./requirements.txt

RUN pip install --no-cache-dir -r requirements.txt
# RUN pip install gevent gunicorn==20.1.0

#puerto por el que escucha la imagen
EXPOSE 7000

#HEALTHCHECK --interval=10s --timeout=10s --start-period=55s 
#CMD curl -f --retry 10 -- max-time 15 --retry-delay 10 --retry-max-time 60 "http://localhost:5000/api/v1/health" || exit 1   

#ejecuta la aplicación
#CMD ["gunicorn", "--workers", "1", "--log-level", "INFO", "--bind", "0.0.0.0:5000", "app:create_app()"]
# RUN python3 manage.py migrate

CMD ["/home/djangoapp/entrypoint.sh"]