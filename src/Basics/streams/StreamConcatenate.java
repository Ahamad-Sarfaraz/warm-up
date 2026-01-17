package Basics.streams;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamConcatenate {
    public static void main(String[] args) {
        // arrayConcatenation();
        listConcatenation();

    }

    private static void listConcatenation() {
        List<Integer> list1 = List.of(4, 1, 40, 14, 15, 6, 7);
        List<Integer> list2 = List.of(104, 21, 0, 2, 4, 3, 61, 27);

        // concat
        System.out.println(Stream.concat(list1.stream(), list2.stream()).toList());

        // Concat and sort
        System.out.println(Stream.concat(list1.stream(), list2.stream()).sorted().toList());

        // Concat and sort in reverse order
        System.out.println(Stream.concat(list1.stream(), list2.stream()).sorted(Collections.reverseOrder()).toList());

        // concat and first highest
        System.out.println(
                Stream.concat(list1.stream(), list2.stream()).sorted(Collections.reverseOrder()).findFirst().get()
        );

        // concat and first lowest
        System.out.println(
                Stream.concat(list1.stream(), list2.stream()).sorted().findFirst().get()
        );

        // concat and occurances of each
        System.out.println(
                Stream.concat(list1.stream(), list2.stream())
                        .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
        );

        // concat and find duplicate
        System.out.println(Stream.concat(list1.stream(), list2.stream())
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .filter(map -> map.getValue() > 1)
                .map(i -> i.getKey())
                .toList());

        // concat and find distinct
        System.out.println(Stream.concat(list1.stream(), list2.stream())
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .filter(map -> map.getValue() == 1)
                .map(i -> i.getKey())
                .toList());
    }

    private static void arrayConcatenation() {

        int[] arr1 = {4, 1, 40, 14, 15, 6, 7};
        int[] arr2 = {104, 21, 0, 2, 4, 3, 61, 27};

        // Concat
        System.out.println(Arrays.toString(IntStream.concat(Arrays.stream(arr1), Arrays.stream(arr2)).toArray()));

        // Concat and sort
        System.out.println(Arrays.toString(IntStream.concat(Arrays.stream(arr1), Arrays.stream(arr2)).sorted().toArray()));

        // Concat and sort in reverse order
        System.out.println(Arrays.toString(
                IntStream.concat(Arrays.stream(arr1), Arrays.stream(arr2)).boxed().sorted(Collections.reverseOrder())
                        .toArray()
        ));

        // concat and find fist highest
        Integer i = IntStream.concat(Arrays.stream(arr1), Arrays.stream(arr2))
                .boxed()
                .sorted(Collections.reverseOrder())
                .findFirst().get();
        System.out.println(i);

        // concat and find lowest
        Integer j = IntStream.concat(Arrays.stream(arr1), Arrays.stream(arr2))
                .boxed()
                .sorted()
                .findFirst().get();
        System.out.println(j);

        // concat and find the occurances
        Map<Integer, Long> collect = IntStream.concat(Arrays.stream(arr1), Arrays.stream(arr2))
                .boxed()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        System.out.println(collect);

        // concat and find duplicate
        Object[] array = IntStream.concat(Arrays.stream(arr1), Arrays.stream(arr2))
                .boxed()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream().filter(map -> map.getValue() > 1)
                .map(map -> map.getKey())
                .toArray();

        System.out.println(Arrays.toString(array));

        // concat and find duplicate
        Object[] distinctArray = IntStream.concat(Arrays.stream(arr1), Arrays.stream(arr2))
                .boxed()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream().filter(map -> map.getValue() == 1)
                .map(map -> map.getKey())
                .toArray();
        System.out.println(Arrays.toString(distinctArray));


    }
}
