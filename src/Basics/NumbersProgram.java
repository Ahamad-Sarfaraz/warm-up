package Basics;

public class NumbersProgram {
    public static void main(String[] args) {
        // Task 1 : Print Fibonacci series -> 0 1 1 2 3 5 8 13 21 34 55 89 144 233 377
        /*for(int i=0;i<=14;i++){
            System.out.print(printFibonacciSeries(i) + " ");
        }*/

        // Task 2 : Print Factorials for given number
        /*printFactorials(7);*/

        // Task 3 : Print Prime numbers
        /*for(int i=0;i<50;i++){
            if(printPrimeNumbers(i)){
                System.out.print(i+" ");
            }
        }*/

        // Task 4 : check if a number is prime
        System.out.println(printPrimeNumbers(11));
    }

    private static boolean printPrimeNumbers(int range) {
        if (range <= 1) return false;

        for (int i = 2; i <= Math.sqrt(range); i++) {
            if (range % i == 0) return false;
        }
        return true;

    }

    private static void printFactorials(int number) {

        int factorial = 1;
        while(number > 0){
            factorial = factorial*number;
            number--;
        }
        System.out.println(factorial);
    }

    private static int printFibonacciSeries(int i) {
        if(i<=1){
            return i;
        }
        return printFibonacciSeries(i-1) + printFibonacciSeries(i-2);

    }
}
