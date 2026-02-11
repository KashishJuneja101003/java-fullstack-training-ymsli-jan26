import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { LoginRequest } from '../model/login-request';
import { LoginResponse } from '../model/login-response';
import { tap } from 'rxjs';

@Injectable({ providedIn: 'root' })
export class AuthService {

  private baseUrl = 'http://localhost:8080/auth';

  constructor(private http: HttpClient) {}

  login(req: LoginRequest) {
    return this.http.post<LoginResponse>(`${this.baseUrl}/login`, req)
      .pipe(
        tap(res => localStorage.setItem('token', res.token))
      );
  }

  getToken(): string | null {
    return localStorage.getItem('token');
  }

  logout() {
    localStorage.removeItem('token');
  }
}
