import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl } from '@angular/forms';

@Component({
  selector: 'app-article-create',
  templateUrl: './article-create.component.html',
  styleUrls: ['./article-create.component.scss']
})
export class ArticleCreateComponent implements OnInit {
  articleForm = new FormGroup({
    theme_input: new FormControl(''),
    titre_input: new FormControl(''),
    article_content_textarea: new FormControl(''),
  });

  constructor() { }

  ngOnInit(): void {
  }

  
  onSubmit() {
    console.log(this.articleForm.value);
  }

}
