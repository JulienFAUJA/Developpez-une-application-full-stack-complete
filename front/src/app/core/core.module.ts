import { LOCALE_ID, NgModule } from '@angular/core';
import { CommonModule, registerLocaleData } from '@angular/common';
import { HttpClientModule } from '@angular/common/http';
import { HeaderComponent } from './components/header/header.component';
import * as fr from '@angular/common/locales/fr';
import { RouterModule } from '@angular/router';
import { ArticleComponent } from './components/article/article.component';
import { ThemeComponent } from './components/theme/theme.component';
import { MaterialModule } from '../material/material.module';
import { ArticleDetailComponent } from '../pages/article-detail/article-detail.component';
import { ThemesListComponent } from '../pages/themes-list/themes-list.component';
import { ArticlesListComponent } from '../pages/articles-list/articles-list.component';
import { HomeComponent } from '../pages/home/home.component';
import { LoginComponent } from '../pages/login/login.component';
import { RegisterComponent } from '../pages/register/register.component';
import { ReactiveFormsModule } from '@angular/forms';
import { UserComponent } from '../pages/user/user.component';
import { CommentaireComponent } from './components/commentaire/commentaire.component';
import { BackComponent } from './components/back/back.component';
import { HeaderAnonymousComponent } from './components/header-anonymous/header-anonymous.component';
import { ArticleCreateComponent } from '../pages/article-create/article-create.component';

@NgModule({
  declarations: [
    HeaderComponent,
    ArticleComponent,
    ThemeComponent,
    HomeComponent, 
    LoginComponent, 
    RegisterComponent, 
    ArticlesListComponent, 
    ThemesListComponent, 
    ArticleDetailComponent,
    ArticleCreateComponent,
    UserComponent,
    CommentaireComponent,
    BackComponent,
    HeaderAnonymousComponent
  ],
  imports: [
    CommonModule, 
    RouterModule, 
    HttpClientModule,
    MaterialModule,
    ReactiveFormsModule

  ],
  exports: [
    HeaderComponent,
    ArticleComponent,
    ThemeComponent,
    HomeComponent, 
    LoginComponent, 
    RegisterComponent, 
    ArticlesListComponent, 
    ThemesListComponent, 
    ArticleDetailComponent,
    ArticleCreateComponent,
    MaterialModule,
    ReactiveFormsModule
  ],
  providers: [{ provide: LOCALE_ID, useValue: 'fr-FR' }],
})
export class CoreModule {
  constructor() {
    registerLocaleData(fr.default);
  }
}
