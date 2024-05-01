import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class RemoveDuplicateElements {

    public static void main(String[] args) {

        /** Question: Java 8 Program to Remove Duplicate Numbers from a List */
        List<Integer> numberList = Arrays.asList(1, 3, 4, 5, 6, 6, 88, 45, 45, 45, 3, 2);

        List<Integer> distinctNumberList = numberList.stream()
                .distinct()
                .toList();

        System.out.println("***** List without duplicate numbers: ***** " + distinctNumberList);

        /** Question: Java 8 Program to Remove Duplicate Strings from a List */
        List<String> fruitList = Arrays.asList("Apple", "Banana", "Guava", "Banana", "Pineapple", "Apple");

        List<String> distinctFruitList = fruitList.stream()
                .distinct()
                .toList();

        System.out.println("***** List without duplicate fruits: ***** " + distinctFruitList);

        /** Question: Java 8 Program to Remove Duplicate Objects from a List */
        List<Person> personList = Arrays.asList(
                new Person("Blaze", "Male"),
                new Person("Sepia", "Female"),
                new Person("Blaze", "Male"),
                new Person("Steve", "Male"),
                new Person("Sepia", "Female")
        );

        List<Person> distinctPersonList = personList.stream()
                .distinct()
                .toList();

        System.out.println("***** List without duplicate person objects: ***** " + distinctPersonList);
    }
}

class Person{

    private String name;
    private String gender;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Person(String name, String gender) {
        this.name = name;
        this.gender = gender;
    }

    /** The distinct() method relies on the equals() and hashCode() methods of the Person class
     *  to determine uniqueness. If these methods are not overridden in the Person class,
     *  distinct() will not work as expected because it will consider two-Person objects distinct
     *  if they are not exactly the same instance, even if their properties are identical.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(name, person.name) && Objects.equals(gender, person.gender);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, gender);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }
}
