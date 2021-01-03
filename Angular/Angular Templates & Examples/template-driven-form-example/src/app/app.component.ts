import { Component, ViewChild } from '@angular/core';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})

export class AppComponent {
  title = 'Template Driven Form';
  @ViewChild('f', { static: false }) signupForm: NgForm;
  defaultQuestion = 'street';
  answer = '';
  honorifics = ['Dr', 'Mr.', 'Mrs.', 'Ms.'];
  user = {
    username: '',
    email: '',
    securityQuestion: '',
    answer: '',
    honorific: ''
  };
  submitted = false;

  suggestUserName() {
    const suggestedName = 'Superuser';
    this.signupForm.form.patchValue({
      userData: {
        username: suggestedName
      }
    });
  }
  onSubmit() {
    this.submitted = true;
    this.user.username = this.signupForm.value.userData.username;
    this.user.email = this.signupForm.value.userData.email;
    this.user.securityQuestion = this.signupForm.value.security;
    this.user.answer = this.signupForm.value.questionAnswer;
    this.user.honorific = this.signupForm.value.honorific;
    this.signupForm.reset();
  }
}
