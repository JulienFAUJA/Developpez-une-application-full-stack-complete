import { Commentaire } from "./commentaire.model";
import { Theme } from "./theme.model";
import { User } from "./user.model";

export class Article {
  constructor(
    public theme: Theme, 
    public titre: string,
    public auteur: User,
    public contenu: string,
    public commentaires: Commentaire[],
    public createdAt: Date,
    public id?: number, 
  ) {}
}
