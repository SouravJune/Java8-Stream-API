package com.souravjune.student;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StudentStreamOperations {

    public static void main(String[] args) {

        List<Student> studentList = Arrays.asList(
                new Student(1, "Rohit", "Mall", 30, "Male", "Mechanical Engineering", 2015, "Mumbai", 122),
                new Student(2, "Pulkit", "Singh", 56, "Male", "Computer Engineering", 2018, "Delhi", 67),
                new Student(3, "Ankit", "Patil", 25, "Female", "Mechanical Engineering", 2019, "Kerala", 164),
                new Student(4, "Satish Ray", "Malaghan", 30, "Male", "Mechanical Engineering", 2014, "Kerala", 26),
                new Student(5, "Roshan", "Mukd", 23, "Male", "Biotech Engineering", 2022, "Mumbai", 12),
                new Student(6, "Chetan", "Star", 24, "Male", "Mechanical Engineering", 2023, "Karnataka", 90),
                new Student(7, "Arun", "Vittal", 26, "Male", "Electronics Engineering", 2014, "Karnataka", 324),
                new Student(8, "Nam", "Dev", 31, "Male", "Computer Engineering", 2014, "Karnataka", 433),
                new Student(9, "Sonu", "Shankar", 27, "Female", "Computer Engineering", 2018, "Karnataka", 7),
                new Student(10, "Shubham", "Pandey", 26, "Male", "Instrumentation Engineering", 2017, "Mumbai", 98));

        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        /* Question: 1. Find list of students whose first name starts with alphabet S */
        Stream<Student> prefixStudentList = studentList.stream()
                .filter(student -> student.getFirstName().startsWith("S"));

        System.out.println("List of students whose first name starts with alphabet S: " + prefixStudentList);
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------");

        /* Question: 2. Group The Student By Department Names */
        Map<String, List<Student>> studentListByDepartment = studentList.stream()
                .collect(Collectors.groupingBy(Student::getDepartmentName));

        System.out.println("Students grouped by the department names: " + studentListByDepartment);
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------");

        /* Question: 3. Find the total count of student using stream */
        long countStudent = studentList.stream().count(); //System.out.println("Total count of students: " + studentList.size());

        System.out.println("Total count of students: " + countStudent);
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------");

        /* Question: 4. Find the max age of student */
        OptionalInt maxAgeStudent = studentList.stream()
                .mapToInt(Student::getAge)
                .max();

        System.out.println("Max age of student: " + maxAgeStudent.getAsInt());
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------");

        /* Question: 5. Find all departments names */
        List<String> listOfDepartment = studentList.stream()
                .map(Student::getDepartmentName)
                .distinct()
                .toList();

        System.out.println("All distinct department names: " + listOfDepartment);
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------");

        /* Question: 6. Find the count of student in each department */
        Map<String, Long> countStudentInEachDept = studentList.stream()
                .collect(Collectors.groupingBy(Student::getDepartmentName, Collectors.counting()));

        System.out.println("Student count in each department: " + countStudentInEachDept);
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------");

        /* Question: 7. Find the list of student names whose age is less than 30 */
        List<String> ageLessThan30List = studentList.stream()
                .filter(student -> student.getAge() < 30)
                .map(student -> student.getFirstName() + " " + student.getLastName())
                .toList();

        System.out.println("List of students whose age is less than 30: " + ageLessThan30List);
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------");

        /* Question: 8. Find the list of students whose rank is in between 50 and 100 */
        List<Student> rankList = studentList.stream()
                .filter(student -> student.getRank() > 50 && student.getRank() < 100)
                .toList();

        System.out.println("List of students whose rank is between 50 and 100: " + rankList);
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------");

        /* Question: 9. Find the average age of male and female students */
        Map<String, Double> mapAvgAge = studentList.stream()
                .collect(Collectors.groupingBy(Student::getGender, Collectors.averagingInt(Student::getAge)));

        System.out.println("Average age of male and female students: " + mapAvgAge);
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------");

        /* Question: 10. Find the department who is having maximum number of students */
        Optional<Map.Entry<String, Long>> maxNumberOfStudents = studentList.stream()
                .collect(Collectors.groupingBy(Student::getDepartmentName, Collectors.counting()))
                .entrySet().stream()
                .max(Map.Entry.comparingByValue());

        maxNumberOfStudents.ifPresent(max -> System.out.println("Department having maximum number of students: " + max));
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------");

        /* Question: 11. Find the Students who stays in Delhi and sort them by their names */
        List<Student> listOfDelhiStudent = studentList.stream()
                .filter(student -> student.getCity().equals("Delhi"))
                .sorted(Comparator.comparing(Student::getFirstName))
                .toList();

        System.out.println("List of students who stays in Delhi and sort them by their names: " + listOfDelhiStudent);
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------");

        /* Question: 12. Find the average rank in all departments */
        Map<String, Double> averageRankInAllDepartments = studentList.stream()
                .collect(Collectors.groupingBy(Student::getDepartmentName, Collectors.averagingInt(Student::getRank)));

        System.out.println("Average rank in all departments: " + averageRankInAllDepartments);
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------");

        /* Question: 13. Find the highest rank in each department */
        Map<String, Optional<Student>> highestRankInEachDept = studentList.stream()
                .collect(Collectors.groupingBy(Student::getDepartmentName, Collectors.minBy(Comparator.comparing(Student::getRank))));

        System.out.println("Highest rank in each department: " + highestRankInEachDept);
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------");

        /* Question: 14. Find the list of students and sort them by their rank */
        List<Student> stuRankSorted = studentList.stream()
                .sorted(Comparator.comparing(Student::getRank))
                .toList();

        System.out.println("List of students sorted by their rank  : " + stuRankSorted);
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------");

        /* Question: 15. Find the student who has second rank */
        Student student = studentList.stream()
                .sorted(Comparator.comparing(Student::getRank))
                .skip(1)
                .findFirst().get();

        System.out.println("Second highest rank student  : "+student);
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------");
    }
}
