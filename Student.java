package StudentManagments;

public class Student {

    private int id;
    private String name;
    private int age;
    private String grade;

    public Student(int id, String name, int age, String grade) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.grade = grade;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Age: " + age + ", Grade: " + grade;
    }

    public String toFileString() {
        return id + "," + name + "," + age + "," + grade;
    }

    public static Student fromFileString(String line) {
        String[] parts = line.split(",");
        if (parts.length == 4) {
            return new Student(Integer.parseInt(parts[0]), parts[1], Integer.parseInt(parts[2]), parts[3]);
        }
        return null;
    }

}
