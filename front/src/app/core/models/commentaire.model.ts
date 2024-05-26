
export class Commentaire {
  constructor(
    public user_str: string,
    public contenu: string,
    public id?: number,
    public article_id?: number
  ) {}
}
