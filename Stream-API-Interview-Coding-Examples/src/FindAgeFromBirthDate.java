import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;

public class FindAgeFromBirthDate {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your birthdate (YYYY-MM-DD):");
        String birthDate = scanner.nextLine();

        Period age = Period.between(LocalDate.parse(birthDate), LocalDate.now());

        System.out.println("You are " + age.getYears() + " years old.");
    }
}
