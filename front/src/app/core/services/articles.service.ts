import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Article } from '../models/article.model';
import { AuthService } from './auth.service';
import { ArticleRequest } from '../models/articleRequest.model';

@Injectable({
  providedIn: 'root',
})
export class ArticlesService {
  private pathService = 'http://localhost:8080/api/article';

  constructor(private httpClient: HttpClient, 
              private authService: AuthService
            ) {}

  public all(): Observable<Article[]> {
    const token = localStorage.getItem('token');
    console.log("token:"+token);
    return this.httpClient.get<Article[]>(`${this.pathService}/all`);
  }

  public detail(id: number): Observable<Article> {
    return this.httpClient.get<Article>(`${this.pathService}/detail/${id}`);
  }

  public create(article: ArticleRequest): Observable<Article> {
    const token = localStorage.getItem('token');
    console.log("token:"+token);
    if (!token) {
      this.authService.logOut();
    }
    const headers = new HttpHeaders({ Authorization: `Bearer ${token}` });
    return this.httpClient.post<Article>(`${this.pathService}/create`, article, {
      headers});
  }
}
