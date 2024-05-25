import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, tap } from 'rxjs';
import { LoginRequest } from '../interfaces/loginRequest.interface';
import { RegisterRequest } from '../interfaces/registerRequest.interface';
import { UserRequest } from '../interfaces/user.interface';
import { Router } from '@angular/router';
import { Token } from '../interfaces/token.interface';

@Injectable({
  providedIn: 'root',
})
export class AuthService {
  private pathService = 'http://localhost:8080/api/auth';

  constructor(private httpClient: HttpClient,
              private router: Router
  ) {}

  public register(registerRequest: RegisterRequest): Observable<Token> {
    return this.httpClient.post<Token>(
      `${this.pathService}/register`,
      registerRequest
    );
  }

  public login(loginRequest: LoginRequest): Observable<Token> {
    return this.httpClient
      .post<Token>(`${this.pathService}/login`, loginRequest)
      .pipe(tap((response) => console.log('[AuthService] Login response: ', response.token)));
  }

  public update(userRequest: UserRequest): Observable<string> {
    return this.httpClient
      .put<string>(`${this.pathService}/update`, userRequest)
      .pipe(tap((response) => console.log('Update response: ', response)));
  }

  public get_profile(): Observable<UserRequest> {
    return this.httpClient
      .get<UserRequest>(`${this.pathService}/profile`)
      .pipe(tap((response) => console.log('Get response: ', response)));
  }

  public get_token(): string | null {
    return localStorage.getItem('token') || null;
  }

  public logOut(): void{
    localStorage.clear();
    this.router.navigate(['']);

  }
}
