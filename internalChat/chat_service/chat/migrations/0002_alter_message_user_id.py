# Generated by Django 3.2.12 on 2023-03-27 15:43

from django.db import migrations, models


class Migration(migrations.Migration):

    dependencies = [
        ('chat', '0001_initial'),
    ]

    operations = [
        migrations.AlterField(
            model_name='message',
            name='user_id',
            field=models.IntegerField(),
        ),
    ]
