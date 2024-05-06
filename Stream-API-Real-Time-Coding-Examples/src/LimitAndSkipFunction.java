import java.util.List;

/**
    Limit: The limit(n) method is an intermediate operation that returns a stream
    not longer than the requested size. As before, the n parameter can't be negative.

    Skip: The skip(n) method is another intermediate operation that discards the
    first n elements of a stream. The n parameter can't be negative,
    and if it's higher than the size of the stream, skip() returns an empty stream.
 */

public class LimitAndSkipFunction {

    public static void main(String[] args) {

        List<Integer> list = List.of(4, 5, 6, 8, 23, 35, 36, 77, 78, 99);

        System.out.println("Limit Function Output:");
        list.stream().limit(7).forEach(System.out::println);

        System.out.println("Skip Function Output:");
        list.stream().skip(7).forEach(System.out::println);
    }
}
