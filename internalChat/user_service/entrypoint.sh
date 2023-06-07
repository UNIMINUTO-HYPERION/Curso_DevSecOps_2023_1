#!/bin/bash

# Create superuser
#export DJANGO_SUPERUSER_USERNAME=Cami
#export DJANGO_SUPERUSER_PASSWORD=123456
#python3 manage.py createsuperuser --noinput
#python3 manage.py makemigrations #solo en caso de error para ejecutar migracio de bd
#python3 manage.py migrate

# Run server
python3 manage.py migrate
python3 manage.py runserver 0.0.0.0:9000