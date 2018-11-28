import { Stats } from './stats'

export class Character {
    id: number
    playerID: number
    name: string
    race: string
    lvl: number
    stats: Stats
    ownedGear: Array<string>
    equipped: Array<string>
}