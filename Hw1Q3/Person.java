public class Person {

    private String firstName;
    private String lastName;
    private String id;

    // Constructor with three parameters
    public Person(String firstName, String lastName, String id) {
        this.firstName = firstName;
        this.lastName = lastName;
        // Make this unique 
        this.id = id;
    }

    // Accessor methods (aka getters)
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getId() {
        return id;
    }

    //just gives all the info
    public String toString() {
        return firstName + " " + lastName + ", ID: " + id;
    }
}

