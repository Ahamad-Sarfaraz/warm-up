package MultiThreading;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static java.util.concurrent.CompletableFuture.supplyAsync;

public class CompletableFutureHandsOn {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //runAsync();
        supplyAsync();
        Thread.sleep(200);
    }

    private static void supplyAsync() {

        CompletableFuture.supplyAsync(() -> {
            System.out.println("supplyAsync Thread " + Thread.currentThread().getName());
            boolean flag = false;
            if (flag) throw new RuntimeException("Exception in supplyAsync");
            return 10;
        }).thenApply(result -> {
            System.out.println("thenApply Thread " + Thread.currentThread().getName());
            return result * 10;
        }).thenAccept(System.out::println).exceptionally(thr -> {
            System.out.println(STR."Exception in thenApply Thread \{Thread.currentThread().getName()}. Exception Msg \{thr.getMessage()}");
            try {
                throw thr;
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
        }).thenRun(() -> {
            System.out.println("Done..");
        });
    }

    private static void runAsync() {
        // Without Executors
        /*for(int i=0;i<5;i++){
            int finalI = i;
            CompletableFuture.runAsync((()->{
                // Business Tasks
                System.out.println("Id-" + finalI + " Running in " + Thread.currentThread().getName());
            }));
        }*/


        // With Executors...
        ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        for(int i=0;i<5;i++){
            int finalI = i;
            CompletableFuture.runAsync((()->{
                // Business Tasks
                System.out.println("Id-" + finalI + " Running in " + Thread.currentThread().getName());
            }),executorService);
        }
        executorService.shutdown();
    }

    protected void  accessModifierCheck(){
        System.out.println("Method to check access modifier.....");
    }

}
