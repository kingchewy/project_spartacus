import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs'
import { Shop } from '../model/shop';
import { Item } from '../model/item';

const RESCOURCES = 'http://localhost:8080/night_fight/resources'

@Injectable({
  providedIn: 'root'
})
export class RequestShopService {

    constructor(private httpClient: HttpClient) { }
    
    getShop(): Observable<Shop> {
        return this.httpClient.get<Shop>(RESCOURCES + '/shops/1')
    }
    
    tradeItems (items: Item[], shopId, buyOrSell): Promise<any> {
        
        items.forEach( item => item.quantity = 1 )
        
        let buyPackage = {
            characterId: 1,
            items: items
        }

        return this.httpClient.post(`${RESCOURCES}/shops/${shopId}/${buyOrSell}`, buyPackage).toPromise()
    }
}
