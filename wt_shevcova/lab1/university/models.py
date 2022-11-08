from django.db import models
from django.urls import reverse
from phonenumber_field.modelfields import PhoneNumberField


class Employee(models.Model):
    name = models.CharField(max_length=100)
    position = models.CharField(max_length=100)
    sex = models.CharField(max_length=20)
    department = models.CharField(max_length=50)
    email = models.EmailField()
    phone_number = PhoneNumberField(unique=True)
    comment = models.TextField()

    def __str__(self):
        return f'{self.name} {self.position}'

    def get_absolute_url(self):
        return reverse('employee-retrieve', kwargs={'pk': self.pk})

