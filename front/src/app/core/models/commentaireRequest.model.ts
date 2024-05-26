
export class CommentaireRequest {
  constructor(
    public contenu: string,
    public article_id?: number
  ) {}
}
