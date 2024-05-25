import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { Theme } from '../../models/theme.model';
import { AbonnementService } from '../../services/abonnements.service';


@Component({
  selector: 'app-theme',
  templateUrl: './theme.component.html',
  styleUrls: ['./theme.component.scss']
})
export class ThemeComponent implements OnInit {
  @Input() theme!:Theme;
  @Output() subscriptionChanged = new EventEmitter<void>();  // Émetteur d'événements
  constructor(private abonnementService:AbonnementService) { }

  ngOnInit(): void {
  }

  toggleSubscription(themeId: number | undefined): void {
    if (themeId !== undefined) { 
      this.abonnementService.toggleSubscription(themeId).subscribe({
        next: (response) => {
          console.log(response);  
          this.theme.isSubscribed = !this.theme.isSubscribed;  // Supposer une modification de l'état ici
          this.subscriptionChanged.emit();  // Émet l'événement après changement
        },
        error: (error) => console.error('Erreur lors de la modification de l’abonnement', error)
      });
    }
  }

}
