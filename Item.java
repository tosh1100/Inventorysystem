public class Item {
//stores the instance variables, the constructor, and the getters for those instance variables for the Item object
    private ItemType itemType;
    private String itemName;
    private int itemWeight;
    private int itemValue;
    private int itemStrength;

    public Item(ItemType itemType, String itemName,int itemWeight, int itemValue, int itemStrength){
        //constructor for Item
        this.itemType = itemType;
        this.itemName = itemName;
        this.itemWeight = itemWeight;
        this.itemValue = itemValue;
        this.itemStrength = itemStrength;
    }

    public int getItemStrength() {
        return itemStrength;
    }
    //getter for the strength variable
    public int getItemValue() {
        return itemValue;
    }
    //getter for the itemValue variable
    public int getItemWeight() {
        return itemWeight;
    }
    //getter for the weight variable
    public String getItemName() {
        return itemName;
    }
    //getter for the name variable
    public ItemType getItemType() {
        return itemType;
    }
    //getter for the type variable
}
