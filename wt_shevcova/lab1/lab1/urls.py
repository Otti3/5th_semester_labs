"""lab1 URL Configuration

The `urlpatterns` list routes URLs to views. For more information please see:
    https://docs.djangoproject.com/en/3.1/topics/http/urls/
Examples:
Function views
    1. Add an import:  from my_app import views
    2. Add a URL to urlpatterns:  path('', views.home, name='home')
Class-based views
    1. Add an import:  from other_app.views import Home
    2. Add a URL to urlpatterns:  path('', Home.as_view(), name='home')
Including another URLconf
    1. Import the include() function: from django.urls import include, path
    2. Add a URL to urlpatterns:  path('blog/', include('blog.urls'))
"""
from django.contrib import admin
from django.urls import include, path

from university.views import EmployeeCreateView, EmployeeDetailView
from task3.views import FacultyListView, CourseListView, GroupListView, StudentListView, StudentDetailView
from task4.views import EmployeeListView, CreateEmployeeView

employee_urls = [
    path('', EmployeeCreateView.as_view(), name='employee-create'),
    path('<int:pk>/', EmployeeDetailView.as_view(), name='employee-retrieve')
]

task1_urls = [
    path('employees/', include(employee_urls))
]

task3_urls = [
    path('faculties/', FacultyListView.as_view(), name='faculty-list'),
    path('faculties/<int:pk>', CourseListView.as_view(), name='faculty-retrieve'),
    path('courses/<int:pk>', GroupListView.as_view(), name='course-retrieve'),
    path('groups/<int:pk>', StudentListView.as_view(), name='group-retrieve'),
    path('students/<int:pk>', StudentDetailView.as_view(), name='student-retrieve'),
]

task4_urls = [
    path('organization/<int:pk>', EmployeeListView.as_view(), name='employee-list'),
]

urlpatterns = [
    path('admin/', admin.site.urls),
    path('task1/', include(task1_urls)),
    path('task3/', include(task3_urls)),
    path('task4/', include(task4_urls)),
]
