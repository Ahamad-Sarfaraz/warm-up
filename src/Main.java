import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        System.out.println(Runtime.version());
        print(null);
        //System.out.println(STR."JDK Version:  \{System.getProperty("java.version")}");

    }

    private static void print(String str){
        System.out.println("String");
    }

    private static void print(Object str){
        System.out.println("object");
    }

}