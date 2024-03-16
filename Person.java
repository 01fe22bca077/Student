import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Person {
    private String name;
    private LocalDate dob;

    public Person(String name, String dob) {
        this.name = name;
        this.dob = LocalDate.parse(dob);
    }

    public void displayName() {
        System.out.println("Name: " + name);
    }

    public void calculateAge(String dateFormat) {
        DateTimeFormatter formatter;
        if (dateFormat.equals("dd-mm-yyyy")) {
            formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        } else if (dateFormat.equals("yyyy-mm-dd")) {
            formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        } else {
            System.out.println("Invalid date format provided.");
            return;
        }

        LocalDate currentDate = LocalDate.now();
        int age = currentDate.minusYears(dob.getYear())
                             .minusMonths(dob.getMonthValue())
                             .minusDays(dob.getDayOfMonth())
                             .getYear();

        System.out.println("Age: " + age);
    }

    public static void main(String[] args) {
        Person person1 = new Person("John Doe", "1990-03-15");
        person1.displayName();
        person1.calculateAge("yyyy-mm-dd");

        Person person2 = new Person("Jane Smith", "20-02-1995");
        person2.displayName();
        person2.calculateAge("dd-mm-yyyy");
    }
}
 