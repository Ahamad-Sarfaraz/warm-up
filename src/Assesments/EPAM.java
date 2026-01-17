package Assesments;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class EPAM {
    public static void main(String[] args) {



        List<String> list = Arrays.asList("Apple","Boy","Cat","Ball","Ball","Ball");
        groupByFirstCharacter(list);

    }

    private static void groupByFirstCharacter(List<String> list) {

        // output should be like - {A=[Apple],B=[Boy,Ball],C=[Cat]}

        // Group by perticular char and take into list

         Map<Character, List<String>> collect = list.stream().collect(Collectors.groupingBy(s -> s.charAt(0), Collectors.toList()));


        Map<String, List<String>> collect1 = list.stream().collect(Collectors.groupingBy(item -> "b", Collectors.toList()));


        Map<String, List<String>> collect2 = list.stream().collect(Collectors.groupingBy(word -> word, Collectors.toList()));

        System.out.println(collect2);

    }
}
