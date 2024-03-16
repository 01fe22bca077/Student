import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Student {
    private String name;
    private String dob;

    public Student(String name, String dob) {
        this.name = name;
        this.dob = dob;
    }

    public void displayName() {
        System.out.println("Student Name: " + name);
    }

    public void displayAge() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate dobDate = LocalDate.parse(dob, formatter);
        LocalDate today = LocalDate.now();
        Period age = Period.between(dobDate, today);
        System.out.println("Age of " + name + ": " + age.getYears() + " years");
    }

    public static void main(String[] args) {
        Student student1 = new Student("John Doe", "15-08-2000");
        student1.displayName();
        student1.displayAge();
    }
}

