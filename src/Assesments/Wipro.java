package Assesments;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Wipro {
    public static void main(String[] args) {
        String str="Transacation".toLowerCase();

        String result="";

        List<String> duplicateKey = Arrays.stream(str.split(""))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream().filter(map -> map.getValue() > 1)
                .map(map -> map.getKey())
                .toList();
        char [] strCharArr = str.toCharArray();
        for(String key: duplicateKey){
           // strCharArr[str.indexOf(key)]= (char) "2"+key;

        }
        result = new String(strCharArr);




        System.out.println(result);

    }
}
