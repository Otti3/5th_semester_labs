from django.urls import reverse
from django.views.generic.edit import CreateView
from django.views.generic import DetailView

from .models import Employee


class EmployeeCreateView(CreateView):
    model = Employee
    template_name = 'employee_form.html'
    fields = "__all__"

    # def get_success_url(self):
    #     return reverse('employee-retrieve', kwargs={'id': self.object.pk})


class EmployeeDetailView(DetailView):
    model = Employee
    template_name = 'employee.html'

