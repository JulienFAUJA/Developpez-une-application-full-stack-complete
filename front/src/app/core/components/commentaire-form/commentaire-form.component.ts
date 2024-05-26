import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Subject, takeUntil, tap } from 'rxjs';
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

@Output() newCommentPosted = new EventEmitter<void>();


  constructor(
    private commentairesService: CommentairesService,
    private fb: FormBuilder,
    private router: Router
  ) {}

  ngOnInit():void{
    this.commentaireForm = this.fb.group({
      contenu:['', [Validators.required, Validators.minLength(3), Validators.maxLength(2000)]],
    });

  }

  onSubmitForm():void {
    if (this.commentaireForm.valid) {  // Vérifie si le formulaire est valide
    this.destroy$ = new Subject<boolean>();
    const commentaireRequest = this.commentaireForm.value as CommentaireRequest;
    commentaireRequest.article_id=this.articleId;
    this.commentairesService.create(commentaireRequest)
    .pipe(
      takeUntil(this.destroy$))
    .subscribe({
      next: (response) => {
        this.commentaireForm.reset();
        this.newCommentPosted.emit();
      },
      error: (error) => {
        this.errorStr =
          error || '..................Une erreur est survenue lors de la connexion.';
      },   
    });
  }
        
    
    
}
ngOnDestroy(): void {
  this.destroy$.next(true);
  this.destroy$.complete();
}
}
