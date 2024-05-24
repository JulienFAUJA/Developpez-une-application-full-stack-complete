import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Commentaire } from '../models/commentaire.model';
import { AuthService } from './auth.service';
import { SessionService } from './session.service';
import { CommentaireRequest } from '../models/commentaireRequest.model';

@Injectable({
  providedIn: 'root',
})
export class CommentairesService {
  private pathService = 'http://localhost:8080/api/commentaire';

  constructor(private httpClient: HttpClient, 
              private authService: AuthService,
              private sessionService: SessionService,
            ) {}

  
  public create(commentaire: CommentaireRequest): Observable<Commentaire> {
    const token = localStorage.getItem('token');
    if (!token) {
      this.sessionService.logOut();
    }
    const headers = new HttpHeaders({ Authorization: `Bearer ${token}` });
    return this.httpClient.post<Commentaire>(`${this.pathService}/create`, commentaire, {
      headers});
  }
}
