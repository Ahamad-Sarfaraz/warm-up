package LLD.DesignPatterns.behavioral;

import java.util.Arrays;

public class StrategyDesignPattern {
    public static void main(String[] args) {
        int[] array = {12, 200, 31, 4, 50};


        SortingContext sortingContext = new SortingContext(new QuickSort());
        sortingContext.sort(array);


        sortingContext.setSortingStrategy(new MergeSort());
        sortingContext.sort(new int[]{0,43534,23,432,2});


//        sortingContext.setSortingStrategy(new BubbleSort());
//        sortingContext.sort(new int[]{-10,-23,432,2});


        sortingContext.setSortingStrategy(new InsertionSort());
        sortingContext.sort(new int[]{-10,-23,432,2});
    }
}


// behavioral design pattern,
// separate the class of strategy/behavioral into different class
// which makes the code more flexible, easy to modify and extend
// use case -> sorting algorithms, payment gateway

// Strategy class
interface SortingStrategy{
    void sort(int[] array);
}

// Concrete Sorting strategies`
class BubbleSort implements SortingStrategy{
    @Override
    public void sort(int[] array) {
        System.out.println("Bubble sort");
        Arrays.sort(array);
        System.out.println(Arrays.toString(array));
    }
}

class QuickSort implements SortingStrategy{
    @Override
    public void sort(int[] array) {
        System.out.println("Quick sort");
        Arrays.sort(array);
        System.out.println(Arrays.toString(array));
    }
}

class MergeSort implements SortingStrategy{

    @Override
    public void sort(int[] array) {
        System.out.println("Merge sort");
        Arrays.sort(array);
        System.out.println(Arrays.toString(array));
    }
}


class InsertionSort implements SortingStrategy{

    @Override
    public void sort(int[] array) {
        System.out.println("Insertion sort");
        Arrays.sort(array);
        System.out.println(Arrays.toString(array));
    }
}


// Sorting Context
class SortingContext{
    private SortingStrategy sortingStrategy;

    SortingContext(SortingStrategy sortingStrategy){
        this.sortingStrategy = sortingStrategy;
    }

    public void setSortingStrategy(SortingStrategy sortingStrategy){
        this.sortingStrategy = sortingStrategy;
    }

    public void sort(int[] array){
        sortingStrategy.sort(array);
    }
}



