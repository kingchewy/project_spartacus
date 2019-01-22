import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable } from 'rxjs';
import { Character } from '../character';

@Injectable({
  providedIn: 'root'
})
export class CharacterService {

  public _character: BehaviorSubject<Character> = new BehaviorSubject<Character>(null);
  public readonly character$: Observable<Character> = this._character.asObservable();

  constructor() { 

    let char: Character = new Character
  }

  get(){

    //this._character.next(char)
  }
}
