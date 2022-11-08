from django.shortcuts import render
from django.views.generic import ListView, DetailView

from .models import Faculty, Course, Group, Student


class FacultyListView(ListView):
    model = Faculty
    template_name = 'faculty_list.html'


class CourseListView(ListView):
    model = Course
    template_name = 'course_list.html'

    def get_queryset(self):
        return self.model.objects.filter(faculty_id=self.kwargs['pk'])

    def get_context_data(self, *, object_list=None, **kwargs):
        context = super().get_context_data(**kwargs)
        context['faculty'] = self.get_queryset().first().faculty
        return context


class GroupListView(ListView):
    model = Group
    template_name = 'group_list.html'

    def get_queryset(self):
        return self.model.objects.filter(course_id=self.kwargs['pk'])

    def get_context_data(self, *, object_list=None, **kwargs):
        context = super().get_context_data(**kwargs)
        context['course'] = self.get_queryset().first().course
        return context


class StudentListView(ListView):
    model = Student
    template_name = 'student_list.html'

    def get_queryset(self):
        return self.model.objects.filter(group_id=self.kwargs['pk'])

    def get_context_data(self, *, object_list=None, **kwargs):
        context = super().get_context_data(**kwargs)
        context['group'] = self.get_queryset().first().group
        return context


class StudentDetailView(DetailView):
    model = Student
    template_name = 'student.html'