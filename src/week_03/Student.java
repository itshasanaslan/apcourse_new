package week_03;

public class Student {
    //
    public String name;
    public String lastName;
    public double gpa;

    // creating a student object
    public Student(String x, String t, double p) {
        this.name = x;
        this.lastName = t;
        this.gpa = p;
    }

    public void printInfo() {
        System.out.println("Student name: " + name);
        System.out.println("Last Name: " + lastName);
        System.out.println("Gpa:  " + gpa);

    }

    public static void whiteboard() {
        System.out.println("Whiteboard for everyone...");
    }

}
