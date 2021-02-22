import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MultithreadingTest {

    @Test
    public void executorService(){
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        executorService.execute(() -> System.out.println("dfg"));
        executorService.shutdown();
    }
}
