import { Commentaire } from "./commentaire.model";
import { Theme } from "./theme.model";
import { User } from "./user.model";

export class Article {
  constructor(
    public theme: string, 
    public titre: string,
    public auteur: string,
    public contenu: string,
    public commentaires: Commentaire[],
    public createdAt: Date,
    public id?: number, 
  ) {}
}
