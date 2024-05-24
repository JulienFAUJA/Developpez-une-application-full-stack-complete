import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Theme } from '../models/theme.model';

@Injectable({
  providedIn: 'root'
})
export class ThemeService {
  pathService="/api/abonnement";
  constructor(private http: HttpClient) { }

  getThemes(): Observable<Theme[]> {
    return this.http.get<Theme[]>('http://localhost:8080/api/theme/all');
  }

  toggleSubscription(id: number): Observable<Theme> {
    return this.http.get<Theme>(`${this.pathService}/subscription/${id}`);
  }
}
