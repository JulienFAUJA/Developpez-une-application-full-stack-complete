import { Theme } from './theme.model';
import { User } from './user.model';

export class Abonnement {
  constructor(public theme: Theme, public abonne: User) {}
}
