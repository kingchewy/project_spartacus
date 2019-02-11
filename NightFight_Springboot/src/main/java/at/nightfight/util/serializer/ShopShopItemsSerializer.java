package at.nightfight.util.serializer;

import at.nightfight.model.*;
import at.nightfight.repository.ShopItemArmorRepository;
import at.nightfight.repository.ShopItemRepository;
import at.nightfight.repository.ShopItemSpecialRepository;
import at.nightfight.repository.ShopItemWeaponRepository;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ShopShopItemsSerializer extends StdSerializer<List<ShopShopItem>> {
    public ShopShopItemsSerializer() {
        this(null);
    }

    public ShopShopItemsSerializer(Class<List<ShopShopItem>> s) {
        super(s);
    }

    @Autowired
    ShopItemRepository shopItemRepository;

    @Autowired
    ShopItemWeaponRepository shopItemWeaponRepository;

    @Autowired
    ShopItemArmorRepository shopItemArmorRepository;

    @Autowired
    ShopItemSpecialRepository shopItemSpecialRepository;

    @Override
    public void serialize(List<ShopShopItem> shopShopItems, JsonGenerator gen, SerializerProvider provider) throws IOException {
        System.out.println("ShopShopItemsSerializer ++++++++++++++++++++++++");
        List<ShopItem> shopitems = new ArrayList<>();

/*        System.out.println("Test = queryResult only -> " + shopItemRepository.findById(53L));
        ShopItem testItem = shopItemRepository.findById(53L).get();
        System.out.println("saved in 'ShopItem' -> " + testItem);*/

        for (ShopShopItem shopShopItem : shopShopItems){
           // System.out.println("iterate ShopShopItems ++++++++++++++++++++++++" + shopShopItem.getShopitem().getId());
            //ShopItem currentItem = getCurrentItem(shopShopItem);
            //shopitems.add(currentItem);
            shopitems.add(shopItemRepository.findById(shopShopItem.getShopitem().getId()).get());

        }

        gen.writeObject(shopitems);
    }

/*    private ShopItem getCurrentItem (ShopShopItem shopShopItem){

        ShopItem shopitem = null;

        ItemType type = shopShopItem.getShopitem().getItemType();

        switch (type){
            case ARMOR: shopitem = shopItemArmorRepository.findById(shopShopItem.getShopitem().getId()).get();
            break;

            case WEAPON: shopitem = shopItemWeaponRepository.findById(shopShopItem.getShopitem().getId()).get();
            break;

            case SPECIAL: shopitem = shopItemSpecialRepository.findById(shopShopItem.getShopitem().getId()).get();
            break;
        }

        return shopitem;
    }*/
}
