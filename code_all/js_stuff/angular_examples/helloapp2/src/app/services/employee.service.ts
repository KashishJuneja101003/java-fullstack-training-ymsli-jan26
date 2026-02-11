import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { catchError, Observable, throwError } from 'rxjs';
import { Employee } from '../model/employee';
import { ApiError } from '../model/api-error';

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {
private baseUrl = 'http://localhost:8080/api/employees';

  constructor(private http: HttpClient) {}

  getEmployees(): Observable<Employee[]> {
    return this.http.get<Employee[]>(this.baseUrl)
      .pipe(catchError(this.handleError));
  }

  getEmployee(id: number): Observable<Employee> {
    return this.http.get<Employee>(`${this.baseUrl}/${id}`)
      .pipe(catchError(this.handleError));
  }

  private handleError(error: HttpErrorResponse) {
    let errMsg = 'Unknown error';

    if (error.error && error.error.message) {
      const apiError = error.error as ApiError;
      errMsg = apiError.message;
    } else if (error.message) {
      errMsg = error.message;
    }

    return throwError(() => new Error(errMsg));
  }
}
