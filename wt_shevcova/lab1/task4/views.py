from django.views.generic import ListView
from django.views.generic.edit import CreateView, DeleteView, UpdateView

from .models import Employee


class EmployeeListView(ListView):
    model = Employee
    template_name = 'employees.html'

    def get_queryset(self):
        return self.model.objects.filter(organization_id=self.kwargs['pk'])


class CreateEmployeeView(CreateView):
    model = Employee
    template_name = 'employee_form.html'
    fields = ['name']


class UpdateEmployeeView(UpdateView):
    model = Employee
    fields = ['name']


class DeleteEmployeeView(DeleteView):
    model = Employee
