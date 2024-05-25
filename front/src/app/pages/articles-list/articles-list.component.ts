import { Component, OnInit } from '@angular/core';
import { Observable, Subject, takeUntil } from 'rxjs';
import { Article } from 'src/app/core/models/article.model';
import { Theme } from 'src/app/core/models/theme.model';
import { User } from 'src/app/core/models/user.model';
import { ArticlesService } from 'src/app/core/services/articles.service';

@Component({
  selector: 'app-articles-list',
  templateUrl: './articles-list.component.html',
  styleUrls: ['./articles-list.component.scss'],
})
export class ArticlesListComponent implements OnInit {
  isAscending: boolean = true;
  articles!: Article[];
  articles$!:Observable<Article[]>;
  private destroy$: Subject<boolean> = new Subject();
  error_str!:string;
  
  constructor(private articleService:ArticlesService) {
  
  }

  ngOnInit(): void {
    this.articleService.all().pipe(takeUntil(this.destroy$))
    .subscribe({
      next: (articlesFromServer: Article[]) => {
        this.articles = articlesFromServer;
      },
      error: (error) => {
        this.error_str =
          error ||
          "Une erreur est survenue lors du chargement de l'article";
      },
    });
    console.log(this.articles);
    
    /*[
      {
        theme: new Theme("Javascript", "Langage de programmation côté client pour le web..."),
        titre: 'Maitriser Javascript',
        auteur: new User("julienfaujanet@gmail.com", "JulienFAUJA", "1234", new Date()),
        contenu:'Lorem ipsum dolor sit amet consectetur adipisicing elit. Vel at corrupti aut voluptate sit accusamus enim excepturi porro quasi non, tempore minus tempora aliquid harum aspernatur perferendis debitis, rerum suscipit.',
        commentaires: [],
        createdAt: new Date("2024-05-16T10:00:00")
      },
      {
        theme: new Theme("Python", "Langage de script, utilisé pour le prototypage et le domaine scientifique, nottement l'intelligence artificielle..."),
        titre: 'Comment bien débuter avec Python',
        auteur: new User("julienfaujanet@gmail.com", "JulienFAUJA", "1234", new Date()),
        contenu:'Lorem ipsum dolor sit amet consectetur adipisicing elit. Vel at corrupti aut voluptate sit accusamus enim excepturi porro quasi non, tempore minus tempora aliquid harum aspernatur perferendis debitis, rerum suscipit.',
        commentaires: [],
        createdAt: new Date("2024-05-10T10:00:00")
      },
      {
        theme: new Theme("Rust", "Langage ayant pour vocation de remplacer le C/C++ dans le but de sécuriser les logiciels dans le domaine des fuites mémoires..."),
        titre: 'Trust the Rust',
        auteur: new User("julienfaujanet@gmail.com", "JulienFAUJA", "1234", new Date()),
        contenu:'Lorem ipsum dolor sit amet consectetur adipisicing elit. Vel at corrupti aut voluptate sit accusamus enim excepturi porro quasi non, tempore minus tempora aliquid harum aspernatur perferendis debitis, rerum suscipit.',
        commentaires: [],
        createdAt: new Date("2024-05-17T11:05:00")
      },
      {
        theme: new Theme("C++", "Langage de programmation très rapide mais aussi assez complexe à apprendre..."),
        titre: 'Comment créer des logiciels en C++',
        auteur: new User("julienfaujanet@gmail.com", "JulienFAUJA", "1234", new Date()),
        contenu:'Lorem ipsum dolor sit amet consectetur adipisicing elit. Vel at corrupti aut voluptate sit accusamus enim excepturi porro quasi non, tempore minus tempora aliquid harum aspernatur perferendis debitis, rerum suscipit.',
        commentaires: [],
        createdAt: new Date("2024-05-11T11:00:00")
      },
      {
        theme: new Theme("CSS", "Langage web utilisé pour le style des pages web..."),
        titre: 'Comment créer des feuilles de styles',
        auteur: new User("julienfaujanet@gmail.com", "JulienFAUJA", "1234", new Date()),
        contenu:'Lorem ipsum dolor sit amet consectetur adipisicing elit. Vel at corrupti aut voluptate sit accusamus enim excepturi porro quasi non, tempore minus tempora aliquid harum aspernatur perferendis debitis, rerum suscipit.',
        commentaires: [],
        createdAt: new Date("2024-05-12T12:10:00")
      }
    ]*/
  }

  ngOnDestroy(): void {
    this.destroy$.next(true);
    this.destroy$.complete();
  }
}
