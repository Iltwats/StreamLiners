package Task4;

public class Main {

    public static void main(String[] args) {

        Product product = new Product("bread");
        Variant variant = new Variant("big", 14);
        Variant variant1 = new Variant("small", 7);
        Variant variant2 = new Variant("medium", 11);
        Cart cart = new Cart();
        cart.addToCart(product, variant);
        cart.addToCart(product, variant1);
        cart.addToCart(product, variant1);
        cart.addToCart(product, variant1);
        cart.addToCart(product, variant2);
        cart.removeFromCart(product, variant);
        cart.removeFromCart(product, variant1);
        System.out.println("Cart items only variants based\n");
        System.out.println(cart);

        //WeightBasedProduct in cart
        Product apple = new Product("apple",50,.5f);
        Product potatoes = new Product("Potatoes", 10,1);

        cart.updateWBPQuantity(apple, 4);
        cart.updateWBPQuantity(potatoes, 9);
        System.out.println("Cart items after changing weightBased products \n");
        System.out.println(cart);
        cart.removeWBPFromCart(apple);
        cart.removeWBPFromCart(potatoes);
        System.out.println("Cart items after removing\n");
        System.out.println(cart);

//        System.out.println("After removing variant:\n");
//        cart.removeAllVariantsFromCart(product);
//        System.out.println(cart);
    }


}
