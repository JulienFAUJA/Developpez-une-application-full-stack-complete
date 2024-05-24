import { Component, OnInit } from '@angular/core';
import { Theme } from 'src/app/core/models/theme.model';
import { ThemeService } from 'src/app/core/services/themes.services';

@Component({
  selector: 'app-themes-list',
  templateUrl: './themes-list.component.html',
  styleUrls: ['./themes-list.component.scss']
})
export class ThemesListComponent implements OnInit {
  themes!: Theme[];
  constructor(
    private themesService: ThemeService
  ) {}

  ngOnInit(): void {
    this.loadThemes();
  }

  loadThemes(): void {
    this.themesService.getThemes().subscribe({
      next: (themes) => this.themes = themes,
      error: (error) => console.error('Erreur lors du chargement des thèmes', error)
    });

}
}


        
   