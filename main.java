package campus;

import java.util.ArrayList;
import java.util.Scanner;

// Abstract class
abstract class Person {

    protected String name;
    protected int age;

    // Constructor
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Abstract method
    public abstract void displayInfo();
}

// Student class inherits Person
class Student extends Person {

    // Encapsulation
    private int studentId;
    private String department;

    // Constructor
    public Student(String name, int age, int studentId, String department) {
        super(name, age);
        this.studentId = studentId;
        this.department = department;
    }

    // Getter
    public int getStudentId() {
        return studentId;
    }

    // Setter
    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    // Method overriding
    @Override
    public void displayInfo() {
        System.out.println("\n----- Student Information -----");
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Student ID: " + studentId);
        System.out.println("Department: " + department);
    }
}

// Service Request class
class ServiceRequest {

    private String serviceType;

    // Constructor
    public ServiceRequest(String serviceType) {
        this.serviceType = serviceType;
    }

    public void showRequest() {
        System.out.println("Requested Service: " + serviceType);
    }
}

// Main class
public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        // ArrayList
        ArrayList<Student> students = new ArrayList<>();

        try {

            System.out.println("===== Smart Campus Service System =====");

            System.out.print("Enter student name: ");
            String name = input.nextLine();

            System.out.print("Enter age: ");
            int age = input.nextInt();

            System.out.print("Enter student ID: ");
            int id = input.nextInt();

            input.nextLine();

            System.out.print("Enter department: ");
            String department = input.nextLine();

            System.out.println("\nChoose a service request:");
            System.out.println("1. Wi-Fi Support");
            System.out.println("2. ID Card Replacement");
            System.out.println("3. Dormitory Maintenance");
            System.out.println("4. Library Support");

            System.out.print("Enter choice: ");
            int choice = input.nextInt();

            input.nextLine();

            String service = "";

            switch(choice) {
                case 1:
                    service = "Wi-Fi Support";
                    break;
                case 2:
                    service = "ID Card Replacement";
                    break;
                case 3:
                    service = "Dormitory Maintenance";
                    break;
                case 4:
                    service = "Library Support";
                    break;
                default:
                    service = "Unknown Service";
            }

            // Polymorphism
            Person student = new Student(name, age, id, department);

            students.add((Student) student);

            ServiceRequest request = new ServiceRequest(service);

            System.out.println("\nService Request Submitted Successfully!");

            // Display information
            for(Student s : students) {
                s.displayInfo();
                request.showRequest();
            }

        } catch(Exception e) {

            // Exception handling
            System.out.println("Invalid input! Please enter correct information.");

        }

        input.close();
    }
}
