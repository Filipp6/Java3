import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) throws Exception {
        Class<Cat> catClass = Cat.class;
//        Cat cat = new Cat("Furry");
//        Class catClass1 = (Class<Cat>) cat.getClass();
//        Class<Cat> catClass2 = (Class<Cat>) Class.forName("Cat");

                Cat cat = new Cat("Furry", 2, "black");

//        Constructor<Cat> constructor = catClass.getConstructor(String.class, int.class, String.class);
//        Cat cat1 = constructor.newInstance("Rurry", 1, "red");
//        cat1.info();

//        Method[] methods = catClass.getMethods();
//        for (Method method : methods) {
//            System.out.println(method);
//        }

//        Method[] declaredMethods = catClass.getDeclaredMethods();
//        for (Method declaredMethod : declaredMethods) {
//            System.out.println(declaredMethod);
//        }

//        Method info = catClass.getMethod("info");
//        info.invoke(cat);

//        Method jump = catClass.getDeclaredMethod("jump");
//        jump.invoke(cat);

        Method meow = catClass.getDeclaredMethod("meow");
//        meow.setAccessible(true);
//        meow.invoke(cat);

//        int modifiers = meow.getModifiers();
//        System.out.println("isPublic "   + Modifier.isPublic(modifiers));
//        System.out.println("isFinal "   + Modifier.isFinal(modifiers));
//        System.out.println("isPrivate "   + Modifier.isPrivate(modifiers));

//        Field[] declaredFields = catClass.getDeclaredFields();
//        for (Field declaredField : declaredFields) {
//            System.out.println(declaredField);
//        }
//
//        System.setSecurityManager(new SecurityManager());
//
//        Field name = catClass.getDeclaredField("name");
//        name.setAccessible(true);
//        System.out.println(name.get(cat));
//
//        name.set(cat, "Murzik");
//
//        cat.info();


        Class<Tester> testerClass = Tester.class;
//
//        Method[] declaredMethods = testerClass.getDeclaredMethods();
//        for (Method declaredMethod : declaredMethods) {
//            if(declaredMethod.isAnnotationPresent(Ann.class)){
//                declaredMethod.invoke(null);
//            }
//        }

        Method[] declaredMethods = testerClass.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            if(declaredMethod.isAnnotationPresent(AnnWithParams.class)){
                System.out.println(declaredMethod.getAnnotation(AnnWithParams.class).description());
                int i = declaredMethod.getAnnotation(AnnWithParams.class).executionTimes();
                for (int j = 0; j < i; j++) {
                    declaredMethod.invoke(null);
                }
            }
        }



    }
}
