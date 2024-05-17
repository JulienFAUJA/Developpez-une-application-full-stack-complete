import { Article } from './article.model';
import { User } from './user.model';

export class Commentaire {
  constructor(
    public auteur: User,
    public contenu: string,
    public article?: Article
  ) {}
}
