import { Character } from '../model/character';

export class User {
    id?: number;
    name: string;
    username: string;
    email: string;
    password: string;
    blocked?: boolean;
    created?: string;
    characters?: Character[];
}