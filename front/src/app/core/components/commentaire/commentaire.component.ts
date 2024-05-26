import { Component, Input, OnInit } from '@angular/core';
import { Commentaire } from '../../models/commentaire.model';

@Component({
  selector: 'app-commentaire',
  templateUrl: './commentaire.component.html',
  styleUrls: ['./commentaire.component.scss'],
})
export class CommentaireComponent implements OnInit {
  @Input() commentaire!: Commentaire;
  screen_orientation!: string;

  constructor() {}

  
  ngOnInit(): void {
    this.screen_orientation = window.screen.orientation.type;
    window.addEventListener('orientationchange', this.updateOrientation);
    this.updateOrientation(); // Appel initial pour définir l'orientation
  }

  ngOnDestroy(): void {
    window.removeEventListener('orientationchange', this.updateOrientation);
  }

  updateOrientation = (): void => {
    this.screen_orientation = window.screen.orientation.type;
  };

}
