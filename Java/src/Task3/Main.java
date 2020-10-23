package Task3;

import java.io.IOException;
import java.text.DecimalFormat;

public class Main {
    public static void main(String[] args) throws Exception {
        //format the starRating variable in a given pattern.
        DecimalFormat dec = new DecimalFormat("#0.0");
        // declaring object of class TouristPlace
        TouristPlace indiaGate= new TouristPlace("India Gate","09:00AM to 05:00PM","Delhi",10,"Monument");
        indiaGate.addFamousFor("TimePass");
        indiaGate.addFamousFor("Photo-shoot");

        // Rating of the place
        indiaGate.rate(4,4,4,4,4,5,2,4,2,5);

        System.out.println(dec.format(indiaGate.starRating));
        System.out.println(indiaGate.isOpen());

        new Menu().show();


    }
}
