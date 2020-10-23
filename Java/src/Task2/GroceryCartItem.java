package Task2;

import java.util.regex.Pattern;

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
        String cartCost=String.format("%s (Rs %d X Rs %.3f) = Rs %.2f",name,pricePerKg,quantity,price);
        return cartCost;
    }

    public static float extractQuantity(String quantityStr){
        //Checking if valid quantity
        if(!Pattern.compile("(\\d+kg \\d+g)|(\\d+kg)|(\\d+g)")
            .matcher(quantityStr)
                .matches()){
            System.out.println("Invalid Quantity!");
            return -1;
        }
        //replacing kg and g
        quantityStr=quantityStr.replace("kg ",".")
                .replace("kg",".")
                .replace("g","");

        int dotIndex = quantityStr.indexOf(".");
        int len=quantityStr.length();
        //if length of quantity with gram less than 3
        if(dotIndex == -1 && len < 3 ) {
            if (len == 1)
                quantityStr = ".00" + quantityStr;
            else
                quantityStr = ".0" + quantityStr;
        }
        else if(dotIndex == -1) {
            quantityStr = "."+quantityStr;
        }
        return Float.parseFloat(quantityStr);
    }

    public static GroceryCartItem createNew(GroceryItem item,String quantityStr){
        GroceryCartItem cartItem= new GroceryCartItem(item.name, item.pricePerKg);
        cartItem.quantity=extractQuantity(quantityStr);
        cartItem.price = item.pricePerKg * cartItem.quantity;
        return  cartItem;
    }

}
