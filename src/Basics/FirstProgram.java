package Basics;

public class FirstProgram {
    public static void main(String[] args) {


        String str = "Hello World";
        int number =223;

        // reverse using builder/Buffer
        /*reverseUsingBuilder(str);*/

        // Using Loop
        /*reverseUsingLoop(str);*/

        // Reverse an Integer
        /*reverseAnInteger(number);*/

        // is number start with 1
        /*isNumberStartWithOne(number);*/

        // printNumber Using recursion
        printNumberUsingRecursion(100);

    }

    private static void printNumberUsingRecursion(int range) {
        if(range == 0){
            return;
        }
        System.out.println(range);
        printNumberUsingRecursion(range-1);

    }

    private static void isNumberStartWithOne(int number) {

        while(number > 10){
            number /=10;
        }
        System.out.println(number==2);

    }

    private static void reverseAnInteger(int number) {

        // short cut but interviewer won't be satisfied
        /*String string = new StringBuilder(String.valueOf(number)).reverse().toString();
        Integer i = Integer.valueOf(string);
        System.out.println(i);*/

        // long but interviewer will be satisfied
        // 12345 ->
        int reversedNumber = 0;
        while(number > 0 ){
            int remainder = number %10;
            reversedNumber = reversedNumber * 10 + remainder;
            number /=10;

        }
        System.out.println(reversedNumber);
    }

    private static void reverseUsingLoop(String str) {
        String reversedString ="";
        for(int i=str.length()-1;i>=0;i--){
            reversedString+=str.charAt(i);
        }

        System.out.println(reversedString);
    }

    private static void reverseUsingBuilder(String str) {
        StringBuffer stringBuffer = new StringBuffer(str);
        StringBuilder stringBuilder = new StringBuilder(str);

        StringBuffer reverse = stringBuffer.reverse();
        StringBuilder reverse1 = stringBuilder.reverse();


        String string = reverse.toString();
        String string1 = reverse1.toString();

        System.out.println(string);
        System.out.println(string1);
    }
}
