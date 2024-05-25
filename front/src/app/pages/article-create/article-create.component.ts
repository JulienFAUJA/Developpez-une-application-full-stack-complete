import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Subject, takeUntil, tap } from 'rxjs';
import { ArticleRequest } from 'src/app/core/models/articleRequest.model';
import { Theme } from 'src/app/core/models/theme.model';
import { ArticlesService } from 'src/app/core/services/articles.service';
import { SessionService } from 'src/app/core/services/session.service';
import { ThemeService } from 'src/app/core/services/themes.services';

@Component({
  selector: 'app-article-create',
  templateUrl: './article-create.component.html',
  styleUrls: ['./article-create.component.scss']
})
export class ArticleCreateComponent implements OnInit {
  public articleForm!:FormGroup;
  private destroy$: Subject<boolean> = new Subject();
  errorStr: string = '';
  themes: Theme[] = [];  // Tableau pour stocker les thèmes


  constructor(
    private themesService: ThemeService,
    private articlesService: ArticlesService,
    private fb: FormBuilder,
    private router: Router,
    private sessionService: SessionService
  ) {}

  ngOnInit():void{
    
    this.articleForm = this.fb.group({
     
      theme:['', [Validators.required]],
      titre: ['', [Validators.required]],
      contenu: ['', [Validators.required]],
      
    });
    this.loadThemes();
  }

  loadThemes(): void {
    this.themesService.getThemes().subscribe({
      next: (themes) => this.themes = themes,
      error: (error) => console.error('Erreur lors du chargement des thèmes', error)
    });
  }
  onSubmitForm():void {
    console.log("form.value: ",this.articleForm.value);
    this.destroy$ = new Subject<boolean>();
    const articleRequest = this.articleForm.value as ArticleRequest;
    console.log("articleRequest: ",articleRequest);
    this.articlesService.create(articleRequest)
    .pipe(
      takeUntil(this.destroy$))
    
    .subscribe({
      next: (response) => {
        (this.errorStr = ''),
        console.log(response);
        this.router.navigate(['article/all']);
          
      },
      error: (error) => {
        this.errorStr =
          error || '..................Une erreur est survenue lors de la connexion.';
          console.log("erreur: ", this.errorStr);
          //console.log("token: ", this.errorStr.text);
      },
    });
    
    
    
}
ngOnDestroy(): void {
  this.destroy$.next(true);
  this.destroy$.complete();
}
}
