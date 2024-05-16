import { Article } from "./article.interface";
import { User } from "./user.interface";

export interface Commentaire {
    id: number;
    article: Article;
    auteur: User;
    contenu: string;
    createdAt: Date;
  }
  