package Assesments;

import java.util.Arrays;
import java.util.Objects;

public class Siemens {
    public static void main(String[] args) {
        // Question -1
        // find max consecutive number of ones
        // example1  - {1,1,0,1,1,1} output - 3
        // example2  - {1,1,0,1,1,1,0,1,1,1,1} output - 4

        // int[] array = {1,1,0,1,1,1,0,1,1,1,5,1,1,1,1,1};
        // System.out.println(findMaxConsecutiveOfOnes(array));


        // Question -2
        // find maximum pair of sum in a given array
        // example - array - [9,4,20,3,10,5], sum = 33
        // output sub array - 9,4,20 - 20,3,10 - total 2
        // int[] array = {9,4,20,3,10,5,31,2,33,0};
        // System.out.println(findMaxPairOfSum(array, 33));

        // Question - 3
        int[] array1 = {1, 2, 3, 4, 5};
        int[] array2 = {6, 7, 8};
        // output array = [1,6,2,7,3,8,4,5]

        int[] finalArray = mergeArraysAlternately(array1, array2);
        System.out.println(Arrays.toString(finalArray));


    }

    private static int[] mergeArraysAlternately(int[] array1, int[] array2) {
        int[] finalArray = new int[array1.length + array2.length];
        int maxLength = Math.max(array1.length, array2.length);
        int index = 0;

        for (int i = 0; i < maxLength; i++) {
            if (i < array1.length) {
                finalArray[index++] = array1[i];
            }

            if (i < array2.length) {
                finalArray[index++] = array2[i];
            }
        }
        return finalArray;
    }

    private static int findMaxPairOfSum(int[] array, int sumNumber) {
        // int[] array = {9,4,20,3,10,5};
        int totalPairOfSum = 0;
        for (int i = 0; i < array.length; i++) {
            int sum = array[i];
            for (int j = i + 1; j < array.length; j++) {
                sum += array[j];
                if (sum == sumNumber) {
                    totalPairOfSum++;
                }
            }

        }
        return totalPairOfSum;
    }


    private static int findMaxConsecutiveOfOnes(int[] array) {

        // example1  - {1,1,0,1,1,1} output - 3
        // example2  - {1,1,0,1,1,1,0,1,1,1,1} output - 4

        int maxCount = 0;
        int minCount = 0;
        int lastOne = 0;

        for (int i : array) {
            if (lastOne != 1 && i == 1) {
                lastOne = 1;
                maxCount++;
                continue;

            }
            if (lastOne == 1 && i == 1) {
                maxCount++;
                continue;
            }

            if (lastOne == 1 && i != 1) {
                minCount = maxCount;
                maxCount = 0;
                lastOne = 0;
            }
        }
        if (maxCount > minCount) return maxCount;
        return minCount;
    }


}
