package Task4;

import java.util.HashMap;
import java.util.Map;

public class Cart {

    public Map<String, CartItem> map = new HashMap<>();

    public Map<String, Integer> totalVariantsQtyMap = new HashMap<>();

    public int noOfItems, subTotal;


    // Variant based add to cart
    public int addToCart(Product product, Variant variant) {
        //Unique key
        String key = product.name + " " + variant.name;

        //Update map
        if (map.containsKey(key)) {
            //Update in map
            map.get(key).qty++;
        } else {
            //Put in map
            map.put(key, new CartItem(key, variant.price));
        }
        noOfItems++;
        subTotal += variant.price;

        //Update total VBP Qty
        if (totalVariantsQtyMap.containsKey(product.name)) {
            int qty = totalVariantsQtyMap.get(product.name) + 1;
            totalVariantsQtyMap.put(product.name, qty);
        } else {
            totalVariantsQtyMap.put(product.name, 1);
        }

        return (int) map.get(key).qty;
    }

    public int removeFromCart(Product product, Variant variant) {
        //Unique key
        String key = product.name + " " + variant.name;

        //Update qty in map
        map.get(key).qty--;

        //Check for complete removal
        if (map.get(key).qty == 0)
            map.remove(key);

        //Update summary
        noOfItems--;
        subTotal -= variant.price;

        //Update totalQty map
        int qty = totalVariantsQtyMap.get(product.name) - 1;
        totalVariantsQtyMap.put(product.name, qty);

        //Check for complete removal
        if (totalVariantsQtyMap.get(product.name) == 0)
            map.remove(key);

        return map.containsKey(key) ? (int) map.get(key).qty : 0;
    }

    public void removeAllVariantsFromCart(Product product) {
        for (Variant variant : product.variants) {
            String key = product.name + " " + variant.name;

            if (map.containsKey(key)) {
                subTotal -= map.get(key).price;
                noOfItems -= map.get(key).qty;
            }
        }

        if (totalVariantsQtyMap.containsKey(product.name))
            totalVariantsQtyMap.remove(product.name);
    }

    //Weight based
    public void updateWBPQuantity(Product product, float qty) {
        //Calculate newPrice
        int newPrice = (int) (product.pricePerKg * qty);

        //Decrement previous price
        if (map.containsKey(product.name))
            subTotal -= map.get(product.name).price;
            //Added for the first time, so increment noOfItems
        else
            noOfItems++;

        //Overwrite previous info OR put new info
        map.put(product.name, new CartItem(product.name, newPrice, qty));
        subTotal += newPrice;
    }

    public void removeWBPFromCart(Product product) {
        if (map.containsKey(product.name)) {
            subTotal -= map.get(product.name).price;
            noOfItems--;

            map.remove(product.name);
        }
    }

    @Override
    public String toString() {
        return "Cart{" +
                "map=" + map +"\n"+
                ", totalVariantsQtyMap=" + totalVariantsQtyMap +"\n"+
                ", noOfItems=" + noOfItems +"\n"+
                ", subTotal=" + subTotal +"\n"+
                '}';
    }
}
