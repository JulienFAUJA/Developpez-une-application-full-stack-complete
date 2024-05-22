import { Component, OnInit } from '@angular/core';
import {
  ReactiveFormsModule,
  FormGroup,
  FormControl,
  FormBuilder,
  Validators,
} from '@angular/forms';
import { Router } from '@angular/router';
import { LoginRequest } from 'src/app/core/interfaces/loginRequest.interface';
import { SessionInformation } from 'src/app/core/interfaces/sessionInformation.interface';
import { AuthService } from 'src/app/core/services/auth.service';
import { SessionService } from 'src/app/core/services/session.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss'],
})
export class LoginComponent implements OnInit{
  public hide = true;
  public onError = false;
  public loginForm!:FormGroup;
  

  constructor(
    private authService: AuthService,
    private fb: FormBuilder,
    private router: Router,
    private sessionService: SessionService
  ) {}

  ngOnInit():void{

    this.loginForm = this.fb.group({
     
      email:['', [Validators.required, Validators.email]],
      password: ['', [Validators.required, Validators.minLength(6)]],
       /*
      email:[null],
      password: [null]
      */
    });

  }

  onSubmitForm():void {
    console.log(this.loginForm.value);
    
    const loginRequest = this.loginForm.value as LoginRequest;
    this.authService.login(loginRequest).subscribe();
    this.router.navigate(['/article/all']);
    
}
}
