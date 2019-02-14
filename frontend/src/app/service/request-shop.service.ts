import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs'
import { Shop } from '../model/shop';

const RESCOURCES = 'http://localhost:8080/night_fight/resources'

@Injectable({
  providedIn: 'root'
})
export class RequestShopService {

    constructor(private httpClient: HttpClient) { }
    
    getShop(): Observable<Shop> {
        return this.httpClient.get<Shop>(RESCOURCES + '/shops/1')
    }
}
