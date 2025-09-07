import java.util.LinkedList;
import java.io.*;

public class PersonList {

    //uses the person class for list
    private LinkedList<Person> list;

    // Linked List Constructor
    public PersonList() {
        this.list = new LinkedList<>();
    }

    // Method  that reads the data for several persons from
    // the input stream and stores the data in the linked list.
    public void store(InputStream inputStream) {
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
    public void display(PrintStream outputStream) {
        for (Person person : list) {
            outputStream.println(person);
        }
    }

    // Method that indexes the person object in the linked list
    public int find(String id) {
        for (int x = 0; x < list.size(); x++) {
            if (list.get(x).getId().equals(id)) {
                return x; //Return the index location if ID matched
            }
        }
        return -1; //Return -1 for no ID matches
    }
}

