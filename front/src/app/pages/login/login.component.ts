import { Component } from '@angular/core';
import { FormGroup, FormControl, FormBuilder } from '@angular/forms';
import { Router } from '@angular/router';
import { LoginRequest } from 'src/app/core/interfaces/loginRequest.interface';
import { SessionInformation } from 'src/app/core/interfaces/sessionInformation.interface';
import { AuthService } from 'src/app/core/services/auth.service';
import { SessionService } from 'src/app/core/services/session.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent {

  /*
  public form = this.fb.group({
    email: ['', [Validators.required, Validators.email]],
    password: ['', [Validators.required, Validators.min(3)]],
  });
*/
public hide = true;
public onError = false;
  loginForm = new FormGroup({
    emailOrUsername: new FormControl(''),
    password: new FormControl(''),
  });

  constructor(private authService: AuthService,
    private fb: FormBuilder,
    private router: Router,
    private sessionService: SessionService){
      
    }

  onSubmit() {
    console.log(this.loginForm.value);
    const loginRequest = this.loginForm.value as LoginRequest;
  this.authService.login(loginRequest).subscribe({
    next: (response: SessionInformation) => {
      this.sessionService.logIn(response);
      this.router.navigate(['/sessions']);
    },
    error: (error) => (this.onError = true),
  });
  }
}

