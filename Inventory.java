import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.String.valueOf;

public class Inventory {
    //stores the inventory arraylist, and all the methods that rely on it, as well as instance variables that contain the equipped items and the maximum weight
ArrayList<Item> inventory = new ArrayList<>();
private int maxWeight=200;
private Item equippedWeapon = null;
private Item equippedArmor = null;

public void print(ItemType t) {
    //used by the equip* methods to print a list of items in the inventory with the correct item type
    String formatted = String.format("%-29s %-8s %-9s %-6s %-7s", "  Name", "Type", "Strength", "Value", "Weight");
    System.out.println(formatted);
    int i;
    int itemCount=0;
    for (i = 0; i < inventory.size(); i++) {
        Item c = inventory.get(i);

        if (c.getItemType() == t) {
            itemCount++;
            String name = c.getItemName();
            String type = valueOf(c.getItemType());
            String strength = String.valueOf((c.getItemStrength()));
            String value = String.valueOf(c.getItemValue());
            String weight = String.valueOf(c.getItemWeight());
            formatted = String.format("%-27s %-8s %-9s %-6s %-7s", name, type, strength, value, weight);
            System.out.print((itemCount) + ":");
            System.out.print(formatted);
            String isEquipped = "";
            if (equippedWeapon != null) {
                if (c.getItemValue() == (equippedWeapon.getItemValue())) {
                    isEquipped = " Equipped Weapon";
                }
            }
            if (equippedArmor != null) {
                if (c.getItemValue() == (equippedArmor.getItemValue())) {
                    isEquipped=" Equipped Armor";
                }
            }
            System.out.print(isEquipped+"\n");
        }
    }
    System.out.println((itemCount + 1) + ":Cancel");

}
    public void print() {
    //used by the print option in main and the drop method to print all the items in the inventory
        String formatted = String.format("%-29s %-8s %-9s %-6s %-7s", "  Name", "Type", "Strength", "Value", "Weight");
        System.out.println(formatted);
        for (int i = 0; i < inventory.size(); i++) {
            Item c = inventory.get(i);
            String name = c.getItemName();
            String type = valueOf(c.getItemType());
            String strength = String.valueOf((c.getItemStrength()));
            String value = String.valueOf(c.getItemValue());
            String weight = String.valueOf(c.getItemWeight());
            formatted = String.format("%-27s %-8s %-9s %-6s %-7s", name, type, strength, value, weight);
            System.out.print((i + 1) + ":");
            System.out.print(formatted);
            String isEquipped = "";
            if (equippedWeapon != null) {
                if (c.getItemValue() == (equippedWeapon.getItemValue())) {
                    isEquipped = " Equipped Weapon";
                }
            }
                if (equippedArmor != null) {
                    if (c.getItemValue() == (equippedArmor.getItemValue())) {
                        isEquipped=" Equipped Armor";
                    }
                }

            System.out.print(isEquipped+"\n");
        }
    }
public void equipWeapon() {
    //If there are Items in the inventory, prints the Items with ItemType Weapons, has the user select one, and assigns it to the equippedWeapon variable. Also provides the user with the option to cancel
    Item c = null;
    if (inventory.size() >0) {
        print(ItemType.Weapons);
        System.out.println("Equip a Weapon");
        Scanner in = new Scanner(System.in);
        int eItem = in.nextInt();
        int otherItem = 0;
        int i = 0;
        int j = 0;
        while (i < eItem) {
            if (j < inventory.size()){
                c = inventory.get(j);
            }
            j++;
            if (j > inventory.size()) {
                System.out.println("Canceled");
                i=eItem+1;
                j= inventory.size() +1 ;
            }
            if (c.getItemType() != ItemType.Weapons) {
                otherItem++;
            } else {
                i++;
            }
        }
        if (j <= inventory.size()) {
            equippedWeapon = inventory.get(otherItem + eItem - 1);
            System.out.println("You are wielding the " + equippedWeapon.getItemName());

        }
    } else{
        System.out.println("You have nothing to equip");
    }
}
public void equipArmor() {
    //If there are Items in the inventory, prints the Items with ItemType Armor, has the user select one, and assigns it to the equippedArmor variable. Also provides the user with the option to cancel
    Item c = null;
    if (inventory.size() >0) {
        print(ItemType.Armor);
        System.out.println("Equip an Armor");
        Scanner in = new Scanner(System.in);
        int eItem = in.nextInt();
        int otherItem = 0;
        int i = 0;
        int j = 0;

        while (i < eItem) {
                if (j< inventory.size()){
                    c = inventory.get(j);
                }
                j++;
            if (j > inventory.size()) {
                System.out.println("Canceled");
                i=eItem+1;
                j= inventory.size() +1 ;
            }
                if (c.getItemType() != ItemType.Armor) {
                    otherItem++;
                }else {
                    i++;

                }
            }

        if (j<= inventory.size()) {
                equippedArmor = inventory.get(otherItem + eItem-1);
                System.out.println("You are wielding the " + equippedArmor.getItemName());
        }
    }else{
        System.out.println("You have nothing to equip");
    }
}
public boolean add(Item newItem){
    //determines if the item will fit in the inventory, and adds it to it if it does. Returns a boolean so that main can print out whether or not the item was added
    if((totalWeight() + newItem.getItemWeight()) < maxWeight) {
        inventory.add(newItem);
        return true;
    }else {
        return false;
    }

}
public int totalWeight(){
    //used by add to determine the weight of all items in the inventory
    int weight= 0;
    for (Item c : inventory) {
        weight += c.getItemWeight();
    }
    return weight;
    }

public void drop(){
//prints the inventory to the user, gives them the option to drop an item, removes the item from the inventory
    if (inventory.size() >0) {
        print();
        int inventorySize= inventory.size();
        System.out.println((inventorySize+1) + ":Cancel \n Which item would you like to drop?");
        Scanner in = new Scanner(System.in);
        int droppedItem = in.nextInt();
        if (droppedItem == 0) {
            System.out.println("You have nothing to drop");
        } else if (droppedItem <= inventory.size()) {
            Item selectedItem = inventory.get(droppedItem - 1);
            System.out.println("You dropped the " + selectedItem.getItemName());
            inventory.remove(droppedItem - 1);
        } else{
            System.out.println("Canceled");
        }
    }else {
        System.out.println("You have nothing to drop");
    }
}

}
