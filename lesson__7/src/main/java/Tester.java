public class Tester {

    @Ann
    public static void testOne(){
        System.out.println("testOne");
    }
    @AnnWithParams(description = "Second test", executionTimes = 5)
    public static void testTwo(){
        System.out.println("testOne");
    }

    public static void testThree(){
        System.out.println("testOne");
    }
}
