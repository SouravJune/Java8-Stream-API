package com.souravjune.streaminterface.methods;

import com.souravjune.model.Process;
import com.souravjune.model.*;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;

public class AllMatch {

    /*
       Method: allMatch(Predicate<? super T> predicate) ->
       Description: Returns whether all elements of this stream match the provided predicate.
       Modifier and Type: boolean
     */

    public static void main(String[] args) {

        /* 1. Verify if all numbers in a list are even. */
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------");
        List<Integer> numbers = Arrays.asList(2, 4, 6, 8);

        boolean allEven = numbers.stream()
                .allMatch(n -> n % 2 == 0);

        System.out.println("Verify if all numbers in a list are even: " + allEven);
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------");

        /* Check that all numbers in a list are powers of two. */
        List<Integer> numbersList = Arrays.asList(2, 4, 8, 16);

        boolean allPowersOfTwo = numbers.stream()
                .allMatch(n -> (n & (n - 1)) == 0);

        System.out.println("Check that all numbers in a list are powers of two: " + allPowersOfTwo);
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------");

        /* Ensure that all support tickets are marked as "Closed". */
        List<Ticket> tickets = Ticket.getTickets();

        boolean allClosed = tickets.stream()
                .allMatch(ticket -> ticket.getStatus() == Status.CLOSED);

        System.out.println("Ensure that all support tickets are marked as \"Closed\": " + allClosed);
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------");

        /* 2. Check if all strings in a list have a length greater than 3. */
        List<String> fruits = Arrays.asList("apple", "banana", "cherry");

        boolean allLongerThanThree = fruits.stream()
                .allMatch(s -> s.length() > 3);

        System.out.println("Check if all strings in a list have a length greater than 3: " + allLongerThanThree);
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------");

        /* 3. Ensure all elements in a list are non-null. */
        List<String> fruitList = Arrays.asList("apple", "banana", "cherry");

        boolean allNonNull = fruitList.stream()
                .allMatch(Objects::nonNull);

        System.out.println("Ensure all elements in a list are non-null:" + allNonNull);
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------");

        /* 4. Verify that all strings in a list are non-empty. */
        List<String> strings = Arrays.asList("apple", "banana", "cherry");

        boolean allNonEmpty = strings.stream()
                .allMatch(String::isEmpty); // s -> !s.isEmpty()
        System.out.println("Verify that all strings in a list are non-empty: " + allNonEmpty);
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------");

        /* Check if all strings contain only digits. */
        List<String> numericStrings = Arrays.asList("12345", "67890", "24680");

        boolean allNumeric = numericStrings.stream()
                .allMatch(str -> str.matches("\\d+"));
        //.allMatch(str -> str.chars().allMatch(Character::isDigit));

        System.out.println("Check if all strings contain only digits: " + allNumeric);
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------");

        /* 4. Check if all employees joining date before 2015. */
        List<Employee> employeeList = Employee.getEmployee();

        boolean match = employeeList.stream()
                .allMatch(e -> e.getYearOfJoining() < 2015);

        System.out.println("Check if all employees joining date before 2015: " + match);
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------");

        /* 4. Check if all employees are older than 30 and earn more than 50,000. */
        boolean allMatch = Employee.getEmployee().stream()
                .allMatch(e -> e.getAge() > 30 && e.getSalary() > 50000);

        System.out.println("Check if all employees are older than 30 and earn more than 50,000: " + allMatch);
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------");

        /* 5. Verify if all products in a list are in stock and have a price greater than 10,000. */
        List<Product> products = Product.getProducts();

        boolean allInStockAndExpensive = products.stream()
                .allMatch(p -> p.isInStock() && p.getProductPrice() > 10000);

        System.out.println("Verify if all products in a list are in stock and have a price greater than 10,000: " + allInStockAndExpensive);
        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------");

        /* Check that all products in a list have a price within a specific range. */
        boolean allWithinRange =  Product.getProducts().stream()
                .allMatch(product -> product.getProductPrice() >= 10000 && product.getProductPrice() <= 100000);

        System.out.println("Check that all products in a list have a price within a specific range: " + allWithinRange);
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------");

        /* Confirm that all processes in a list are running. */
        List<Process> processes = Process.getProcesses();
        boolean allActive = processes.stream()
                .allMatch(Process::isRunning);

        System.out.println("Confirm that all processes in a list are running: " + allActive);
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------");

        /* 6. Ensure all strings start with an uppercase letter. */
        List<String> fruitsList = Arrays.asList("Apple", "Banana", "Cherry");

        boolean allStartWithUppercase = fruitsList.stream()
                .allMatch(s -> Character.isUpperCase(s.charAt(0)));

        System.out.println("Ensure all strings start with an uppercase letter: " + allStartWithUppercase);
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------");

        /* 7. Check if all numbers in a list are within a specific range. */
        List<Integer> numberList = Arrays.asList(10, 20, 30, 40);

        boolean allInRange = numberList.stream()
                .allMatch(n -> n >= 10 && n <= 50);

        System.out.println("Check if all numbers in a list are within a specific range: " + allInRange);
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------");

        /* Check that all strings in a list are palindromes. */
        List<String> words = Arrays.asList("madam", "wow", "level");

        boolean allPalindromes = words.stream()
                .allMatch(word -> new StringBuilder(word).reverse().toString().equals(word));

        System.out.println("Check that all strings in a list are palindromes: " + allPalindromes);
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------");

        /* Verify that all appointments are scheduled between 12 PM and 6 PM. */
        List<Appointment> appointments = Appointment.getAppointments();

        boolean allAfternoon = appointments.stream()
                .allMatch(appointment -> {
                    LocalTime time = appointment.getTime();
                    return time.isAfter(LocalTime.NOON) && time.isBefore(LocalTime.of(18, 0));
                });

        System.out.println("Verify that all appointments are scheduled between 12 PM and 6 PM: " + allAfternoon);
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------");

        /*******************************************/
        /*******************************************/
        /* Check if All Elements Start with a Specific Character: Verify that all strings in a list start with the letter 'A'. */
        List<String> names = Arrays.asList("Alice", "Adam", "Aaron");

        boolean allStartWithA = names.stream()
                .allMatch(name -> name.startsWith("A"));

        System.out.println("Verify that all strings in a list start with the letter 'A': " + allStartWithA);
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------");

        /* Verify All Elements Contain a Substring: Ensure all strings in a list contain the substring "ing". */
        List<String> wordsList = Arrays.asList("running", "singing", "dancing");

        boolean allContainIng = wordsList.stream()
                .allMatch(word -> word.contains("ing"));

        System.out.println("Ensure all strings in a list contain the substring \"ing\": " + allContainIng);
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------");

        /* Check if All Objects Have a Specific Attribute Value: Ensure all employees belong to the "IT" department. */
        boolean allInITDepartment = Employee.getEmployee().stream()
                .allMatch(emp -> "IT".equals(emp.getDepartment()));

        System.out.println("Ensure all employees belong to the \"IT\" department: " + allInITDepartment);
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------");

        /* Ensure All Elements Have a Specific Length: Check if all strings in a list have exactly 5 characters. */
        List<String> codes = Arrays.asList("12345", "ABCDE", "XYZ12");

        boolean allHaveLengthFive = codes.stream()
                .allMatch(code -> code.length() == 5);

        System.out.println("Check if all strings in a list have exactly 5 characters: " + allHaveLengthFive);
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------");

        /* Validate All Numbers Are Prime: Verify that all numbers in a list are prime. */
        List<Integer> primeNumbers = Arrays.asList(2, 18, 5, 7);

        boolean booleanList = primeNumbers.stream()
                .allMatch(number -> number > 1 && IntStream.range(2, number).allMatch(i -> number % i != 0));

        System.out.println("Verify that all numbers in a list are prime: " + booleanList);
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------");

        /* Check if All Dates Are Weekends: Ensure all dates in a list are Saturdays or Sundays. */
        List<LocalDate> dates = Arrays.asList(
                LocalDate.of(2024, 8, 24),
                LocalDate.of(2024, 8, 25),
                LocalDate.of(2024, 8, 31)
        );

        boolean allAreWeekends = dates.stream()
                .allMatch(date -> date.getDayOfWeek() == DayOfWeek.SATURDAY || date.getDayOfWeek() == DayOfWeek.SUNDAY);

        System.out.println("Ensure all dates in a list are Saturdays or Sundays: " + allAreWeekends);
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------");

        /* Confirm All Files Have a Certain Extension: Check if all file names in a list end with ".pdf". */
        List<String> fileNames = Arrays.asList("document1.pdf", "file2.pdf", "report.pdf");

        boolean allPDFs = fileNames.stream()
                .allMatch(name -> name.endsWith(".pdf"));

        System.out.println("Check if all file names in a list end with \".pdf\": " + allPDFs);
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------");

        /* Verify All Transactions Exceed a Minimum Value: Confirm that all transactions have an amount greater than 1000. */
        boolean allAboveThreshold = Transaction.getTransactions().stream()
                .allMatch(transaction -> transaction.getAmount() > 1000);

        System.out.println("Confirm that all transactions have an amount greater than 1000: " + allAboveThreshold);
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------");

        /* Ensure All Strings Follow a Specific Pattern: Verify that all strings in a list follow camelCase naming convention. */
        List<String> identifiers = Arrays.asList("camelCase", "anotherExample", "thirdTest");

        /* Regex: ^[a-z]+([A-Z][a-z]*)*$
        - Matches strings starting with lowercase letters followed by camelCase patterns.
        - ^         : Start of the string
        - [a-z]+    : One or more lowercase letters
        - ([A-Z][a-z]*)* : Zero or more groups of an uppercase letter followed by zero or more lowercase letters
        - $         : End of the string
        */

        boolean allCamelCase = identifiers.stream()
                .allMatch(id -> id.matches("^[a-z]+([A-Z][a-z]*)*$"));

        System.out.println("Verify that all strings in a list follow camelCase naming convention: " + allCamelCase);
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------");

<<<<<<< Updated upstream
        numberList.stream().anyMatch(null);
=======
        /* Check if All Products Are In Stock: Ensure that all products in a list are in stock. */
        boolean allInStock = Product.getProducts().stream()
                .allMatch(Product::isInStock);

        System.out.println("Ensure that all products in a list are in stock: " + allInStock);
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------");



>>>>>>> Stashed changes
    }
}