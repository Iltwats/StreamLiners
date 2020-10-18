package Task3;

import java.io.Serializable;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class TouristPlace implements Serializable {
    String name, workingHour,city;
    int entryTicPrice;
    float starRating;
    List<String> famousFor;
    String category;
    int noOfRatings;
    String review;

    public TouristPlace(String name, String workingHour, String city, int entryTicPrice, String category) {
        this.name = name;
        this.workingHour = workingHour;
        this.city = city;
        this.entryTicPrice = entryTicPrice;
        this.category = category;
        famousFor=new ArrayList<>();
    }

    public TouristPlace() {
    }

    public TouristPlace addFamousFor(String s){
        famousFor.add(s);
        return this;
    }
    //calculating the total rating.
    public void rate(float... ratings) {
        //calculating total no of stars till now
        for (float rating:ratings) starRating += (rating - starRating) / ++noOfRatings;
    }
    //Checking if the spot is open or not.
    public boolean isOpen(){
        String[] times = workingHour.split(" to ");
        //Parse times
        LocalTime startTime = LocalTime.parse(times[0], DateTimeFormatter.ofPattern("hh:mma"))
                , endTime = LocalTime.parse(times[1], DateTimeFormatter.ofPattern("hh:mma"))
                , currTime = LocalTime.now();

       return startTime.compareTo(currTime) <=0  && endTime.compareTo(currTime) >=0;
    }

    public static TouristPlace newFromUserInput(){
        Scanner scanner = new Scanner(System.in);
        TouristPlace place=new TouristPlace();
        System.out.println("Enter name : ");
        place.name = scanner.next();
        System.out.println("What are its speciality?");
        place.famousFor = Collections.singletonList(scanner.next());
        System.out.println("Your review: ");
        place.review = scanner.next();
        return place;
    }

    @Override
    public String toString() {
        return String.format("Your place "+ name+" is rated "+starRating+" by "+noOfRatings+" users. Its famous for"+famousFor+" and its reviews as rated by user are "+review+" .");
    }
}
