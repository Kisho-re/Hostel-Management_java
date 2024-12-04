import java.util.ArrayList;
import java.util.Scanner;

// Student class to store student information
class Student {
    private String name;
    private int roomNumber;
    private String department;
    private String contactNumber;

    public Student(String name, int roomNumber, String department, String contactNumber) {
        this.name = name;
        this.roomNumber = roomNumber;
        this.department = department;
        this.contactNumber = contactNumber;
    }

    public String getName() {
        return name;
    }

    public void displayStudentDetails() {
        System.out.println("Name: " + name);
        System.out.println("Room Number: " + roomNumber);
        System.out.println("Department: " + department);
        System.out.println("Contact Number: " + contactNumber);
        System.out.println("--------------------");
    }
}

// Hostel Management System
public class HostelManagementSystem {
    private static ArrayList<Student> studentList = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\nHostel Management System");
            System.out.println("1. Add Student");
            System.out.println("2. Display All Students");
            System.out.println("3. Search Student by Name");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    displayAllStudents();
                    break;
                case 3:
                    searchStudentByName();
                    break;
                case 4:
                    System.out.println("Exiting... Thank you!");
                    return;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }

    // Method to add a new student
    private static void addStudent() {
        System.out.print("Enter Student Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Room Number: ");
        int roomNumber = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        System.out.print("Enter Department: ");
        String department = scanner.nextLine();

        System.out.print("Enter Contact Number: ");
        String contactNumber = scanner.nextLine();

        Student student = new Student(name, roomNumber, department, contactNumber);
        studentList.add(student);

        System.out.println("Student added successfully!");
    }

    // Method to display all students
    private static void displayAllStudents() {
        if (studentList.isEmpty()) {
            System.out.println("No students found.");
        } else {
            System.out.println("Student Details:");
            for (Student student : studentList) {
                student.displayStudentDetails();
            }
        }
    }

    // Method to search for a student by name
    private static void searchStudentByName() {
        System.out.print("Enter the student's name to search: ");
        String name = scanner.nextLine();
        boolean found = false;

        for (Student student : studentList) {
            if (student.getName().equalsIgnoreCase(name)) {
                System.out.println("Student Found:");
                student.displayStudentDetails();
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Student not found.");
        }
    }
}