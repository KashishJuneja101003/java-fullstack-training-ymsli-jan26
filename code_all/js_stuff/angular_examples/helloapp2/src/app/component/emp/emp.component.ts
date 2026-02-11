import { Component } from '@angular/core';
import { Employee } from '../../model/employee';
import { EmployeeService } from '../../services/employee.service';
import { CommonModule } from '@angular/common';
import { AuthService } from '../../services/auth.service';

@Component({
  selector: 'app-emp',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './emp.component.html',
  styles: ``
})
export class EmpComponent {
  employees: Employee[] = [];
  employee?: Employee;
  error?: string;


  constructor(private employeeService: EmployeeService,  private authService: AuthService) {}

  login() {
  this.authService.login({
    username: 'raj',
    password: 'raj'
  }).subscribe(() => alert('Logged in'));
}

  // Load all employees
  loadEmployees() {
    this.employeeService.getEmployees().subscribe({
      next: (data) => {
        this.employees = data;
        this.employee = undefined;
        this.error = undefined;
      },
      error: (err) => {
        this.error = err.message;
        this.employees = [];
        this.employee = undefined;
      }
    });
  }


  // Load employee by ID
  loadEmployee(id: number) {
    this.employeeService.getEmployee(id).subscribe({
      next: (data) => {
        this.employee = data;
        this.employees = [];
        this.error = undefined;
      },
      error: (err) => {
        this.error = err.message;
        this.employee = undefined;
      }
    });
  }
}
