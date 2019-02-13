package at.nightfight.model;

public class ShopItemToItemAdapter implements IShopItemVisitor<Item> {

    @Override
    public Item visitShopItemWeapon(ShopItemWeapon shopItemWeapon) {
        ItemWeapon item = new ItemWeapon();
        item.setName(shopItemWeapon.getName());
        item.setItemType(shopItemWeapon.getItemType());
        item.setMinLvl(shopItemWeapon.getMinLvl());
        item.setPrice(shopItemWeapon.getPrice());
        item.setAccuracy(shopItemWeapon.getAccuracy());
        item.setCriticalDamage(shopItemWeapon.getCriticalDamage());
        item.setDamage(shopItemWeapon.getDamage());
        item.setTwoHanded(shopItemWeapon.isTwoHanded());

        return item;
    }

    @Override
    public Item visitShopItemArmor(ShopItemArmor shopItemArmor) {
        ItemArmor item = new ItemArmor();
        item.setName(shopItemArmor.getName());
        item.setItemType(shopItemArmor.getItemType());
        item.setMinLvl(shopItemArmor.getMinLvl());
        item.setPrice(shopItemArmor.getPrice());
        item.setAgility(shopItemArmor.getAgility());
        item.setReducedDamage(shopItemArmor.getReducedDamage());

        return item;
    }

    @Override
    public Item visitShopItemSpecial(ShopItemSpecial shopItemSpecial) {
        ItemSpecial item = new ItemSpecial();
        item.setName(shopItemSpecial.getName());
        item.setItemType(shopItemSpecial.getItemType());
        item.setMinLvl(shopItemSpecial.getMinLvl());
        item.setPrice(shopItemSpecial.getPrice());
        item.setAccuracy(shopItemSpecial.getAccuracy());
        item.setAgility(shopItemSpecial.getAgility());
        item.setCriticalDamage(shopItemSpecial.getCriticalDamage());
        item.setDamage(shopItemSpecial.getDamage());
        item.setReducedDamage(shopItemSpecial.getReducedDamage());

        return item;
    }
}
