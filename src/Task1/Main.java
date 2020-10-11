package Task1;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Product guava=new Product("Guava",250);
        Product banana=new Product("Banana",100);
        Product bananaOne=new Product("Banana",100);

        for (Product product : Arrays.asList(banana,bananaOne, guava)) {
            System.out.println(product);
        }
        System.out.println(banana.equals(bananaOne));
        SpecialProduct specialProduct=SpecialProduct.applyOffOnProduct(banana,30);
        System.out.println(specialProduct);
    }
}
