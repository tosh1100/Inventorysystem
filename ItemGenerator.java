import java.util.ArrayList;
import java.util.Random;

public class ItemGenerator {
    //creates new items
    private static ArrayList<Integer> number = new ArrayList<Integer>();
    public static Item generate(){
        //generates the items. Uses a rng to determines everything other than value, and calls the valueGen method to determine its value
        String[] itemNameList = {"Iron Sword", "Big Iron Sword", "Bigger Iron Sword", "Biggest Iron Sword", "Shield", "Helm", "Reflective Vest", "N95", "Laptop", "Phone", "Lute","Sense of Existential Dread"};
        Integer[] itemWeightList = {2,3,3,4,3,1,1,1,2,1,2,5};
        Integer[] itemStrengthList = {1,2,3,4,5,6,7,8,9,10,11,1000};

        Random gen = new Random();

        int rng = gen.nextInt(itemNameList.length);
        int value = valueGen();
        String name= itemNameList[rng];
        int weight= itemWeightList[rng];
        int strength= itemStrengthList[rng];

        ItemType type;
        if (rng<4){
            type=ItemType.Weapons;
        } else if (rng>7) {
            type=ItemType.Other;
        }else {
            type=ItemType.Armor;
        }

        Item newItem = new Item( type,name,weight,value,strength);
return newItem;
    }
    public static int valueGen(){
        //selects a random number off of the number arraylist, and removes it so that items can't be duplicates
    Random random = new Random();
    int select = random.nextInt(number.size());
    int value = number.get(select);
    number.remove(select);

         return value;
}
public static void initValueGen(){
        //creates an array of Integers from 1-250. Called in main
        for (int t = 1; t < 250; t++) {
            number.add(t);
        }
    }
}
