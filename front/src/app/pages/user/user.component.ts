import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, FormBuilder, Validators } from '@angular/forms';
import { takeUntil, tap } from 'rxjs';
import { Subject } from 'rxjs/internal/Subject';
import { UserRequest } from 'src/app/core/interfaces/user.interface';
import { Theme } from 'src/app/core/models/theme.model';
import { AuthService } from 'src/app/core/services/auth.service';
import { ThemeService } from 'src/app/core/services/themes.services';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.scss'],
})
export class UserComponent implements OnInit {
  public userForm!:FormGroup;
  private destroy$: Subject<boolean> = new Subject();
  errorStr: string = '';
  themes!: Theme[];
  public user!:UserRequest;

  constructor(private authService: AuthService,
              private themesService: ThemeService,
              private fb: FormBuilder
  ) { }

  ngOnInit(): void {
   this.userForm = this.fb.group({
     
      name: [''],
      email:['', [Validators.email]],
      
    });
      this.get();
    }

    get(){
      this.authService.get_profile() .pipe(
        takeUntil(this.destroy$))
      
      .subscribe({
        next: (response:any) => {
          tap(response => console.log),
          this.user=response;
          this.userForm.setValue({
            name:response.user.name,
            email:response.user.email
          }),
          this.themes=response.subscribedThemes;
            
        },
        error: (error) => {
          this.errorStr =
            error || '..................Une erreur est survenue lors de la connexion.';
        },
      });
    }
  
    loadThemes(): void {
      this.themesService.getThemesForUser().subscribe({
        next: (themes) => this.themes = themes,
        error: (error) => console.error('Erreur lors du chargement des thèmes', error)
      });
    }
  
    onLogOut():void{
      this.authService.logOut();
    }


  onSubmit() {
    this.destroy$ = new Subject<boolean>();
    const userRequest = this.userForm.value as UserRequest;
    this.authService.update(userRequest)
    .pipe(
      takeUntil(this.destroy$))
    .subscribe({
      next: (response) => {
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
