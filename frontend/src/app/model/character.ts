import { Item } from '../model/item';

export class Character {
    id: number
    playerID: number
    name: string
    race: string
    lvl: number
    hp: number
    armor: number
    strength: number
    accuracy: number
    criticalhitchance: number
    agility: number
    ownedGear: Array<Item>
    equipped: Array<Item>
}