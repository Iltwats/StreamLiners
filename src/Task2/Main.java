package Task2;

public class Main {
    public static void main(String[] args) {
        GroceryItem biscuit=new GroceryItem("Biscuits",10);
        GroceryItem namkeen= new GroceryItem("Namkeen",30);
        GroceryItem chips=new GroceryItem("Chips",15);
        GroceryItem chocolate=new GroceryItem("Chocolate",60);

        Cart cart=new Cart();
        cart.add(GroceryCartItem.createNew(biscuit,"1kg 500g"))
                .add(GroceryCartItem.createNew(namkeen,"3kg 0g"))
                .add(GroceryCartItem.createNew(chips,"5kg 450g"))
                .add(GroceryCartItem.createNew(chocolate,"0kg 750g"));
        System.out.println(cart);
    }
}
