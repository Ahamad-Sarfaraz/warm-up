package Assesments;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Barclays {
    public static void main(String[] args) {
        String s = "aabbcABB";

        /*char[] charArray = s.toCharArray();
        Map<Character,Integer> map = new LinkedHashMap<>();

        for(Character character : charArray){
            if(map.containsKey(character)){
                map.put(character,map.get(character)+1);
            }else{
                map.put(character,1);
            }
        }*/


        String[] arr = s.split("");
        Map<String,Integer> map = new HashMap<>();
        for(String element:arr){
            map.put(element,map.getOrDefault(element,0)+1);
        }
        System.out.println(map);

    }
}
