import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Subject, takeUntil, tap } from 'rxjs';
import { ArticleRequest } from 'src/app/core/models/articleRequest.model';
import { Theme } from 'src/app/core/models/theme.model';
import { ArticlesService } from 'src/app/core/services/articles.service';
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
    private router: Router
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
    if (this.articleForm.valid) {  // Vérifie si le formulaire est valide
    this.destroy$ = new Subject<boolean>();
    const articleRequest = this.articleForm.value as ArticleRequest;
    this.articlesService.create(articleRequest)
    .pipe(
      takeUntil(this.destroy$))
    
    .subscribe({
      next: (response) => {
        (this.errorStr = ''),
        this.router.navigate(['article/all']);
      },
      error: (error) => {
        this.errorStr =
          error || '..................Une erreur est survenue lors de la connexion.';

      },
    });
  }
    
    
    
}
ngOnDestroy(): void {
  this.destroy$.next(true);
  this.destroy$.complete();
}
}
