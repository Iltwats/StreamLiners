package Task3;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Menu {

    HashMap<String,TouristPlace> map = new HashMap<>();

    public void show() throws Exception{
        readMap();

        while(true) {
            int option = showMenuAndGetChoice();

            switch (option){
                case 1: addNewPlace();
                    break;

                case 2: findAPlace();
                    break;

                case 3: rateAPlace();
                    break;

                case 4: deleteAPlace();
                    break;

                default:
                    System.out.println("Invalid Choice!!");
            }
            if (wantToExit()){
                showPlaces();
                writeMap();
                break;
            }
        }
    }

    private void writeMap() throws IOException {
        String path = "D:\\Programming-practice\\StreamLiners\\src\\Task3\\getValues.txt";
        FileOutputStream fileOutputStream = new FileOutputStream(path);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(map);
        objectOutputStream.close();
        fileOutputStream.close();
    }

    private void readMap() {
        try {
            String path = "D:\\Programming-practice\\StreamLiners\\src\\Task3\\getValues.txt";
            FileInputStream fileInputStream = new FileInputStream(path);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            HashMap<String, TouristPlace> hashMap = (HashMap<String, TouristPlace>) objectInputStream.readObject();
            System.out.println(hashMap.values().toString());
        } catch (Exception e) {
            //If file is not found
            map = new HashMap<>();
        }
    }

    private int showMenuAndGetChoice() {
        System.out.println("\n\t--------------------------\n\t");
        System.out.println("1. Add a Place,Speciality and Review\t");
        System.out.println("2. Find a Place\t");
        System.out.println("3. Rate a Place\t");
        System.out.println("4. Delete a Place\t");
        System.out.println("Enter a choice (1-4): ");

        return new Scanner(System.in).nextInt();
    }

    private void addNewPlace() {
        TouristPlace place = TouristPlace.newFromUserInput();
        map.put(place.name,place);
        System.out.println("Place Added!");
    }

    private void findAPlace() {
        TouristPlace place = new TouristPlace();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter place to be found: ");
        String placeName = scanner.next();
        if(map.containsKey(placeName)) {
            System.out.println("Place found!");
        }
        else{
            System.out.println("place not found!");
        }
    }

    private void rateAPlace() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter place name: ");
        String input = scanner.next();
        TouristPlace touristPlace = map.get(input);
        if(map.containsKey(input)){
            System.out.println("Please rate : ");
            int rating = scanner.nextInt();
            if(rating>=1 && rating<=5){
                touristPlace.rate(rating);
            }
            else{
                System.out.println("Invalid Input!");
            }
        }
        else{
            System.out.println("Place not found!");
        }
    }

    private void deleteAPlace() {
        Scanner scanner = new Scanner(System.in);
        String placeName = scanner.nextLine();
        if(map.containsKey(placeName)){
            map.remove(placeName);
        }
        else
            System.out.println("Place not found!");
    }

    private boolean wantToExit(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Do you want to continue(Y/N)");
        String input = scanner.next().toUpperCase();
        return input.equals("N");
    }

    private void showPlaces() {
        System.out.println((">>Places : "+ map.values().toString()));
    }


}

