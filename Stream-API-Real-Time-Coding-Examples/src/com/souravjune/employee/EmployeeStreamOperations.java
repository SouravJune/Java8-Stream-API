package com.souravjune.employee;

import java.util.*;
import java.util.stream.Collectors;

public class EmployeeStreamOperations {

    public static void main(String[] args) {

        List<Employee> employeeList = new ArrayList<Employee>();

        employeeList.add(new Employee(111, "Jiya Brein", 32, "Female", "HR", 2011, 25000.0));
        employeeList.add(new Employee(122, "Paul Niksui", 25, "Male", "Sales And Marketing", 2015, 13500.0));
        employeeList.add(new Employee(133, "Martin Theron", 29, "Male", "Infrastructure", 2012, 18000.0));
        employeeList.add(new Employee(144, "Murali Gowda", 28, "Male", "Product Development", 2014, 32500.0));
        employeeList.add(new Employee(155, "Nima Roy", 27, "Female", "HR", 2013, 22700.0));
        employeeList.add(new Employee(166, "Axel Blaze", 43, "Male", "Security And Transport", 2016, 10500.0));
        employeeList.add(new Employee(177, "Manu Sharma", 35, "Male", "Account And Finance", 2010, 27000.0));
        employeeList.add(new Employee(188, "Wang Liu", 31, "Male", "Product Development", 2015, 34500.0));
        employeeList.add(new Employee(199, "Amelia Zoe", 24, "Female", "Sales And Marketing", 2016, 11500.0));
        employeeList.add(new Employee(200, "Jaden Dough", 38, "Male", "Security And Transport", 2015, 11000.5));
        employeeList.add(new Employee(211, "Jasna Kaur", 27, "Female", "Infrastructure", 2014, 15700.0));
        employeeList.add(new Employee(222, "Nitin Joshi", 25, "Male", "Product Development", 2016, 28200.0));
        employeeList.add(new Employee(233, "Jyothi Reddy", 27, "Female", "Account And Finance", 2013, 21300.0));
        employeeList.add(new Employee(244, "Nicolus Den", 24, "Male", "Sales And Marketing", 2017, 10700.5));
        employeeList.add(new Employee(255, "Ali Baig", 23, "Male", "Infrastructure", 2018, 12700.0));
        employeeList.add(new Employee(266, "Sanvi Pandey", 26, "Female", "Product Development", 2015, 28900.0));
        employeeList.add(new Employee(277, "Anuj Chettiar", 31, "Male", "Product Development", 2012, 35700.0));

        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        /* Question: 1. Find out the count of male and female employees present in the organization */
        Map<String, Long> noOfMaleAndFemaleEmployees = employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));

        noOfMaleAndFemaleEmployees.forEach((gender, count) -> System.out.println("No of " + gender + " employees: " + count));
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------");

        /* Question: 2. Write a program to print the names of all departments in the organization */
        List<String> departmentList = employeeList.stream()
                .map(Employee::getDepartment)
                .distinct()
                .toList();

        System.out.println("List of departments: ");
        departmentList.forEach(System.out::println);
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------");

        /* Question: 3. Find the average age of Male and Female Employees */
        Map<String, Double> avgAgeOfMaleAndFemaleEmployees = employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingInt(Employee::getAge)));

        avgAgeOfMaleAndFemaleEmployees.forEach(
                (key, value) -> System.out.println("Average age of " + key + " employees: " + String.format("%.2f", value)));
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------");

        /* Question: 4. Get the Names of employees who joined after 2015 */
        System.out.println("Name of employees who joined after 2015: ");
        employeeList.stream()
                .filter(employee -> employee.getYearOfJoining() > 2015)
                .map(Employee::getName)
                .forEach(System.out::println);

        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------");

        /* Question: 5. Count the number of employees in each department */
        employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()))
                .forEach((department, count) -> System.out.println("Number of employees in " + department + " is: " + count));

        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------");

        /* Question: 6. Find out the average salary of each department */
        employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary)))
                .forEach((department, avg) -> System.out.println("Average salary of employees in " + department + " is: " + String.format("%.2f", avg)));

        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------");

        /* Question: 7. Find out the oldest employee, his/her age and department */
        Employee oldestEmployee = employeeList.stream()
                .max(Comparator.comparingInt(Employee::getAge)).get();

        System.out.println("Name : " + oldestEmployee.getName());
        System.out.println("Age : " + oldestEmployee.getAge());
        System.out.println("Department : " + oldestEmployee.getDepartment());
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------");

        /* Question: 8. Find out the average and total salary of the organization */
        DoubleSummaryStatistics empSalary = employeeList.stream()
                .collect(Collectors.summarizingDouble(Employee::getSalary));

        System.out.println("Average Salary = " + String.format("%.2f", empSalary.getAverage()));
        System.out.println("Total Salary = "+empSalary.getSum());
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------");

        /* Question: 9. List down the employees of each department */
        Map<String, List<Employee>> empDeptList = employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));

        for (Map.Entry<String, List<Employee>> entry : empDeptList.entrySet()) {
            System.out.println("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-");
            System.out.println("Employees In " + entry.getKey() + " : ");
            System.out.println("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-");

            List<Employee> list = entry.getValue();
            for (Employee e : list) {
                System.out.println(e.getName());
            }
        }
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------");

        /* Question: 10. Find out the highest experienced employees in the organization */
        Optional<Employee> seniorEmp = employeeList.stream()
                .min(Comparator.comparingInt(Employee::getYearOfJoining));

        Employee seniorMostEmployee = seniorEmp.get();

        System.out.println("Senior Most Employee Details :");
        System.out.println("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-");
        System.out.println("ID : "+seniorMostEmployee.getId());
        System.out.println("Name : "+seniorMostEmployee.getName());
        System.out.println("Age : "+seniorMostEmployee.getAge());
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------");

    }
}
