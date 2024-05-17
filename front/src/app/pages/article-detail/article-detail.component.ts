import { Component, OnInit } from '@angular/core';
import { Article } from 'src/app/core/models/article.model';
import { Commentaire } from 'src/app/core/models/commentaire.model';
import { Theme } from 'src/app/core/models/theme.model';
import { User } from 'src/app/core/models/user.model';

@Component({
  selector: 'app-article-detail',
  templateUrl: './article-detail.component.html',
  styleUrls: ['./article-detail.component.scss']
})
export class ArticleDetailComponent implements OnInit {
  article!:Article;
  commentaires!:Commentaire[];
  auteur=new User("julienfaujanet@gmail.com", "JulienFAUJA", "1234", new Date());
  contenu_lorem= 'Pas mal du tout ce truc... Lorem ipsum dolor sit amet consectetur adipisicing elit. Vel at corrupti aut voluptate sit accusamus enim excepturi porro quasi non, tempore minus tempora aliquid harum aspernatur perferendis debitis, rerum suscipit.';
  constructor() { }

  ngOnInit(): void {
    this.article={
      theme: new Theme("Javascript", "Langage de programmation côté client pour le web..."),
      titre: 'Maitriser Javascript',
      auteur: this.auteur,
      contenu:'Lorem ipsum dolor sit amet consectetur adipisicing elit. Vel at corrupti aut voluptate sit accusamus enim excepturi porro quasi non, tempore minus tempora aliquid harum aspernatur perferendis debitis, rerum suscipit.',
      commentaires: [],
      createdAt: new Date("2024-05-16T10:00:00")
    };
    this.commentaires=[
      {
        article: undefined,
        auteur: this.auteur,
        contenu: this.contenu_lorem+this.contenu_lorem+this.contenu_lorem+this.contenu_lorem,
        
      },
      {
        article: undefined,
        auteur: this.auteur,
        contenu: this.contenu_lorem+this.contenu_lorem+this.contenu_lorem+this.contenu_lorem,
        
      },
      {
        article: undefined,
        auteur: this.auteur,
        contenu: this.contenu_lorem+this.contenu_lorem+this.contenu_lorem+this.contenu_lorem,
        
      }
    ]
  }

}
