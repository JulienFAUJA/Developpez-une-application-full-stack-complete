import { Theme } from "./theme.interface";
import { User } from "./user.interface";

export interface Abonnement {
    id: number;
    theme: Theme;
    abonne: User;
  }
  