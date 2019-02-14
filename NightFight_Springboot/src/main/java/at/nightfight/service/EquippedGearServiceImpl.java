package at.nightfight.service;

import at.nightfight.model.*;
import at.nightfight.model.Character;
import at.nightfight.repository.CharacterRepository;
import at.nightfight.repository.EquippedGearRespository;
import at.nightfight.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

public class EquippedGearServiceImpl implements IEquippedGearService {

    @Autowired
    EquippedGearRespository equippedGearRespository;

    @Autowired
    CharacterRepository characterRepository;

    @Autowired
    ItemRepository itemRepository;


    @Override
    public Optional<EquippedGear> getEquippedGear(Long characterId) {
        return equippedGearRespository.findById(characterId);
    }


    @Override
    public Character setEquippedGear(Character character, EquippedGear gearToEquip) {

        // Requests with missing IDs for an Item are handled as NOT EQUIPPED

        //VALIDATE INPUT
        if(!isValidGearToEquip(character, gearToEquip)){
            return null;
        }

        System.out.println("****** Passed Validation *******");
        // All requested Inputs are valid -> EQUIP
        // Fetch Items to equip from Repo ( by ID ) && Set as Equipped Items
        EquippedGear newEquippedGear = fetchAndEquipItems(gearToEquip);

        newEquippedGear.setCharacterId(character.getCharacterId());
        newEquippedGear.setCharacter(character);

        equippedGearRespository.save(newEquippedGear);

        return characterRepository.findById(character.getCharacterId()).get();
    }

    private EquippedGear fetchAndEquipItems(EquippedGear gearToEquip){

        EquippedGear newEquippedGear = new EquippedGear();

        if(gearToEquip.getWeaponPrimaryId() != null){
            ItemWeapon newItemWeaponPrimary = (ItemWeapon) itemRepository.findById(gearToEquip.getWeaponPrimary().getId()).get();
            newEquippedGear.setWeaponPrimary(newItemWeaponPrimary);
        }

        if(gearToEquip.getWeaponSecondaryId() != null){
            ItemWeapon newItemWeaponSecondary = (ItemWeapon) itemRepository.findById(gearToEquip.getWeaponSecondary().getId()).get();
            newEquippedGear.setWeaponSecondary(newItemWeaponSecondary);
        }

        if(gearToEquip.getArmorId() != null){
            ItemArmor newItemArmor = (ItemArmor) itemRepository.findById(gearToEquip.getArmor().getId()).get();
            newEquippedGear.setArmor(newItemArmor);
        }

        if(gearToEquip.getSpecialId() != null){
            ItemSpecial newItemSpecial = (ItemSpecial) itemRepository.findById(gearToEquip.getSpecial().getId()).get();
            newEquippedGear.setSpecial(newItemSpecial);
        }

        return newEquippedGear;
    }


    private boolean isValidGearToEquip(Character character, EquippedGear gearToEquip){

        System.out.println("################ CHECK if allOwnedItems #####################");
        if(!allItemsOwnedAndWithinCharacterLevel(character, gearToEquip)){
            return false;
        }

        System.out.println("################ CHECK if isValidNewWeaponCombo #####################");
        return isValidNewWeaponCombo(gearToEquip);
    }


    private boolean allItemsOwnedAndWithinCharacterLevel(Character character, EquippedGear gearToEquip){

        List<Item> itemsToEquip = new ArrayList<>();

        if(gearToEquip.getWeaponPrimary() != null){
            itemsToEquip.add(gearToEquip.getWeaponPrimary());
        }

        if(gearToEquip.getWeaponSecondary() != null){
            itemsToEquip.add(gearToEquip.getWeaponSecondary());
        }

        if(gearToEquip.getArmor() != null){
            itemsToEquip.add(gearToEquip.getArmor());
        }

        if(gearToEquip.getSpecial() != null){
            itemsToEquip.add(gearToEquip.getSpecial());
        }

        // Check if Items Owned by Character
        for(Item item: itemsToEquip){
            if( (item.getId() != null) && (!character.isOwnedItem(item)) ){
                System.out.println("########## " + item.getName() + " not owned item");
                return false;
            }
        }

        // Check if Items fit Character Level
        if(!characterHasRequiredLevel(character, itemsToEquip)) {
            return false;
        }

        System.out.println("############ passed all ownedItem Validations!!! ############# ");
        return true;
    }

    private boolean characterHasRequiredLevel(Character character, List<Item> itemsToEquip){

        for (Item item: itemsToEquip){
            if(!character.hasRequiredLevelToEquip(item)){
                System.out.println("######### Min LvL to Equip Item " + item.getName()  + " not reached yet");
                return false;
            }
        }
        return true;
    }

    private boolean isValidNewWeaponCombo(EquippedGear itemsToEquip){

        ItemWeapon itemWeaponPrimaryToEquip = null;
        ItemWeapon itemWeaponSecondaryToEquip = null;

        if(itemsToEquip.getWeaponPrimaryId() != null){
            itemWeaponPrimaryToEquip = (ItemWeapon) itemRepository.findById(itemsToEquip.getWeaponPrimary().getId()).get();
        }

        if(itemsToEquip.getWeaponSecondaryId() != null){
            itemWeaponSecondaryToEquip = (ItemWeapon) itemRepository.findById(itemsToEquip.getWeaponSecondary().getId()).get();
        }

        // Case: One or both weaponslots empty
        // if at least one slot is empty the combination is valid (two-handed + null possible)
        if( itemWeaponPrimaryToEquip == null || itemWeaponSecondaryToEquip == null){
            return true;
        }

        // Case: Both id's are NULL
        // valid, because no weapons will be set for both
        if(itemWeaponPrimaryToEquip.getId() == null && itemWeaponSecondaryToEquip.getId() == null){
            return true;
        }

        // Case: Two-Handed + second weapon
        // if primary to equip is two-handed and there is a secondary to equip || vice versa
        if( (itemWeaponPrimaryToEquip.isTwoHanded()) || (itemWeaponSecondaryToEquip.isTwoHanded()) ){
            System.out.println("##### Two-handed + second weapon -> INVALID ");
            return false;
        }

        // primary and secondary is same Object -> (id)
        if(itemWeaponPrimaryToEquip.getId().equals(itemWeaponSecondaryToEquip.getId())){
            System.out.println("##### Tried to set same weapon for both hands ");
            return false;
        }

        return true;
    }
}
