import { Component, OnInit } from '@angular/core';
import { ArticleComponent } from 'src/app/core/components/article/article.component';
import { Article } from 'src/app/core/interfaces/article.interface';

@Component({
  selector: 'app-articles-list',
  templateUrl: './articles-list.component.html',
  styleUrls: ['./articles-list.component.scss']
})
export class ArticlesListComponent implements OnInit {
  isAscending: boolean = true;
  articles!:ArticleComponent[];
  constructor() { }

  ngOnInit(): void {
  }

}
