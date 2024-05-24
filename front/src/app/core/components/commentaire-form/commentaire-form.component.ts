import { Component, Input, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Subject, takeUntil, tap } from 'rxjs';
import { AuthService } from '../../services/auth.service';
import { SessionService } from '../../services/session.service';
import { CommentaireRequest } from '../../models/commentaireRequest.model';
import { CommentairesService } from '../../services/commentaires.services';

@Component({
  selector: 'app-commentaire-form',
  templateUrl: './commentaire-form.component.html',
  styleUrls: ['./commentaire-form.component.scss']
})
export class CommentaireFormComponent implements OnInit {
public commentaireForm!: FormGroup;
private destroy$: Subject<boolean> = new Subject();
errorStr: string = '';
@Input()
articleId!:number | undefined;


  constructor(
    private commentairesService: CommentairesService,
    private fb: FormBuilder,
    private router: Router,
    private sessionService: SessionService
  ) {}

  ngOnInit():void{
    
    this.commentaireForm = this.fb.group({
     
      contenu:['', [Validators.required, Validators.minLength(3), Validators.maxLength(2000)]],
     
      
    });

  }

  onSubmitForm():void {
    console.log("form.value: ",this.commentaireForm.value);
    this.destroy$ = new Subject<boolean>();
    const commentaireRequest = this.commentaireForm.value as CommentaireRequest;
    commentaireRequest.article_id=this.articleId;
    console.log("commentaireRequest: ",commentaireRequest);
    this.commentairesService.create(commentaireRequest)
   
    .pipe(
      takeUntil(this.destroy$))
    
    .subscribe({
      next: (response) => {
        (this.errorStr = ''),
        tap(response => console.log),
        
          this.router.navigate(['article/all']);
      },
      error: (error) => {
        this.errorStr =
          error || '..................Une erreur est survenue lors de la connexion.';
          console.log("erreur: ", this.errorStr);
      },
    });
    
    
    
}
ngOnDestroy(): void {
  this.destroy$.next(true);
  this.destroy$.complete();
}
}