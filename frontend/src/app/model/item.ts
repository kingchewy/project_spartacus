export class Item {
    id?: number;
    name: string;
    price: number;
    type: string;
    characterId: number;
    minimumLvl: number;
    damage: number;
    accuracy: number;
    critDamage: number;
    armor: number
    agility: number
    slot?: number
    twohanded?: boolean
}



export class SpecialItem {
    id: number
    name: string
    type: string
}