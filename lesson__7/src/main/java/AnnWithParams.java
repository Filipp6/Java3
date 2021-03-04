import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface AnnWithParams {
    String description() default "";
    int executionTimes() default 0;
}
