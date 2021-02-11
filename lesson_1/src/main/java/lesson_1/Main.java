package lesson_1;


public class Main {
    public static void main(String[] args) {
        BoxArr<Integer> boxInt = new BoxArr<>(10, 20, 30);
//        System.out.println(boxInt.avg());

        BoxArr<Double> boxDouble = new BoxArr<>(12.4, 23.4, 17.5);
//        System.out.println(boxDouble.avg());

        System.out.println(boxInt.isSameAvg(boxDouble));


    }

    private void twoGens(){
        BoxGen<Integer, String> intBox = new BoxGen<>(20);
        BoxGen<Integer, String> intBox2 = new BoxGen<>(30);
        int res = intBox.getNum() + intBox2.getNum();
        System.out.println(res);

        BoxGen<String, String> strBox = new BoxGen<>("TEST");
    }


    private void beforeGen(){
        Box box1 = new Box(20);
        Box box2 = new Box(30);

        if(box1.getObj() instanceof Integer &&
                box2.getObj() instanceof Integer){
            int sum = (Integer) box1.getObj()
                    + (Integer)  box2.getObj();
            System.out.println(sum);
        }
    }
}
