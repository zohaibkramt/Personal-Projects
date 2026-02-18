package StudentManagments;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StudentManagementSystem sms = new StudentManagementSystem();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nStudent Management System");
            System.out.println("1. Add Student");
            System.out.println("2. Delete Student");
            System.out.println("3. Update Student");
            System.out.println("4. Display Students");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Age: ");
                    int age = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter Grade: ");
                    String grade = scanner.nextLine();
                    sms.addStudent(new Student(id, name, age, grade));
                    System.out.println("Student added.");
                    break;
                case 2:
                    System.out.print("Enter ID to delete: ");
                    id = scanner.nextInt();
                    if (sms.deleteStudent(id)) {
                        System.out.println("Student deleted.");
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;
                case 3:
                    System.out.print("Enter ID to update: ");
                    id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter new Name: ");
                    name = scanner.nextLine();
                    System.out.print("Enter new Age: ");
                    age = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter new Grade: ");
                    grade = scanner.nextLine();
                    if (sms.updateStudent(id, name, age, grade)) {
                        System.out.println("Student updated.");
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;
                case 4:
                    sms.displayStudents();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }


}
