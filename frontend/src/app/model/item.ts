export class Item {
    id?: number;
    name: string;
    price: number;
    type: string;
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



export class SpecialItem {
    id: number
    name: string
    type: string
}

export class WeaponItem {
    id?: number;
    name: string;
    price: number;
    itemType: string;
    minLvl: number;
    slot?: number
    
    damage: number;
    accuracy: number;
    criticalDamage: number;
    
    twohanded?: boolean
}

export class ArmorItem {
    id?: number;
    name: string;
    price: number;
    itemType: string;
    minLvl: number;
    slot?: number
    
    reducedDamage: number
    agility: number
}