package hw2_12_1;

import java.util.Comparator;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    //task 1
    public static <T> void findMinMax(
            Stream<? super T> stream,
            Comparator<? super T> order,
            BiConsumer<? super T, ? super T> minMaxConsumer) {
        List<T> list = (List<T>) stream.sorted().collect(Collectors.toList());
        if (list.size() == 0) {
            T min = null;
            T max = null;
        }
        minMaxConsumer.accept(list.get(0), list.get(list.size() - 1));
    }
    public static void main(String[] args) {
        Stream<Integer> stream = Stream.of(5, 1, 16, 8, 2);
        Comparator<Integer> order = Comparator.comparing(Integer::intValue);
        BiConsumer<Integer, Integer> minMaxConsumer = (min, max) -> {
            System.out.println(min);
            System.out.println(max);
        };
        findMinMax(stream, order, minMaxConsumer);
        System.out.println("===========");

        //task 2
        Stream<Integer> integerStream = Stream.iterate(0, i -> ++i);
        long count = integerStream
                .limit(20)
                .filter(i -> i % 2 == 0)
                .count();
        System.out.println(count);
    }
}

