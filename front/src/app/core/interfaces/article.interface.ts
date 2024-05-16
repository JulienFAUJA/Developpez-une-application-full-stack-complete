import { Commentaire } from "./commentaire.interface";
import { Theme } from "./theme.interface";
import { User } from "./user.interface";

export interface Article {
    id: number;
    theme: Theme;
    titre: string;
    auteur: User;
    contenu: string;
    commentaires: Commentaire[];
    createdAt: Date;
  }
  