package at.nightfight.service;

import at.nightfight.model.Character;
import at.nightfight.model.EquippedGear;

import java.util.Optional;

public interface IEquippedGearService {
    public Character setEquippedGear(Character character, EquippedGear gearToEquip);
    public Optional<EquippedGear> getEquippedGear(Long characterId);
}
