package lesson_1;

public class BoxGen <T, S> {

    T num;
    S str;

    public BoxGen(T obj) {
        this.num = obj;
    }

    public T getNum() {
        return num;
    }

    public void setNum(T num) {
        this.num = num;
    }

    public S getStr() {
        return str;
    }

    public void setStr(S str) {
        this.str = str;
    }
}
