import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Article } from '../models/article.model';
import { AuthService } from './auth.service';
import { SessionService } from './session.service';

@Injectable({
  providedIn: 'root',
})
export class ArticlesService {
  private pathService = 'http://localhost:8080/api/article';

  constructor(private httpClient: HttpClient, 
              private authService: AuthService,
              private sessionService: SessionService,
            ) {}

  public all(): Observable<Article[]> {
    return this.httpClient.get<Article[]>(`${this.pathService}/all`);
  }

  public detail(id: number): Observable<Article> {
    return this.httpClient.get<Article>(`${this.pathService}/detail/${id}`);
  }

  public create(article: Article): Observable<Article> {
    const token = localStorage.getItem('token');
    if (!token) {
      this.sessionService.logOut();
    }
    const headers = new HttpHeaders({ Authorization: `Bearer ${token}` });
    return this.httpClient.post<Article>(`${this.pathService}/create`, article, {
      headers});
  }
}
