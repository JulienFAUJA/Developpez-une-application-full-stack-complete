import { Component, Input, OnInit } from '@angular/core';
import { Theme } from '../../models/theme.model';
import { AbonnementService } from '../../services/abonnements.service';


@Component({
  selector: 'app-theme',
  templateUrl: './theme.component.html',
  styleUrls: ['./theme.component.scss']
})
export class ThemeComponent implements OnInit {
  @Input() theme!:Theme;
  constructor(private abonnementService:AbonnementService) { }

  ngOnInit(): void {
  }

  toggleSubscription(themeId: number | undefined): void {
    if (themeId !== undefined) { 
      this.abonnementService.toggleSubscription(themeId).subscribe({
        next: (response) => {
          console.log(response);  
          this.theme.isSubscribed = !this.theme.isSubscribed;  // Supposer une modification de l'état ici
        },
        error: (error) => console.error('Erreur lors de la modification de l’abonnement', error)
      });
    }
  }

}
