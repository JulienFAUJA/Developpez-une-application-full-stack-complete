import { Component, Input, OnInit } from '@angular/core';
import { User } from '../../models/user.model';
import { Theme } from '../../models/theme.model';
import { Commentaire } from '../../models/commentaire.model';
import { Article } from '../../models/article.model';

@Component({
  selector: 'app-article',
  templateUrl: './article.component.html',
  styleUrls: ['./article.component.scss'],
})
export class ArticleComponent implements OnInit {
  @Input() article!: Article;

 
  constructor() {}

  ngOnInit(): void {
 
  }
}
