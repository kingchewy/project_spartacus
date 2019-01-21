import { Injectable } from '@angular/core'
import { HttpClient } from '@angular/common/http'
import { map } from 'rxjs/operators'

const RESOURCE_URL = 'http://localhost:8080/night_fight/resources'

@Injectable({
  providedIn: 'root'
})
export class LoginService {

    constructor( private httpClient: HttpClient ) { }
    
}
