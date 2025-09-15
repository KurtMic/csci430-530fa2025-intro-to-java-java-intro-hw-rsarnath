import java.util.LinkedList;
import java.util.Scanner;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.*;

public class MyMain {
    public static void main(String[] args) {

        // Scanner to accept user input
        Scanner scanner = new Scanner(System.in);

        // variables for selector interface
        int select = 0;
        String file;
        String search;
        String idSearch;


        // LinkedList of Person objects (kinda sloppy, but it works)
        LinkedList<Person> personList = new LinkedList<>();
        //*******************Interface**********************************
        System.out.println("****************************Program Start****************************");
        while(select == 0) {
            System.out.println("****************************Interface Open****************************");
            System.out.println("Please select an option from the following choices: ");
            System.out.println("1: Enter a file open and display content");
            System.out.println("2: Display all users in file");
            System.out.println("3: Search for an id");
            System.out.println("4: Create new file");
            System.out.println("5: Close Program");
            System.out.print("Select Choice: ");
            select = scanner.nextInt();

            if (select == 1){
                System.out.print("Enter a file name: ");
                search = scanner.next();
                File inputFile = new File(search);
                if (!inputFile.exists()) {
                    System.out.println("Error: data.txt not found!");
                }
                else {
                    // Try and Catch to prevent errors when opening file
                    try (FileInputStream fileInputStream = new FileInputStream(inputFile)) {

                        // Store the person data into the LinkedList
                        store(fileInputStream, personList);

                        // Display everyone in the LinkedList
                        display(System.out, personList);

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                select = 0;
            }
            else if (select == 2) {
                //Display list
                display(System.out, personList);
                select = 0;
            }
            else if (select == 3) {
                System.out.println("***If an ID is not found you will get a -1 ***");
                System.out.print("Search for an ID: ");
                idSearch = scanner.next();
                System.out.println("Find ID " + idSearch + ": Index Location is: " + find(idSearch, personList));

                select = 0;
            }
            else if (select == 4) {
                //Not required Could implement later
                select = 0;
            }
            else if (select == 5) {
                System.out.println("Exiting program...");
                select = 1;
            }

        }
        System.out.println("****************************Interface Closed****************************");

        //close scanner to prevent runtime errors
        scanner.close();
    }

    // Method  that reads the data for several persons from
    // the input stream and stores the data in the linked list.
    public static void store(InputStream inputStream, LinkedList<Person> list) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                String firstName = data[0];
                String lastName = data[1];
                String id = data[2];
                Person person = new Person(firstName, lastName, id);
                list.add(person);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Method that writes the data for all person objects in the linked list,
    // on the output stream, one per line.
    public static void display(PrintStream outputStream, LinkedList<Person> list) {
        for (Person person : list) {
            outputStream.println(person);
        }
    }

    // Method that indexes the person object in the linked list
    public static int find(String id, LinkedList<Person> list) {
        for (int x = 0; x < list.size(); x++) {
            if (list.get(x).getId().equals(id)) {
                return x; //Return the index location if ID matched
            }
        }
        return -1; //Return -1 for no ID matches
    }
}
