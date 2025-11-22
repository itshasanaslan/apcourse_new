package week_03;

// Classes are Blueprints.
// Once an object of a class is created, it's called "instance". The process is called instantiation.
// StudentProfile profile1 = new StudentProfile() => profile1 is an instance of StudentProfile
public class StudentProfile {
    //
    String lastName;
    String id;
    double gpa; // 0.0
    String name;
    boolean hasFailed;

    // if you don't have any constructors, there's an empty constructor added
    // automatically in the background.

    // constructor with parameters. Because the signature is changed, we cannot
    // instantiate with empty constructor new StudentProfile() anymore.
    // We can overload it by hard coding an empty constructor.
    public StudentProfile(String x, String y, String z, boolean s, double t) {
        name = x;
        lastName = y;
        id = z;
        hasFailed = s;
        gpa = t;
        System.out.println("Student is created.");
    }

    // constructor overloading, arguments in the parameters in respective order.
    public StudentProfile(String x, String y, String z) {
        name = x;
        lastName = y;
        id = z;
        System.out.println("Student is created. No gpa is given. Probably a new one.");
    }

    // method info
    public void info() {
        System.out.println(name + " " + lastName + ".Gpa:" + gpa + " Has failed:" + hasFailed);
        System.out.println("I am doing something for you 10 times");
        System.out.println("I am doing something for you 10 times");
        System.out.println("I am doing something for you 10 times");
        System.out.println("I am doing something for you 10 times");
        System.out.println("I am doing something for you 10 times");
        System.out.println("I am doing something for you 10 times");
        System.out.println("I am doing something for you 10 times");
        System.out.println("I am doing something for you 10 times");
        System.out.println("I am doing something for you 10 times");
        System.out.println("I am doing something for you 10 times");
        System.out.println("I am doing something for you 10 times");
        System.out.println("I am doing something for you 10 times");
        System.out.println("I am doing something for you 10 times");
        System.out.println("I am doing something for you 10 times");
        System.out.println("I am doing something for you 10 times");

    }

    // method overloading for method info. Computer decides which method to call by
    // looking at method signature.
    public void info(double newGpa) {
        gpa = newGpa;
        info();

    }

}
