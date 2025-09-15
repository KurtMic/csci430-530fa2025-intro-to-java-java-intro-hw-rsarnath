import java.io.*;
import java.util.Scanner;

public class MyMain {
    public static void main(String[] args) {

        //Instantiate a PersonList object to manage Person objects
        PersonList personList = new PersonList();

        // Scanner to accept user input
        Scanner scanner = new Scanner(System.in);

        // variables for selector interface
        int select = 0;
        String file;
        String search;
        String idSearch;
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
                        personList.store(fileInputStream); // Call store method to read and store persons

                        // Display everyone in the LinkedList
                        personList.display(System.out); // Call display method to print all persons

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                select = 0;
            }
            else if (select == 2) {
                //Display list
                personList.display(System.out); // Call display method to print all persons
                select = 0;
            }
            else if (select == 3) {
                System.out.println("***If an ID is not found you will get a -1 ***");
                System.out.print("Search for an ID: ");
                idSearch = scanner.next();
                System.out.println("Find ID " + idSearch + ": Index Location is: " + personList.find(idSearch));

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
        System.out.println("****************************Program End****************************");
        //close scanner to prevent runtime errors
        scanner.close();


    }
}
