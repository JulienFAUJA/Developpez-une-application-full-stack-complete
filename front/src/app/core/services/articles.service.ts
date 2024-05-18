import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Article } from '../models/article.model';

@Injectable({
  providedIn: 'root',
})
export class ArticlesService {
  private pathService = 'api/article';

  constructor(private httpClient: HttpClient) {}
  public all(): Observable<Article[]> {
    return this.httpClient.get<Article[]>(this.pathService);
  }

  public detail(id: string): Observable<Article> {
    return this.httpClient.get<Article>(`${this.pathService}/${id}`);
  }

  public create(session: Article): Observable<Article> {
    return this.httpClient.post<Article>(this.pathService, session);
  }
}
