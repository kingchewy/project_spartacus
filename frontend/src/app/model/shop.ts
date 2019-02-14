import { Item } from '../model/item';

export class Shop {
    id?: number
    name?: string
    money?: number
    openingTime?: string
    closingTime?: string
    address?: string
    city?: string
    shopitems?: Item []
}
