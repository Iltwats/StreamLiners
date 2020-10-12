package Task2;

public class GroceryCartItem extends GroceryItem {
    float price;
    float quantity;

    public GroceryCartItem(String name, int pricePerKg, float price, float quantity) {
        super(name, pricePerKg);
        this.price = price;
        this.quantity = quantity;
    }

    public GroceryCartItem(String name, int pricePerKg) {
        super(name, pricePerKg);
    }

    @Override
    public String toString() {
        String cartCost=String.format("%s (Rs. %d X Rs. %f) = Rs. %f",name,pricePerKg,quantity,price);
        return cartCost;
    }
    
    public static float extractQuantity(String quantityStr){
        String metric[]=quantityStr.split(" ");
        metric[0]=metric[0].replace("kg","");
        metric[1]=metric[1].replace("g","");
        float kiloGrams=Integer.parseInt(metric[0]);
        float grams=Integer.parseInt(metric[1]);
        float quantityAdded=kiloGrams+(grams/1000);
        return quantityAdded;
    }

    public static GroceryCartItem createNew(GroceryItem item,String quantityStr){
        GroceryCartItem cartItem= new GroceryCartItem(item.name, item.pricePerKg);
        cartItem.quantity=extractQuantity(quantityStr);
        cartItem.price = item.pricePerKg * cartItem.quantity;
        return  cartItem;
    }

}
