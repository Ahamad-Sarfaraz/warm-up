package Basics.streams;

import java.util.Collections;
import java.util.List;

public class ListOperations {
    public static void main(String[] args) {

        List<Integer> list = List.of(1, 3, 4, 5, 67, 7, 322432, 64);

        // Min
        System.out.println(list.stream().mapToInt(Integer::intValue).min().getAsInt());

        // Max
        System.out.println(list.stream().mapToInt(Integer::intValue).max().getAsInt());

        // Average
        System.out.println(list.stream().mapToInt(Integer::intValue).average().getAsDouble());

        // Sum
        System.out.println(list.stream().mapToInt(Integer::intValue).sum());

        // Sort
        System.out.println(list.stream().sorted().toList());;

        // Sort in reverse Order
        System.out.println(list.stream().sorted(Collections.reverseOrder()).toList());

        // First Highest number
        System.out.println(list.stream().sorted(Collections.reverseOrder()).findFirst().get());

        // Second Highest number
        System.out.println(list.stream().sorted(Collections.reverseOrder()).skip(1).findFirst().get());

        // First Lowest
        System.out.println(list.stream().sorted().findFirst().get());

        // Second lowest
        System.out.println(list.stream().sorted().skip(1).findFirst().get());

        // Sum
        System.out.println(list.stream().mapToInt(Integer::intValue).sum());
        
    }
}
