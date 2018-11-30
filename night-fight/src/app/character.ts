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
    ownedGear: Array<string>
    equipped: Array<string>
}