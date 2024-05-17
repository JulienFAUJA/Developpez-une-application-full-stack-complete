import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl } from '@angular/forms';
import { Theme } from 'src/app/core/models/theme.model';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.scss'],
})
export class UserComponent implements OnInit {
  userForm = new FormGroup({
    username: new FormControl(''),
    email: new FormControl(''),
  });themes!: Theme[];
  constructor() { }

  ngOnInit(): void {
    this.themes=[
      {
        theme: 'Python',
        description:"Langage de script, utilisé pour le prototypage et le domaine scientifique, nottement l'intelligence artificielle..."
      },
      {
        theme: 'Javascript',
        description:"Langage de programmation côté client pour le web..."
      }

    ];
    console.log("this.themes:", this.themes);
  }

  onSubmit() {
    console.log(this.userForm.value);
  }
}
