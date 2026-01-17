package Basics.streams;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamBasic {
    public static void main(String[] args) {

        List<Integer> list = List.of(3, 4, 5, 2, 32, 4, 2, 43, 5, 6, 76, 5, 45, 65423);
        int[] arr = {3, 4, 5, 2, 32, 4, 2, 43, 5, 6, 76, 5, 45, 65423};

        // findDuplicateInArray(arr);
        // findDistinctInArray(arr);

        // findDuplicateInList(list);
        // findDistinctInList(list);

        shortMapBasedOnValue();


    }

    private static void shortMapBasedOnValue() {

        Map<Integer, String> integerStringMap = Map.of(31, "Ram", 10, "Shyam", 22, "Advin");

        Map<Integer, String> collect = integerStringMap
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (oldValue,newValue)->oldValue, LinkedHashMap::new));

        System.out.println(collect);


    }

    private static void findDistinctInList(List<Integer> list) {
        List<Integer> list1 = list.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream().filter(i -> i.getValue() == 1)
                .map(i -> i.getKey()).toList();
        System.out.println(list1);
    }

    private static void findDuplicateInList(List<Integer> list) {
        List<Integer> list1 = list.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream().filter(i -> i.getValue() > 1)
                .map(i -> i.getKey()).toList();
        System.out.println(list1);
    }

    private static void findDistinctInArray(int[] arr) {
        Object[] array = Arrays.stream(arr)
                .boxed()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream().filter(i -> i.getValue() == 1)
                .map(i -> i.getKey())
                .toArray();

        System.out.println(Arrays.toString(array));
    }

    private static void findDuplicateInArray(int[] arr) {

        Object[] array = Arrays.stream(arr)
                .boxed()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream().filter(i -> i.getValue() > 1)
                .map(i -> i.getKey())
                .toArray();

        System.out.println(Arrays.toString(array));
    }
}
