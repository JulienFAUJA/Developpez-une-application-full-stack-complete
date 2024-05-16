import { Component, OnInit } from '@angular/core';
import { User } from '../../interfaces/user.interface';
import { Theme } from '../../interfaces/theme.interface';
import { Commentaire } from '../../interfaces/commentaire.interface';

@Component({
  selector: 'app-article',
  templateUrl: './article.component.html',
  styleUrls: ['./article.component.scss']
})
export class ArticleComponent implements OnInit {

  theme!: Theme;
  titre!: string;
  auteur!: User;
  contenu!: string;
  commentaires!: Commentaire[];
  createdAt!: Date;
  lorem="Lorem ipsum dolor sit amet consectetur adipisicing elit. Vel at corrupti aut voluptate sit accusamus enim excepturi porro quasi non, tempore minus tempora aliquid harum aspernatur perferendis debitis, rerum suscipit.";
  lorems=this.lorem+this.lorem+this.lorem+this.lorem+this.lorem+this.lorem+this.lorem;
  constructor() { }

  ngOnInit(): void {
    this.titre ="Mon titre";
    this.contenu = this.lorems;

    this.createdAt = new Date();
    //this.auteur =null;
    
  }
  
}
