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
        if(isValidGearToEquip(character, gearToEquip) == false){
            return null;
        }

        // All requested Inputs are valid -> Equip
        EquippedGear newEquippedGear = new EquippedGear();

        newEquippedGear.setCharacterId(character.getCharacterId());
        newEquippedGear.setCharacter(character);

        // Fetch Items to equip from Repo ( by ID ) && Set Items
        if(gearToEquip.getItemWeaponPrimary() != null){
            if(gearToEquip.getItemWeaponPrimary().getId() != null){
                ItemWeapon newItemWeaponPrimary = (ItemWeapon) itemRepository.findById(gearToEquip.getItemWeaponPrimary().getId()).get();
                newEquippedGear.setItemWeaponPrimary(newItemWeaponPrimary);
            }
        }

        if(gearToEquip.getItemWeaponSecondary() != null){
            if(gearToEquip.getItemWeaponSecondary().getId() != null){
                ItemWeapon newItemWeaponSecondary = (ItemWeapon) itemRepository.findById(gearToEquip.getItemWeaponSecondary().getId()).get();
                newEquippedGear.setItemWeaponSecondary(newItemWeaponSecondary);
            }
        }

        if(gearToEquip.getItemArmor() != null){
            if(gearToEquip.getItemArmor().getId() != null){
                ItemArmor newItemArmor = (ItemArmor) itemRepository.findById(gearToEquip.getItemArmor().getId()).get();
                newEquippedGear.setItemArmor(newItemArmor);
            }
        }

        if(gearToEquip.getItemSpecial() != null){
            if(gearToEquip.getItemSpecial().getId() != null){
                ItemSpecial newItemSpecial = (ItemSpecial) itemRepository.findById(gearToEquip.getItemSpecial().getId()).get();
                newEquippedGear.setItemSpecial(newItemSpecial);
            }
        }

        equippedGearRespository.save(newEquippedGear);

        return  characterRepository.findById(character.getCharacterId()).get();
    }


    private boolean isValidGearToEquip(Character character, EquippedGear gearToEquip){

        System.out.println("################ CHECK if allOwnedItems #####################");
        if( allOwnedItems(character, gearToEquip) != true){
            return false;
        }

        System.out.println("################ CHECK if isValidNewWeaponCombo #####################");
        if(isValidNewWeaponCombo(gearToEquip) == false){
            return false;
        }
        System.out.println("##### in method after -> isValidNewWeaponCombo method ");
        return true;
    }


    private boolean allOwnedItems(Character character, EquippedGear gearToEquip){
        List<Item> itemsToEquip = new ArrayList<>();

        if(gearToEquip.getItemWeaponPrimary() != null){
            itemsToEquip.add(gearToEquip.getItemWeaponPrimary());
        }

        if(gearToEquip.getItemWeaponSecondary() != null){
            itemsToEquip.add(gearToEquip.getItemWeaponSecondary());
        }

        if(gearToEquip.getItemArmor() != null){
            itemsToEquip.add(gearToEquip.getItemArmor());
        }

        if(gearToEquip.getItemSpecial() != null){
            itemsToEquip.add(gearToEquip.getItemSpecial());
        }

        for(Item item: itemsToEquip){
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
            itemWeaponPrimaryToEquip = (ItemWeapon) itemRepository.findById(itemsToEquip.getItemWeaponPrimary().getId()).get();
        }

        if(itemsToEquip.getWeaponSecondaryId() != null){
            itemWeaponSecondaryToEquip = (ItemWeapon) itemRepository.findById(itemsToEquip.getItemWeaponSecondary().getId()).get();
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
