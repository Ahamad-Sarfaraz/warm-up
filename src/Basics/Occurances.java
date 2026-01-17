package Basics;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Occurances {
    public static void main(String[] args) {
        String str = "aabcddffff";
        //occurenceUsingMap(str);
        occurenceUsingStream(str);

    }

    private static void occurenceUsingStream(String str) {

        Map<String, Long> collect = Arrays.stream(str.split("")).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(collect);
    }

    private static void occurenceUsingMap(String word) {
        Map<Character,Integer> map = new HashMap<>();
        char[] charArray = word.toCharArray();

        for(char charElement:charArray){
            map.put(charElement,map.getOrDefault(charElement,0)+1);

        }
        System.out.println(map);
    }
}
