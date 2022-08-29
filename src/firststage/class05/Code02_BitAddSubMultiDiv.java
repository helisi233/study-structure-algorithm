package firststage.class05;

public class Code02_BitAddSubMultiDiv {

    public static int add(int x, int y) {
        int sum = x;
        while(y != 0) {
            sum = x ^ y;
            y = (x & y) << 1;
            x = sum;
        }
        return sum;
    }

    public static int negNum(int num) {
        return add(~num, 1);
    }

    public static int sub(int x, int y) {
        return add(x, negNum(y));
    }

}
