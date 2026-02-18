package StudentManagments;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class StudentManagementSystem {

    private Student[] students;
    private int count;
    private static final int INITIAL_SIZE = 10;
    private static final String FILE_NAME = "students.txt";

    public StudentManagementSystem() {
        students = new Student[INITIAL_SIZE];
        count = 0;
        loadFromFile();
    }

    private void resizeArray() {
        Student[] newArray = new Student[students.length * 2];
        System.arraycopy(students, 0, newArray, 0, count);
        students = newArray;
    }

    public void addStudent(Student student) {
        if (count == students.length) {
            resizeArray();
        }
        students[count++] = student;
        saveToFile();
    }

    public boolean deleteStudent(int id) {
        for (int i = 0; i < count; i++) {
            if (students[i].getId() == id) {
                for (int j = i; j < count - 1; j++) {
                    students[j] = students[j + 1];
                }
                students[--count] = null;
                saveToFile();
                return true;
            }
        }
        return false;
    }

    public boolean updateStudent(int id, String name, int age, String grade) {
        for (int i = 0; i < count; i++) {
            if (students[i].getId() == id) {
                students[i].setName(name);
                students[i].setAge(age);
                students[i].setGrade(grade);
                saveToFile();
                return true;
            }
        }
        return false;
    }

    public void displayStudents() {
        if (count == 0) {
            System.out.println("No students to display.");
            return;
        }
        for (int i = 0; i < count; i++) {
            System.out.println(students[i]);
        }
    }

    private void saveToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (int i = 0; i < count; i++) {
                writer.write(students[i].toFileString());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving to file: " + e.getMessage());
        }
    }

    private void loadFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                Student student = Student.fromFileString(line);
                if (student != null) {
                    if (count == students.length) {
                        resizeArray();
                    }
                    students[count++] = student;
                }
            }
        } catch (FileNotFoundException e) {
        } catch (IOException e) {
            System.out.println("Error loading from file: " + e.getMessage());
        }
    }


}
