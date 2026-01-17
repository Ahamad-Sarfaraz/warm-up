package Basics.streams;

import java.util.Arrays;
import java.util.Collections;

public class ArrayOperations {
    public static void main(String[] args) {
        int[] arr = {1,2,3,0,4,0,5,0,6};
        // Max
        System.out.println(Arrays.stream(arr).max().getAsInt());

        // Min
        System.out.println(Arrays.stream(arr).min().getAsInt());

        // Average
        System.out.println(Arrays.stream(arr).average().getAsDouble());

        // Sum
        System.out.println(Arrays.stream(arr).sum());

        // Sort
        int[] sorted = Arrays.stream(arr).sorted().toArray();
        System.out.println(Arrays.toString(sorted));

        // Sort in reverse Order
        Object[] array = Arrays.stream(arr).boxed().sorted(Collections.reverseOrder()).toArray();
        System.out.println(Arrays.toString(array));

        // First highest number
        Integer i = Arrays.stream(arr).boxed().sorted(Collections.reverseOrder()).findFirst().get();
        System.out.println(i);

        // Second highest number
        Integer i1 = Arrays.stream(arr).boxed().sorted(Collections.reverseOrder()).skip(1).findFirst().get();
        System.out.println(i1);

        // First Lowest number
        int asInt = Arrays.stream(arr).sorted().findFirst().getAsInt();
        System.out.println(asInt);

        // Second Lowest number
        int asInt1 = Arrays.stream(arr).sorted().skip(1).findFirst().getAsInt();
        System.out.println(asInt1);

        // Sum using reduce
        int sum_ = Arrays.stream(arr).reduce(Integer::sum).getAsInt();
        System.out.println(sum_);

    }
}
