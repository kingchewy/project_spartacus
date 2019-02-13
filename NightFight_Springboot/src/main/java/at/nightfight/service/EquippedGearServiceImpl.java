package at.nightfight.service;

import at.nightfight.model.*;
import at.nightfight.model.Character;
import at.nightfight.repository.CharacterRepository;
import at.nightfight.repository.EquippedGearRespository;
import at.nightfight.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
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

        // Requests with missing IDs for Items are handled as Null Values for that items
        if(!isValidGearToEquip(character, gearToEquip)){
            return null;
        }

        // All requested Inputs are valid -> Equip
        EquippedGear newEquippedGear = new EquippedGear();

        newEquippedGear.setCharacterId(character.getCharacterId());
        newEquippedGear.setCharacter(character);

        // Fetch Items to equip from Repo ( by ID ) && Set Items
        if(gearToEquip.getWeaponPrimary() != null){
            if(gearToEquip.getWeaponPrimary().getId() != null){
                ItemWeapon newItemWeaponPrimary = (ItemWeapon) itemRepository.findById(gearToEquip.getWeaponPrimary().getId()).get();
                newEquippedGear.setWeaponPrimary(newItemWeaponPrimary);
            }
        }

        if(gearToEquip.getWeaponSecondary() != null){
            if(gearToEquip.getWeaponSecondary().getId() != null){
                ItemWeapon newItemWeaponSecondary = (ItemWeapon) itemRepository.findById(gearToEquip.getWeaponSecondary().getId()).get();
                newEquippedGear.setWeaponSecondary(newItemWeaponSecondary);
            }
        }

        if(gearToEquip.getArmor() != null){
            if(gearToEquip.getArmor().getId() != null){
                ItemArmor newItemArmor = (ItemArmor) itemRepository.findById(gearToEquip.getArmor().getId()).get();
                newEquippedGear.setArmor(newItemArmor);
            }
        }

        if(gearToEquip.getSpecial() != null){
            if(gearToEquip.getSpecial().getId() != null){
                ItemSpecial newItemSpecial = (ItemSpecial) itemRepository.findById(gearToEquip.getSpecial().getId()).get();
                newEquippedGear.setSpecial(newItemSpecial);
            }
        }

        equippedGearRespository.save(newEquippedGear);

        return  characterRepository.findById(character.getCharacterId()).get();
    }


    private boolean isValidGearToEquip(Character character, EquippedGear gearToEquip){

        System.out.println("################ CHECK if allOwnedItems #####################");
        if(!allOwnedItems(character, gearToEquip)){
            return false;
        }

        System.out.println("################ CHECK if isValidNewWeaponCombo #####################");
        if(!isValidNewWeaponCombo(gearToEquip)){
            return false;
        }
        System.out.println("##### in method after -> isValidNewWeaponCombo method ");
        return true;
    }


    private boolean allOwnedItems(Character character, EquippedGear gearToEquip){
        System.out.println("#######  GEAR T O  E Q U I P -----> " + gearToEquip);
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

        for(Item item: itemsToEquip){
            System.out.println("########## JUMP INTO ITERATION??????");
            if( (item.getId() != null) && (character.isOwnedItem(item) == false) ){
                System.out.println("########## " + item.getName() + " not owned item");
                return false;
            }
        }
        System.out.println("############ passed all ownedItem Validations!!! ############# ");
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

        System.out.println("#######################  null?  WeaponPrimary = " + itemWeaponSecondaryToEquip + " WeaponSecondary = " + itemWeaponSecondaryToEquip);

        // Case: One or both weaponslots empty
        // if at least one slot is empty the comibnation is valid (two-handed + null possible)
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
        if( ( itemWeaponPrimaryToEquip.isTwoHanded() == true &&  itemWeaponSecondaryToEquip != null ) ||
                ( itemWeaponSecondaryToEquip.isTwoHanded() == true && itemWeaponPrimaryToEquip != null )){
            System.out.println("##### Two-handed + second weapon -> INVALID ");
            return false;
        }

        // primary and secondary is same -> (id)
        if( itemWeaponPrimaryToEquip.getId() == itemWeaponSecondaryToEquip.getId()){
            System.out.println("##### tried to set same weapon for both hands ");
            return false;
        }

        System.out.println("############ passed WeaponCombo Validation!!! ############# ");
        return true;
    }
}
