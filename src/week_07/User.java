package week_07;

public class User {
    // access modifier public, private, default,

    private String name; // properties , attributes
    private String emailAddress;
    private String lastName;
    private double id;

    // default constructor
    // this.
    public User(String name, String emailAddress) { // public User(String, STring)
        this();
        this.name = name;
        this.emailAddress = emailAddress;

        System.out.println("New user. name is : " + this.name);

    }

    public User() {
        System.out.println("A user is born. No name");
        this.setRandomId();
    }

    // use once?
    public void setRandomId() {
        this.id = Math.random();
    }

    public void sayHello() {
        System.out.println(this.name + " says hello");
    }

    public static void sayWelcome() {
        System.out.println("Welcome user!");
    }

    // getter
    public String getEmailAddress() {
        return this.emailAddress;
    }

    // setter
    public void setEmailAddress(String email) {
        this.emailAddress = email;
        this.login("Izmir");
        this.sendNotification();
        System.out.println("Email has been changed");
    }

    public String getName() {
        return this.name.substring(0, 1).toUpperCase() + this.name.substring(1);
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return this.lastName.substring(0, 1).toUpperCase() + this.lastName.substring(1);
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void login(String city) {
        System.out.println("New login to your account from " + city);
    }

    public void sendNotification() {
        System.out.println("Suspicious activity detected!");

    }

}
