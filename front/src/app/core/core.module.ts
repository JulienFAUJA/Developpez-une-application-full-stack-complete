import { LOCALE_ID, NgModule } from '@angular/core';
import { CommonModule, registerLocaleData } from '@angular/common';
import { HttpClientModule } from '@angular/common/http';
import { HeaderComponent } from './components/header/header.component';
import * as fr from '@angular/common/locales/fr';
import { RouterModule } from '@angular/router';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatIconModule } from '@angular/material/icon';
import { MatListModule } from '@angular/material/list';
import { ArticleComponent } from './components/article/article.component';
import { ThemeComponent } from './components/theme/theme.component';


@NgModule({
  declarations: [
    HeaderComponent,
    ArticleComponent,
    ThemeComponent
  ],
  imports: [
    CommonModule, 
    RouterModule, 
    HttpClientModule,
    MatToolbarModule,
    MatIconModule,
    MatListModule
  ],
  exports: [
    HeaderComponent,
    MatToolbarModule,
    MatIconModule,
    MatListModule
  ],
  providers: [{ provide: LOCALE_ID, useValue: 'fr-FR' }],
})
export class CoreModule {
  constructor() {
    registerLocaleData(fr.default);
  }
}
