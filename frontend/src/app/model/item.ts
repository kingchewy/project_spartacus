export class Item {
    id?: number;
    name: string;
    price: number;
    itemType: string;
    slot?: number
    
    characterId?: number;
    minimumLvl?: number;
    damage?: number;
    accuracy?: number;
    critDamage?: number;
    armor?: number
    agility?: number
    twohanded?: boolean
}