import java.util.List;
import java.util.stream.Stream;

public class ConcatenateStreams {

    public static void main(String[] args) {

        /* Question: Java 8 Program to Concatenate Two Streams */
        Stream<String> stream1 = Stream.of("Java", "Python", "C++");
        Stream<String> stream2 = Stream.of("JavaScript", "TypeScript", "Kotlin");

        Stream.concat(stream1, stream2).toList().forEach(System.out::println);

        /* Question: Java 8 Program to Concatenate Two List into Stream */
        List<String> list1 = List.of("Java", "Python", "C++");
        List<String> list2 = List.of("JavaScript", "TypeScript", "Kotlin");

        Stream.concat(list1.stream(), list2.stream()).toList().forEach(System.out::println);

        /* Question: Java 8 Program to Concatenate Two String into Stream */
        String str1 = "Hello world ";
        String str2 = "this is my first program";

        String concatenatedStream = Stream.concat(
                str1.chars().mapToObj(c1 -> (char) c1).toList().stream(),
                str2.chars().mapToObj(c2 -> (char) c2).toList().stream()
        ).map(String::valueOf)
                .reduce("", (s1, s2) -> s1 + s2);

        System.out.println(concatenatedStream);

    }
}
