#!/bin/bash

# Create superuser
#export DJANGO_SUPERUSER_PASSWORD=XXXXXXX
#export DJANGO_SUPERUSER_USERNAME=XXXXXXX
#export DJANGO_SUPERUSER_EMAIL=XXXXXXX
#python3 manage.py createsuperuser --noinput

# Run server
python3 manage.py migrate
python3 manage.py runserver 0.0.0.0:7000