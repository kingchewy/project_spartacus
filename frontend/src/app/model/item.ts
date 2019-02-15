export class Item {
    id?: number;
    name: string;
    price: number;
    itemType: string;
    slot?: number
    
    characterId?: number;
    minLvl?: number;
    damage?: number;
    accuracy?: number;
    critDamage?: number;
    armor?: number
    agility?: number
    twoHanded?: boolean
    
    quantity?: number
}