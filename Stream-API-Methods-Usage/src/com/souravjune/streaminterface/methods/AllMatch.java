package com.souravjune.streaminterface.methods;

import com.souravjune.model.Appointment;
import com.souravjune.model.Employee;
import com.souravjune.model.Product;

import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class AllMatch {

    /* Method: allMatch(Predicate<? super T> predicate) ->
       Description: Returns whether all elements of this stream match the provided predicate.
       Modifier and Type: boolean
     */

    public static void main(String[] args) {

        /* 1. Verify if all numbers in a list are even. */
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        List<Integer> numbers = Arrays.asList(2, 4, 6, 8);

        boolean allEven = numbers.stream()
                .allMatch(n -> n % 2 == 0);

        System.out.println("Verify if all numbers in a list are even: " + allEven);
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------");

        /* 2. Check if all strings in a list have a length greater than 3. */
        List<String> fruits = Arrays.asList("apple", "banana", "cherry");

        boolean allLongerThanThree = fruits.stream()
                .allMatch(s -> s.length() > 3);

        System.out.println("Check if all strings in a list have a length greater than 3: " + allLongerThanThree);
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------");

        /* 3. Ensure all elements in a list are non-null. */
        List<String> fruitList = Arrays.asList("apple", "banana", "cherry");

        boolean allNonNull = fruitList.stream()
                .allMatch(Objects::nonNull);

        System.out.println("Ensure all elements in a list are non-null:" + allNonNull);
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------");

        /* 4. Verify that all strings in a list are non-empty. */
        List<String> strings = Arrays.asList("apple", "banana", "cherry");

        boolean allNonEmpty = strings.stream()
                .allMatch(String::isEmpty); // s -> !s.isEmpty()
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------");

        System.out.println("Verify that all strings in a list are non-empty: " + allNonEmpty);

        /* 4. Check if all employees are older than 30 and earn more than 50,000. */
        List<Employee> employeeList = Employee.getEmployee();

        boolean allMatch = employeeList.stream()
                .allMatch(e -> e.getAge() > 30 && e.getSalary() > 50000);

        System.out.println("Check if all employees are older than 30 and earn more than 50,000: " + allMatch);
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------");

        /* 5. Verify if all products in a list are in stock and have a price greater than 10,000. */
        List<Product> products = Product.getProducts();

        boolean allInStockAndExpensive = products.stream()
                .allMatch(p -> p.isInStock() && p.getProductPrice() > 10000);

        System.out.println("Verify if all products in a list are in stock and have a price greater than 10,000: " + allInStockAndExpensive);
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------");

        /* 6. Ensure all strings start with an uppercase letter. */
        List<String> fruitsList = Arrays.asList("Apple", "Banana", "Cherry");

        boolean allStartWithUppercase = fruitsList.stream()
                .allMatch(s -> Character.isUpperCase(s.charAt(0)));

        System.out.println("Ensure all strings start with an uppercase letter: " + allStartWithUppercase);
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------");

        /* 7. Check if all numbers in a list are within a specific range. */
        List<Integer> numberList = Arrays.asList(10, 20, 30, 40);

        boolean allInRange = numberList.stream()
                .allMatch(n -> n >= 10 && n <= 50);

        System.out.println("Check if all numbers in a list are within a specific range: " + allInRange);
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------");

        /* Check that all strings in a list are palindromes. */
        List<String> words = Arrays.asList("madam", "wow", "level");

        boolean allPalindromes = words.stream()
                .allMatch(word -> new StringBuilder(word).reverse().toString().equals(word));

        System.out.println("Check that all strings in a list are palindromes: " + allPalindromes);
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------");

        /* Verify that all appointments are scheduled between 12 PM and 6 PM. */
        List<Appointment> appointments = Appointment.getAppointments();

        boolean allAfternoon = appointments.stream()
                .allMatch(appointment -> {
                    LocalTime time = appointment.getTime();
                    return time.isAfter(LocalTime.NOON) && time.isBefore(LocalTime.of(18, 0));
                });

        System.out.println("Verify that all appointments are scheduled between 12 PM and 6 PM: " + allAfternoon);
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------");


































    }
}