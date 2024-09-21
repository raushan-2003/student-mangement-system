import java.util.ArrayList;
import java.util.Scanner;

public class StudentManagementSystem {
    private ArrayList<Student> students;
    private Scanner scanner;

    public StudentManagementSystem() {
        students = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public void addStudent() {
        System.out.print("Enter name: ");
        String name = scanner.nextLine();

        System.out.print("Enter roll number: ");
        String rollNumber = scanner.nextLine();

        System.out.print("Enter grade: ");
        String grade = scanner.nextLine();

        if (name.isEmpty() || rollNumber.isEmpty() || grade.isEmpty()) {
            System.out.println("All fields are required.");
            return;
        }

        students.add(new Student(name, rollNumber, grade));
        System.out.println("Student added successfully!");
    }

    public void removeStudent() {
        System.out.print("Enter roll number of the student to remove: ");
        String rollNumber = scanner.nextLine();
        boolean removed = students.removeIf(student -> student.getRollNumber().equals(rollNumber));

        if (removed) {
            System.out.println("Student removed successfully!");
        } else {
            System.out.println("Student not found.");
        }
    } 

    public void searchStudent() {
        System.out.print("Enter roll number to search: ");
        String rollNumber = scanner.nextLine();
        for (Student student : students) {
            if (student.getRollNumber().equals(rollNumber)) {
                System.out.println("Student found: " + student);
                return;
            }
        }
        System.out.println("Student not found.");
    }

    public void displayAllStudents() {
        if (students.isEmpty()) {
            System.out.println("No students to display.");
        } else {
            for (Student student : students) {
                System.out.println(student);
            }
        }
    }

    public void displayMenu() {
        System.out.println("\n******************** Student Management System ********************\n");
        System.out.println("1. Add Student");
        System.out.println("2. Remove Student");
        System.out.println("3. Search Student");
        System.out.println("4. Display All Students");
        System.out.println("5. Exit");
        System.out.print("\nSelect an option: ");
    }

    public void run() {
        while (true) {
            displayMenu();
            int choice = scanner.nextInt();
            scanner.nextLine(); 
            System.out.println();
            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    removeStudent();
                    break;
                case 3:
                    searchStudent();
                    break;
                case 4:
                    displayAllStudents();
                    break;
                case 5:
                    System.out.println("Exiting the system. Goodbye!\n\n");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    public static void main(String[] args) {
        StudentManagementSystem system = new StudentManagementSystem();
        system.run();
    }
}
