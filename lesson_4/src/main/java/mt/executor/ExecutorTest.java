package mt.executor;

import java.util.concurrent.*;

public class ExecutorTest {

//    public static void main(String[] args){
//
////                ExecutorService executorService = Executors.newFixedThreadPool(4);
//        ExecutorService executorService = Executors.newCachedThreadPool();
//
//        for (int i = 0; i < 10; i++) {
//            int finalI = i;
//            executorService.execute(() -> {
//
//                System.out.println(finalI + " started");
//                try {
//                    Thread.sleep(2000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                System.out.println(finalI + " finished");
//            } );
//        }
////        executorService.shutdown();
//
//        System.out.println(executorService.toString());
//    }

//    public static void main(String[] args){
//        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(2);
//        scheduledExecutorService.schedule(() -> System.out.println("1"), 5000, TimeUnit.MILLISECONDS);
//
//
////        starts delay as task started
////        scheduledExecutorService.scheduleAtFixedRate();
////        starts delay as task finished
////        scheduledExecutorService.scheduleWithFixedDelay();
//
////        scheduledExecutorService.shutdown();
////
//        scheduledExecutorService.shutdownNow();
//
//    }


//    public static void main(String[] args) throws InterruptedException {
//        Thread thread = new Thread(() -> {
//            while(!Thread.currentThread().isInterrupted()){
//                try {
//                    System.out.println("In try " + Thread.currentThread().isInterrupted());
//                    Thread.sleep(20);
//                } catch (InterruptedException e) {
//                    System.out.println("In catch " + Thread.currentThread().isInterrupted());
//                    e.printStackTrace();
//                    Thread.currentThread().interrupt();
//                }
//            }
//        });
//
//
//        thread.start();
//        Thread.sleep(200);
//        thread.interrupt();
//    }

//    public static void main(String[] args) throws InterruptedException {
//        String s = "sfdg";
//        Thread thread = new Thread(() -> {
//            while(true){
//                System.out.println(s);
//                System.out.println(Thread.currentThread().isInterrupted());
//            }
//        });
//
//        ExecutorService executorService = Executors.newFixedThreadPool(4);
//        executorService.execute(thread);
//        Thread.sleep(1000);
//        executorService.shutdownNow();
//        if (!executorService.awaitTermination(1000, TimeUnit.MICROSECONDS)) {
//            System.out.println("Still waiting after 100ms: calling System.exit(0)...");
//            System.exit(0);
//        }
//    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        Future<String> future = executorService.submit(() -> {
            System.out.println("ABC");
            return "TEST";
        });

//        System.out.println(future.cancel(true));
        System.out.println(future.isCancelled());
        System.out.println(future.isDone());
        future.get();

        executorService.shutdownNow();
    }

}
