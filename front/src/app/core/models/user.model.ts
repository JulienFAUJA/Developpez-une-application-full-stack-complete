export class User {
  constructor(
    public email: string,
    public username: string,
    public password: string,
    public createdAt: Date
  ) {}

  toString():string{
    return this.username;
  }
}
