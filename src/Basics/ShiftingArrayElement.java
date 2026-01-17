package Basics;

import java.util.Arrays;
import java.util.stream.IntStream;

public class ShiftingArrayElement {
    public static void main(String[] args) {
        int[] arr = {1,2,3,0,4,0,5,0,6};
        System.out.println(arr.length);

        /*Using Loops...*/
        // shiftZeroToRight(arr);
        // shiftZeroToLeft(arr);

        /*Using Array Stream*/
        shiftZeroToRightUsingStream(arr);
        shiftZeroToLeftUsingStream(arr);
    }

    private static void shiftZeroToLeftUsingStream(int[] arr) {
        int [] result = IntStream.concat(Arrays.stream(arr).filter(i->i==0),Arrays.stream(arr).filter(i->i!=0)).toArray();
        System.out.println(Arrays.toString(result));
    }

    private static void shiftZeroToRightUsingStream(int[] arr) {

        int[] array = IntStream.concat(Arrays.stream(arr).filter(i -> i != 0), Arrays.stream(arr).filter(i -> i == 0)).toArray();
        System.out.println(Arrays.toString(array));
    }

    private static void shiftZeroToLeft(int[] arr) {

        // 1,2,3,0,4,0,5,0,6
        int[] shiftedArray = new int[arr.length];
        int index=0;

        for(int arrayElement :arr){
            if(arrayElement==0){
                index++;
            }
        }

        for(int arrayElement_: arr){
            if(arrayElement_!=0){
                shiftedArray[index++]=arrayElement_;
            }
        }
        System.out.println(Arrays.toString(shiftedArray));
    }

    private static void shiftZeroToRight(int[] arr) {

        int[] shiftedArray = new int[arr.length];
        int index=0;

        for(int arrayElement:arr){
            if(arrayElement!=0){
                shiftedArray[index++] = arrayElement;
            }
        }
        System.out.println(Arrays.toString(shiftedArray));
    }
}
