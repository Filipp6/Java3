package lesson_1;

public class BoxArr <T extends Number> {

    private T[] nums;


    public BoxArr(T... nums) {
        this.nums = nums;
    }

    public double avg(){
        double res = 0.0;
        for (int i = 0; i < nums.length; i++) {
            res += nums[i].doubleValue();
        }
        return res / nums.length;
    }

    public boolean isSameAvg(BoxArr<?> other){
        return Math.abs(this.avg() - other.avg()) < 0.0001;
    }
}
