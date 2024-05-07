package com.souravjune.employee;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EmployeeStreamOperations {

    public static void main(String[] args) {

        List<Employee> employeeList = new ArrayList<Employee>();

        employeeList.add(new Employee(111, "Jiya Brein", 32, "Female", "HR", 2011, "Kolkata",25000.0));
        employeeList.add(new Employee(122, "Paul Niksui", 25, "Male", "Sales And Marketing", 2015, "Hyderabad",13500.0));
        employeeList.add(new Employee(133, "Martin Theron", 29, "Male", "Infrastructure", 2012, "Kolkata",18000.0));
        employeeList.add(new Employee(144, "Murali Gowda", 28, "Male", "Product Development", 2014, "Bangalore",32500.0));
        employeeList.add(new Employee(155, "Nima Roy", 27, "Female", "HR", 2013, "Pune",22700.0));
        employeeList.add(new Employee(166, "Axel Blaze", 43, "Male", "Security And Transport", 2016, "Pune",10500.0));
        employeeList.add(new Employee(177, "Manu Sharma", 35, "Male", "Account And Finance", 2010, "Kolkata",27000.0));
        employeeList.add(new Employee(188, "Wang Liu", 31, "Male", "Product Development", 2015, "Hyderabad",34500.0));
        employeeList.add(new Employee(199, "Amelia Zoe", 24, "Female", "Sales And Marketing", 2016, "Kolkata",11500.0));
        employeeList.add(new Employee(200, "Jaden Dough", 38, "Male", "Security And Transport", 2015, "Bangalore",11000.5));
        employeeList.add(new Employee(211, "Jasna Kaur", 27, "Female", "Infrastructure", 2014, "Gurugram",15700.0));
        employeeList.add(new Employee(222, "Nitin Joshi", 25, "Male", "Product Development", 2016, "Hyderabad",28200.0));
        employeeList.add(new Employee(233, "Jyothi Reddy", 27, "Female", "Account And Finance", 2013, "Kolkata",21300.0));
        employeeList.add(new Employee(244, "Nicolus Den", 24, "Male", "Sales And Marketing", 2017, "Chennai",10700.5));
        employeeList.add(new Employee(255, "Ali Baig", 23, "Male", "Infrastructure", 2018, "Trivandrum",12700.0));
        employeeList.add(new Employee(266, "Sanvi Pandey", 26, "Female", "Product Development", 2015, "Chennai",28900.0));
        employeeList.add(new Employee(277, "Anuj Chettiar", 31, "Male", "Product Development", 2012, "Bangalore",35700.0));

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

        /* Question: 11. Group the Employees by city */
        Map<String, List<Employee>> employeeListBasedOnCity = employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getCity));

        for(Map.Entry<String, List<Employee>> map : employeeListBasedOnCity.entrySet()){
            System.out.println("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-");
            System.out.println("Employees present in city: " + map.getKey());

            for(Employee employee : map.getValue()){
                System.out.println(employee);
            }
            System.out.println("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-");
        }
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------");

        /* Question: 12. Group the Employees Name by age */
        employeeList.stream()
                .collect(Collectors.groupingBy(
                        Employee::getAge,
                        LinkedHashMap::new,
                        Collectors.mapping(Employee::getName, Collectors.toList()))
                )
                .forEach((age, names) -> {
                    System.out.println("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-");
                    System.out.println("Employees age: " + age);
                    names.forEach(System.out::println);
                    System.out.println("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-");
                });
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------");

        /* Question: 13. Group the Employees by gender */
        employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getGender))
                .forEach((gender, employee) -> {
                    System.out.println("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-");
                    System.out.println("Employees gender: " + gender);
                    employee.forEach(System.out::println);
                    System.out.println("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-");
                });
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------");

        /* Question: 14. Print employee details whose age is greater than 28 */
        System.out.println("Employee details whose age is greater than 28: ");
        employeeList.stream()
                        .filter(employee -> employee.getAge() > 28)
                                .forEach(System.out::println);
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------");

        /* Question: 15. Find youngest female employee */
        employeeList.stream()
                    .filter(employee -> employee.getGender().equals("Female"))
                    .min(Comparator.comparing(Employee::getAge))
                    .ifPresent(emp -> System.out.println("youngest female employee is: " + emp));
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------");

        /* Question: 16. Find employees whose age is greater than 30 and less than 30 */
        System.out.println("Employees whose age is greater than 30 and less than 30: ");
        Map<Boolean, List<Employee>> partitionEmployeesByAge = employeeList.stream()
                .collect(Collectors.partitioningBy(e -> e.getAge() > 30));

        Set<Map.Entry<Boolean, List<Employee>>> empSet = partitionEmployeesByAge.entrySet();

        for (Map.Entry<Boolean, List<Employee>> entry : empSet) {
            if (Boolean.TRUE.equals(entry.getKey())) {
                System.out.println("Employees greater than 30 years ::" + entry.getValue());
            } else {
                System.out.println("Employees less than 30 years ::" + entry.getValue());
            }
        }
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------");

        /* Question: 17. Find the department name which has the highest number of employees */
        Optional<Map.Entry<String, Long>> maxCount = employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()))
                .entrySet().stream()
                .max(Map.Entry.comparingByValue());

        maxCount.ifPresent(map -> System.out.println("Department " + map.getKey() + " has the highest number of employees: " + map.getValue()));
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------");

        /* Question: 18. Find if there any employees from HR Department */
        employeeList.stream()
                .filter(employee -> employee.getDepartment().equals("HR"))
                .findAny()
                .ifPresent(employee -> System.out.println("Found employees from HR department " + employee));
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------");

        /* Question: 19. Find the department names that these employees work for, where the number of employees in the department is over 2 */
        List<Map.Entry<String, Long>> employeesWithOver2InDept = employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()))
                .entrySet().stream()
                .filter(dept -> dept.getValue() > 2)
                .toList();

        System.out.println("Department names where the number of employees in the department is over 2: ");
        employeesWithOver2InDept.forEach(deptNames -> System.out.println(deptNames.getKey()));
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------");

        /* Question: 20. Find the employees that these employees work for, where the number of employees in the department is over 2 */
        System.out.println("Employees where the number of employees in the department is over 2: ");
        employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment))
        .entrySet().stream()
                        .filter(entry -> entry.getValue().size() > 2)
                                .forEach(employeesOver2InDept -> {
                                    System.out.println("Department: " + employeesOver2InDept.getKey());
                                    System.out.println("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-");
                                    (employeesOver2InDept.getValue()).forEach(employee -> System.out.println("Employees: " + employee)); //System.out.println("Employees: " + employeesOver2InDept.getValue());
                                });
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------");

        /* Question: */
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------");

        /* Question: */
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------");

        /* Question: */
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------");

        /* Question: */
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------");

        /* Question: */
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------");

        /* Question: */
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------");

        /* Question: */
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------");

        /* Question: */
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------");

        /* Question: */
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------");

        /* Question: */
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------");

        /* Question: */
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------");

        /* Question: */
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------");

        /* Question: */
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------");

        /* Question: */
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------");

        /* Question: */
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------");

        /* Question: */
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------");

        /* Question: */
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------");

        /* Question: */
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------");






















    }
}
