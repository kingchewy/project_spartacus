import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { AuthService } from '../auth.service';
import { Credentials } from '../credentials';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

    private loginForm: FormGroup;
    private loading = false;
    private submitted:boolean = false;
    private error = '';

    private credentials: Credentials = new Credentials();
    private returnUrl: string;
    
    constructor (         
        private authService: AuthService,
        private router: Router,
        private route: ActivatedRoute,
        private formBuilder: FormBuilder
        ) 
        {}

    ngOnInit () {
        this.loginForm = this.formBuilder.group({
                username: ['', [Validators.minLength(3), Validators.required]],
                password: ['', [Validators.minLength(6), Validators.required]]
            });

        this.returnUrl = this.route.snapshot.queryParams['returnUrl'] || '/';
        console.log("return URL = ", this.returnUrl)
    }
    
    // convenience getter for easy access to form fields
    get f() { return this.loginForm.controls; }
    
    checkInput () {
        if (( this.credentials.username != "" && this.credentials.password != "" )){
            return true
        }
        return false
    }
    
    onSubmit () {
        this.submitted = true;
        this.loading = true;

        this.credentials.username = this.loginForm.value.username;
        this.credentials.password = this.loginForm.value.password;

        this.authService.login(this.credentials).then( response => {
            console.log("login response", response)
            this.router.navigateByUrl(this.returnUrl);
        })
        .catch( error => {
            this.error = "Wrong credentials"
            this.loading = false;
        })
    }
}
