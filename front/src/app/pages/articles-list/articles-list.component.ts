import { Component, OnInit } from '@angular/core';
import { Observable, Subject, takeUntil } from 'rxjs';
import { Article } from 'src/app/core/models/article.model';
import { ArticlesService } from 'src/app/core/services/articles.service';

@Component({
  selector: 'app-articles-list',
  templateUrl: './articles-list.component.html',
  styleUrls: ['./articles-list.component.scss'],
})
export class ArticlesListComponent implements OnInit {
  isAscending!: boolean;
  articles!: Article[];
  articles$!:Observable<Article[]>;
  private destroy$: Subject<boolean> = new Subject();
  error_str!:string;
  
  constructor(private articleService:ArticlesService) {
  
  }

  getPreferences():void{
    const localStorageAscendingSortPref = localStorage.getItem("isAscending");
    if(localStorageAscendingSortPref){
      this.isAscending = (localStorageAscendingSortPref|| true) as boolean;
    }
    else{
      this.isAscending=true;
      this.setPreferences(this.isAscending);
    }

  }

  setPreferences(current_sort:boolean):void {
    localStorage.setItem("isAscending", current_sort.toString());
  }

  ngOnInit(): void {
    this.getPreferences();
    this.articleService.all().pipe(takeUntil(this.destroy$))
    .subscribe({
      next: (articlesFromServer: Article[]) => {
        this.articles = articlesFromServer;
        this.sortArticles(); // Tri les articles immédiatement après le chargement selon la préférence actuelle
      },
      error: (error) => {
        this.error_str =
          error ||
          "Une erreur est survenue lors du chargement de l'article";
      },
    });
    console.log(this.articles);
    
  }

  toggleSortByDate(): void {
    this.isAscending = !this.isAscending; // Toggle the direction of sorting
    this.sortArticles();
    this.setPreferences(this.isAscending);
  }

  sortArticles(): void {
    if (this.isAscending) {
      // Sort the articles by date in ascending order
      this.articles.sort((a, b) => new Date(a.createdAt).getTime() - new Date(b.createdAt).getTime());
    } else {
      // Sort the articles by date in descending order
      this.articles.sort((a, b) => new Date(b.createdAt).getTime() - new Date(a.createdAt).getTime());
    }
  }
  

  ngOnDestroy(): void {
    this.destroy$.next(true);
    this.destroy$.complete();
  }
}
