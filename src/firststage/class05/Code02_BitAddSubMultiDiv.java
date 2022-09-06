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

    public static int negNum(int x) {
        return ~x + 1;
    }

    public static int sub(int x, int y) {
        return add(x, negNum(y));
    }

    public static int multi(int x, int y) {
        int res = 0;
        while(y != 0) {
            if((y & 1) != 0) {
                res = add(res, x);
            }
            x <<= 1;
            y >>>= 1;
        }
        return res;
    }

    public static boolean isNeg(int num) {
        return num < 0;
    }

    public static int div(int x, int y) {
        int a = isNeg(x) ? negNum(x) : x;
        int b = isNeg(y) ? negNum(y) : y;
        int res = 0;
        for (int i = 30; i >= 0; i = sub(i, 1)) {
            if((a >> i) >= y) {
                res |= (1 << i);
                y = sub(x, y << i);
            }
        }
        return isNeg(x) != isNeg(y) ? negNum(res) : res;
    }

    public static int divide(int x, int y) {
        if(x == Integer.MIN_VALUE && y == Integer.MIN_VALUE) {
            return 1;
        }else if(y == Integer.MIN_VALUE) {
            return 0;
        }else if(x == Integer.MIN_VALUE) {
            if(y == -1) {
                return Integer.MAX_VALUE;
            }else {
                int ans = div(add(x, 1), y);
                return add(ans, div(sub(x, multi(ans, y)), y));
            }
        }else {
            return div(x, y);
        }
    }

    public static void main(String[] args) {
        System.out.println("add(100, 230) = " + add(100, 230));
        System.out.println("negNum(5) = " + negNum(5));
        System.out.println("sub(100, 230) = " + sub(100, 230));
        System.out.println("multi(100, 230) = " + multi(100, 230));
        System.out.println("div(-15, -5) = " + div(-15, -5));
    }
}
