import { Component, OnInit } from '@angular/core';
import {
  ReactiveFormsModule,
  FormGroup,
  FormBuilder,
  Validators,
} from '@angular/forms';
import { Router } from '@angular/router';
import { Subject, takeUntil, tap } from 'rxjs';
import { LoginRequest } from 'src/app/core/interfaces/loginRequest.interface';
import { AuthService } from 'src/app/core/services/auth.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss'],
})
export class LoginComponent implements OnInit{
  public loginForm!:FormGroup;
  private destroy$: Subject<boolean> = new Subject();
  errorStr: string = '';



  constructor(
    private authService: AuthService,
    private fb: FormBuilder,
    private router: Router ) {}

  ngOnInit():void{
    
    this.loginForm = this.fb.group({
     
      email:['', [Validators.required, Validators.email]],
      password: ['', [Validators.required]],
      
    });

  }

  onSubmitForm():void {
    this.destroy$ = new Subject<boolean>();
    const loginRequest = this.loginForm.value as LoginRequest;
    this.authService.login(loginRequest)
    .pipe(
      takeUntil(this.destroy$))
    
    .subscribe({
      next: (response) => {
        tap((response) => console.log('[LoginComponent] Login response: ', response)),
          localStorage.setItem('token', response.token);
          this.router.navigate(['article/all']);
      },
      error: (error) => {
        this.errorStr =
          error || '..................Une erreur est survenue lors de la connexion.';
      },
    });
    
    
    
}
ngOnDestroy(): void {
  this.destroy$.next(true);
  this.destroy$.complete();
}
}
