public class Main {

//    public static void main(String[] args) throws InterruptedException, ExecutionException {
//        ExecutorService executorService = Executors.newFixedThreadPool(4);
//
//        List<Callable<String>> tasks = Arrays.asList(() -> {
//            Thread.sleep(500);
//            System.out.println("1 task");
//            return "1 one done!";
//        }, () -> {
//            Thread.sleep(2000);
//            System.out.println("2 task");
//            return "2 one done!";
//        }, () -> {
//            Thread.sleep(3000);
//            System.out.println("3 task");
//            return "3 one done!";
//        });
//
//        List<Future<String>> futures = executorService.invokeAll(tasks);
//
//        for (Future<String> future : futures){
//            System.out.println(future.get());
//        }
//
//        executorService.shutdown();
//    }

//    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        FutureTask<String> futureTask = new FutureTask<>(() -> "Executed!");
//
//        new Thread(futureTask).start();
//
//        System.out.println(futureTask.get());
//    }

//    public static void main(String[] args) {
//        Vector<String> vector = new Vector<>();
//
//        List<String> list = new CopyOnWriteArrayList<>();
//
//        Set<String> set = new CopyOnWriteArraySet<>();
//
//        Map<String, String> map = new ConcurrentHashMap<>();
//    }

//    public static void main(String[] args) {
//        ArrayBlockingQueue <String> queue = new ArrayBlockingQueue<>(4);
//
//        Thread producer = new Thread(() -> {
//            while (true){
//                try {
//                    Thread.sleep(1000);
//                    System.out.println("Produced!");
//                    queue.put("Product"  + System.currentTimeMillis());
//                    System.out.println("Added to queue!");
//                    System.out.println(queue);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        });
//
//        Thread consumer = new Thread(() -> {
//            while (true){
//                try {
//                    Thread.sleep(2000);
//                    System.out.println("I need a product!");
//                    String take = queue.take();
//                    System.out.println("I have got THIS: " + take);
//                    System.out.println(queue);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        });
//
//        producer.start();
//        consumer.start();
//    }

//    public static void main(String[] args) {
//        ExecutorService executorService = Executors.newFixedThreadPool(10);
//        Semaphore semaphore = new Semaphore(4);
//
//        for (int i = 0; i < 10; i++) {
//            final int w = i;
//            executorService.execute(() -> {
//                try {
//                    semaphore.acquire();
//                    System.out.println("Started with " + w);
//                    Thread.sleep(2000);
//                    System.out.println("Finished with " + w);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                } finally {
//                    semaphore.release();
//                }
//            });
//        }
//        executorService.shutdown();
//    }

//    public static void main(String[] args) throws InterruptedException {
//        CountDownLatch countDownLatch = new CountDownLatch(5);
//
//        for (int i = 0; i < 5; i++) {
//            final int w = i;
//            new Thread(() -> {
//                try {
//                    System.out.println("Started with " + w);
//                    Thread.sleep(2000);
//                    System.out.println("Finished with " + w);
//                    countDownLatch.countDown();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                } finally {
//                }
//            }).start();
//        }
//
//        countDownLatch.await();
//
//        System.out.println("DONE!");
//    }

//    public static void main(String[] args) {
//        CyclicBarrier cyclicBarrier = new CyclicBarrier(3);
//
//        for (int i = 0; i < 3; i++) {
//            final int w = i;
//            new Thread(() -> {
//                try {
//                    System.out.println("Started with " + w + " " + System.currentTimeMillis());
//                    Thread.sleep(2000);
//                    System.out.println("Finished with " + w + " " + System.currentTimeMillis());
//                    cyclicBarrier.await();
//                    System.out.println(w + " Done");
//
//
//                    System.out.println("Started with 2" + w + " " + System.currentTimeMillis());
//                    Thread.sleep(2000);
//                    System.out.println("Finished with 2" + w + " " + System.currentTimeMillis());
//                    cyclicBarrier.await();
//                    System.out.println(w + "  2 Done");
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }).start();
//        }
//    }

//    private static int i = 0;
//    private static void inc() {i++;};
//    private static void dec() {i--;};
//
//    public static void main(String[] args) throws InterruptedException {
//        Lock lock = new ReentrantLock();
//
//        CountDownLatch countDownLatch = new CountDownLatch(200);
//
//        for (int j = 0; j < 100; j++) {
//            new Thread(() -> {
//                lock.lock();
//                inc();
//                lock.unlock();
//                countDownLatch.countDown();
//            }).start();
//
//            new Thread(() -> {
//                lock.lock();
//                dec();
//                lock.unlock();
//                countDownLatch.countDown();
//            }).start();
//        }
//
//        countDownLatch.await();
//
//        System.out.println(i);
//    }

//
//    static final Person PERSON = new Person("Name", "Surname");
//
//    public static void main(String[] args) {
//        ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
//
//        new Thread(() -> {
//            while (true) {
//                try {
//                    Thread.sleep(500);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                readWriteLock.readLock().lock();
//                System.out.println(PERSON + " " + System.currentTimeMillis());
//                readWriteLock.readLock().unlock();
//            }
//        }).start();
//
//
//        new Thread(() -> {
//            try {
//                Thread.sleep(2000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            readWriteLock.writeLock().lock();
//            try {
//                Thread.sleep(2000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            PERSON.setFamilyName("NewName");
//            System.out.println(PERSON + " " + System.currentTimeMillis());
//            readWriteLock.writeLock().unlock();
//        }).start();
//    }

//    public static void main(String[] args) {
//        AtomicBoolean atomicBoolean = new AtomicBoolean();
//        atomicBoolean.compareAndExchange(false, true);
//    }
}
