package mt.p8_wait_and_notify;

public class OrderedPrinting {

    static final Object mon = new Object();
    static volatile int currentNum = 1;
    static final int num = 10;

    public static void main(String[] args) {
        new Thread(() -> {
            try{
                for (int i = 0; i < num; i++) {
                    synchronized (mon){
                        while(currentNum != 1){
                            mon.wait();
                        }
                        System.out.println("one ");
                        currentNum = 2;
                        mon.notifyAll();
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try{
                for (int i = 0; i < num; i++) {
                    synchronized (mon){
                        while(currentNum != 2){
                            mon.wait();
                        }
                        System.out.println("two ");
                        currentNum = 3;
                        mon.notifyAll();
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try{
                for (int i = 0; i < num; i++) {
                    synchronized (mon){
                        while(currentNum != 3){
                            mon.wait();
                        }
                        System.out.println("three ");
                        currentNum = 1;
                        mon.notifyAll();
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
