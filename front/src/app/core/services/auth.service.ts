import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, tap } from 'rxjs';
import { LoginRequest } from '../interfaces/loginRequest.interface';
import { RegisterRequest } from '../interfaces/registerRequest.interface';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  private pathService = 'http://localhost:8080/api/auth';


  constructor(private httpClient: HttpClient) { }

  public register(registerRequest: RegisterRequest): Observable<any> {
    return this.httpClient.post<RegisterRequest>(`${this.pathService}/register`, registerRequest);
  }

  public login(loginRequest: LoginRequest): Observable<any> {
    return this.httpClient.post<LoginRequest>(`${this.pathService}/login`, loginRequest).pipe(
      tap(response => console.log("Login response: ", response))
    );
  }

  public get_token(): any{
    return localStorage.getItem("token") || null;
  }


}
