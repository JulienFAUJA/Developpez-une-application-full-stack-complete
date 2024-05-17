import { LOCALE_ID, NgModule } from '@angular/core';
import { CommonModule, registerLocaleData } from '@angular/common';
import { HttpClientModule } from '@angular/common/http';
import { HeaderComponent } from './components/header/header.component';
import * as fr from '@angular/common/locales/fr';
import { RouterModule } from '@angular/router';
import { ArticleComponent } from './components/article/article.component';
import { ThemeComponent } from './components/theme/theme.component';
import { MaterialModule } from '../material/material.module';

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
    MaterialModule

  ],
  exports: [
    HeaderComponent,
    ArticleComponent,
    ThemeComponent,
    MaterialModule
  ],
  providers: [{ provide: LOCALE_ID, useValue: 'fr-FR' }],
})
export class CoreModule {
  constructor() {
    registerLocaleData(fr.default);
  }
}
