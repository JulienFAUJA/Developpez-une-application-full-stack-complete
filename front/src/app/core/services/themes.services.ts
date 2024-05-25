import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Theme } from '../models/theme.model';

@Injectable({
  providedIn: 'root',
})
export class ThemeService {
  pathService = 'http://localhost:8080/api/theme';
  constructor(private http: HttpClient) {}

  getThemes(): Observable<Theme[]> {
    return this.http.get<Theme[]>(`${this.pathService}/all`);
  }

  getThemesForUser(): Observable<Theme[]> {
    return this.http.get<Theme[]>(`${this.pathService}/user`);
  }
}
