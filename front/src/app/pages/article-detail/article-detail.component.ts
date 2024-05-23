import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Observable, Subject, takeUntil } from 'rxjs';
import { Article } from 'src/app/core/models/article.model';
import { Commentaire } from 'src/app/core/models/commentaire.model';
import { Theme } from 'src/app/core/models/theme.model';
import { User } from 'src/app/core/models/user.model';
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
    const id = this.route.snapshot.params['id'];
    this.article_id = id ? Number(id) : null;
    this.destroy$ = new Subject<boolean>();

    if (this.article_id) {
      this.articleService
        .detail(this.article_id)
        .pipe(takeUntil(this.destroy$))
        .subscribe({
          next: (articleResponse) => {
            this.article = articleResponse;
          },
          error: (error) => {
            this.error_str =
              error ||
              "Une erreur est survenue lors du chargement de l'article";
          },
        });
    }
  

    this.commentaires=[];
  }

}
