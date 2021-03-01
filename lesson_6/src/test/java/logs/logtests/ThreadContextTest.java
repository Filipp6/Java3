package logs.logtests;

import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.ThreadContext;
import org.junit.Test;


@Log4j2
public class ThreadContextTest {

    private final ThreadContextService service = new ThreadContextService();
    @Test
    public void testThreadContext(){

        ThreadContext.put("ip", "192.168.0.1");
        ThreadContext.put("user", "Smith");

        log.info("Hello from logs.logtests.ThreadContextTest");
        service.logWithThreadContext();

        ThreadContext.clearAll();

        log.info("Hello from logs.logtests.ThreadContextTest again");
    }
}
