package Task2;

public class Main {
    public static void main(String[] args) {
        GroceryItem biscuit=new GroceryItem("Biscuits",10);
        GroceryItem namkeen= new GroceryItem("Namkeen",30);
        GroceryItem chips=new GroceryItem("Chips",15);
        GroceryItem chocolate=new GroceryItem("Chocolate",60);
        GroceryItem cream=new GroceryItem("Cream",160);

        Cart cart=new Cart();
        cart.add(GroceryCartItem.createNew(biscuit,"1kg 500g"))
                .add(GroceryCartItem.createNew(namkeen,"3kg"))
                .add(GroceryCartItem.createNew(chips,"450g"))
                .add(GroceryCartItem.createNew(chocolate,"5g"))
                .add(GroceryCartItem.createNew(cream,"15g"));
        System.out.println(cart);

    }
}
