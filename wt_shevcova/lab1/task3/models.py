from django.db import models


class Faculty(models.Model):
    name = models.CharField(max_length=30)

    def __str__(self):
        return self.name


class Course(models.Model):
    value = models.PositiveIntegerField()
    faculty = models.ForeignKey(Faculty, on_delete=models.PROTECT)

    def __str__(self):
        return f'{self.faculty}; {self.value} course'


class Group(models.Model):
    name = models.CharField(max_length=50)
    course = models.ForeignKey(Course, on_delete=models.PROTECT)

    def __str__(self):
        return f'{self.course}; {self.name} group'


class Student(models.Model):
    fio = models.CharField(max_length=150)
    group = models.ForeignKey(Group, on_delete=models.PROTECT)

    def __str__(self):
        return f'{self.group}; {self.fio}'


