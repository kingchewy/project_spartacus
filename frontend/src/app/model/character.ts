import { Item } from '../model/item';

export class Character {
    id: number
    playerID: number
    name: string
    race: string
    lvl: number
    hp: number
    xp: number
    armor: number
    attack: number
    strength: number
    accuracy: number
    criticalhitchance: number
    agility: number
    ownedItems: Array<Item>
    equippedItems: {
        characterId: number,
        weaponPrimary?: Item,
        weaponSecondary?: Item,
        armor?: Item,
        special?: Item
    }
    money: number
}