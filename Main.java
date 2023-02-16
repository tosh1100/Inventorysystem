import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        //takes action as input from user, and calls methods based on input. The "Add random item object also checks whether the new item fits in the inventory"
        Inventory n = new Inventory();
        ItemGenerator.initValueGen();
        int action=0;
        while (action != 6) {
            System.out.println("1. Print inventory");
            System.out.println("2. Add random item ");
            System.out.println("3. Drop item ");
            System.out.println("4. Equip Weapon");
            System.out.println("5. Equip Armor");
            System.out.println("6. Exit");
            Scanner in = new Scanner(System.in);
            action = in.nextInt();

            if (action == 1){
                n.print();
            } else if (action == 2) {
                Item newItem = ItemGenerator.generate();
                if (n.add(newItem)){
                    System.out.println("The " + newItem.getItemName() + " was added to your inventory");
                }else {
                    System.out.println("That's too heavy for you to carry");
                }
            } else if (action == 3) {
                n.drop();

            } else if (action == 4) {
                n.equipWeapon();
            }else if(action == 5){
                n.equipArmor();
            } else if (action == 6) {
                System.out.println("Goodbye!");
            } else {
                System.out.println("Not a valid input. Try again!");
            }

        }


    }
}
