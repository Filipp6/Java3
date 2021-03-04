import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class EverythingIsTrue {

    public static void main(String args[]) throws Exception {
        System.out.format("Everything is %s", false);
    }

    static {
        try {
            setFinalStatic(Boolean.class.getField("FALSE"), true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void setFinalStatic(Field field, Object newValue) throws Exception {
        field.setAccessible(true);

        Field modifiersField = Field.class.getDeclaredField("modifiers");
        modifiersField.setAccessible(true);
        modifiersField.setInt(field, field.getModifiers() & ~Modifier.FINAL);

        field.set(null, newValue);
    }
}
