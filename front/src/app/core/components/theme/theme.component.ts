import { Component, Input, OnInit } from '@angular/core';
import { Theme } from '../../models/theme.model';

@Component({
  selector: 'app-theme',
  templateUrl: './theme.component.html',
  styleUrls: ['./theme.component.scss']
})
export class ThemeComponent implements OnInit {
  @Input() theme!:Theme;
  constructor() { }

  ngOnInit(): void {
  }

}
