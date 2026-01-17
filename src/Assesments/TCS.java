package Assesments;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class TCS {

    public static void main(String[] args) {
        String str = "SarfarazAhamad";
        Map.Entry<String, Long> max = Arrays.stream(str.split(""))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .sorted(Collections.reverseOrder(Comparator.comparing(Map.Entry::getValue))).findFirst().get();

        System.out.println(max);
    }
}
