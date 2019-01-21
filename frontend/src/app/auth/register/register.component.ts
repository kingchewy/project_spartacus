import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from '../auth.service';
import { User } from '../user';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { RegistrationValidator } from '../registration-validator';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})

export class RegisterComponent implements OnInit{

    private registrationFormGroup: FormGroup;
    private passwordFormGroup: FormGroup;
    private loading:boolean = false;
    private submitted:boolean = false;
    private error = '';

    newUser = new User()
/*     private password = ""
    private passwordConf = ""
     */
    constructor (
        private authService: AuthService,
        private router: Router,
        private formBuilder: FormBuilder,
        ) {}

    ngOnInit () {
/*         this.registerForm = this.formBuilder.group({
            name: ['', Validators.required],
            username: ['', Validators.required],
            email: ['', Validators.required],
            password: ['', Validators.required],
            confPassword: ['']
        },{
            validator: ConfirmPasswordValidator.MatchPassword
        }); */

/*         this.newUser.name = ""
        this.newUser.email = ""
        this.newUser.password = ""
        //console.log(this.authService.login("Fiese Liese", "asdf"))
        //this.nightFightService.retrieveAllAccounts() */
        
        
        this.passwordFormGroup = this.formBuilder.group({
            password: ['', Validators.compose([Validators.minLength(6), Validators.required])],
            repeatPassword: ['', Validators.required]
          }, {
            validator: RegistrationValidator.validate.bind(this)
          });

        this.registrationFormGroup = this.formBuilder.group({
            username: ['', Validators.compose([Validators.minLength(3), Validators.required])],
            fullname: ['', Validators.compose([Validators.minLength(3), Validators.required])],
            email: ['', [Validators.required, Validators.email]],
            passwordFormGroup: this.passwordFormGroup
          });
    }
    
/*     checkInput () {
        if (( this.newUser.name != "" && this.newUser.email != "" && this.password != "" && this.passwordConf != "" )
            && ( this.password == this.passwordConf )){
            return true
        }
        return false
    } */

    get email(){
        return this.registrationFormGroup.get('email');
    }
    
    onSubmit():void {
        this.submitted = true;
        this.loading = true;

        this.newUser.username = this.registrationFormGroup.value.username;
        this.newUser.name = this.registrationFormGroup.value.fullname;
        this.newUser.email = this.registrationFormGroup.value.email;
        this.newUser.password = this.passwordFormGroup.value.password;
        
        console.log("signing up new user: ", this.newUser)

        this.authService.signup(this.newUser).then( result => {
            console.log("signup successful: ", result)
        })
        .catch( error => {
            console.log("error register user: ", error.error)
            this.error = error.error
        })

        this.loading = true;
/*         this.newUser.password = this.password
        console.log(this.newUser)
        //this.nightFightService.createAccount(this.newUser)
        //this.nightFightService.retrieveAllAccounts()
        this.router.navigateByUrl("/intro/newUser") */
    }
}
