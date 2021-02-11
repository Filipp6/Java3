package lesson_1;

import java.time.LocalDateTime;
import java.util.Date;

public class RestResponse <T> {
    private String error;
    private LocalDateTime respTime;
    private T data;
}
