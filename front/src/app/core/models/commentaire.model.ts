import { Article } from './article.model';
import { User } from './user.model';

export class Commentaire {
  constructor(
    public article: Article, 
    public auteur: User,
    public contenu: string,
  ) {}
}


