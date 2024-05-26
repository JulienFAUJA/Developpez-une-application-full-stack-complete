import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Subject, takeUntil } from 'rxjs';
import { Article } from 'src/app/core/models/article.model';
import { Commentaire } from 'src/app/core/models/commentaire.model';
import { ArticlesService } from 'src/app/core/services/articles.service';

@Component({
  selector: 'app-article-detail',
  templateUrl: './article-detail.component.html',
  styleUrls: ['./article-detail.component.scss']
})
export class ArticleDetailComponent implements OnInit {
  article!:Article;
  commentaires!:Commentaire[];
  article_id!: number | null;
  private destroy$: Subject<boolean> = new Subject();
  error_str!:string;
  constructor(private route: ActivatedRoute,
    private articleService:ArticlesService) {
  
  }

  ngOnInit(): void {
    this.loadArticle();
  }

  
ngOnDestroy(): void {
  this.destroy$.next(true);
  this.destroy$.complete();
}


  loadArticle():void{
    const id = this.route.snapshot.params['id'];
    this.article_id = id ? Number(id) : null;
    this.destroy$ = new Subject<boolean>();

    if (this.article_id) {
      this.articleService
        .detail(this.article_id)
        .pipe(takeUntil(this.destroy$))
        .subscribe({
          next: (articleResponse) => {
            console.log("article:", articleResponse);
            this.article = articleResponse;
            this.commentaires=articleResponse.commentaires;
          },
          error: (error) => {
            this.error_str =
              error ||
              "Une erreur est survenue lors du chargement de l'article";
          },
        });
    }
  

    
  }

}
