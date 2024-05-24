import { Component, Input, OnInit } from '@angular/core';
import { Theme } from '../../models/theme.model';
import { ThemeService } from '../../services/themes.services';


@Component({
  selector: 'app-theme',
  templateUrl: './theme.component.html',
  styleUrls: ['./theme.component.scss']
})
export class ThemeComponent implements OnInit {
  @Input() theme!:Theme;
  constructor(private themeService:ThemeService) { }

  ngOnInit(): void {
  }

  toggleSubscription(themeId: number | undefined): void {
    if(themeId != undefined){ 
      this.themeService.toggleSubscription(themeId);
    }
  }

}
