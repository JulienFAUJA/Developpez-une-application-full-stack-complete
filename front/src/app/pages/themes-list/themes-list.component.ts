import { Component, OnInit } from '@angular/core';
import { Theme } from 'src/app/core/models/theme.model';

@Component({
  selector: 'app-themes-list',
  templateUrl: './themes-list.component.html',
  styleUrls: ['./themes-list.component.scss']
})
export class ThemesListComponent implements OnInit {
  themes!: Theme[];
  constructor() { }

  ngOnInit(): void {
    this.themes=[
      {
        theme: 'Python',
        description:"Langage de script, utilisé pour le prototypage et le domaine scientifique, nottement l'intelligence artificielle..."
      },
      {
        theme: 'Javascript',
        description:"Langage de programmation côté client pour le web..."
      },
      {
        theme: 'Rust',
        description:"Langage ayant pour vocation de remplacer le C/C++ dans le but de sécuriser les logiciels dans le domaine des fuites mémoires..."
      },
      {
        theme: 'C++',
        description:"Langage de programmation très rapide mais aussi assez complexe à apprendre..."
      },
      {
        theme: 'CSS',
        description:"Langage web utilisé pour le style des pages web..."
      },
    ]
  }

}



        
   