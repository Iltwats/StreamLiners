package Task1;

public class SpecialProduct extends Product {
    static int regularPrice;
    static int percentageOff;
    public SpecialProduct(String name,int price){
        super(name, price);

    }
    public SpecialProduct(String name, float discountedPrice) {

    }
    @Override
    public String toString() {
        String d=String.format("%d percent off on regular price of %d!",percentageOff,regularPrice);
        return d;
    }
    public static SpecialProduct applyOffOnProduct(Product product, int percentageOff1){
        int discountedPrice=(product.price*percentageOff1)/100;
        regularPrice=product.price;
        percentageOff=percentageOff1;
        return new SpecialProduct(product.name,discountedPrice);
    }
}
