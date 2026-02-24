package customer_manager;

public class Customer {
    private int customerId;
    private String firstName;
    private String lastName;
    private String company;
    private String city;
    private String country;
    private String phone1;
    private String phone2;
    private String email;
    private String subscription;
    private String date;

    // Constructor to initialize all fields
    public Customer(int id, String fName, String lName, String comp, String city, 
                    String country, String p1, String p2, String email, String sub, String date) {
        this.customerId = id;
        this.firstName = fName;
        this.lastName = lName;
        this.company = comp;
        this.city = city;
        this.country = country;
        this.phone1 = p1;
        this.phone2 = p2;
        this.email = email;
        this.subscription = sub;
        this.date = date;
    }

    // Getters used for sorting logic
    public int getCustomerId() { return customerId; }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getCompany() { return company; }
    public String getDate() { return date; }

    @Override
    public String toString() {
        return "ID: " + customerId + " | Name: " + firstName + " " + lastName + 
               " | Company: " + company + " | Date: " + date;
    }
}