package firststage.class01;

/**
 *  打印一个整形的二进制
 * */
public class Code06_PrintB {

    /**
     *  int占用4字节 32个位
     *  1 << [31,0]
     *  1&1=1 1&0=0 0&1=0 0&0=0
     * */
    public static void print(int num) {
        for (int i = 31; i >= 0; i--) {
            System.out.print((num & (1 << i)) == 0 ? "0" : "1");
        }
        System.out.println();
    }

    public static void main(String[] args) {
//        int num = 90;
//        print(num);

        /**
         *  无符号 0 ~ 2^32-1
         *  有符号 -2^31 ~ 2^31-1
         *  有符号的第一位是符号位 0-非负数 1-负数
         *  正数 -> 取反加一 -> 对应的负数
         *  -1 => 11111111111111111111111111111111
         *  取反 => 000000000000000000000000000000000000
         *  加一 => 000000000000000000000000000000000001
         * */
//        int num2 = -1;
//        print(num2);
        /**
         *  整形最小: -2^31 => 10000000000000000000000000000000
         * */
//        int a = Integer.MIN_VALUE;
//        print(a);
//        print(-1);

//        int b = 5;
//        print((~b+1));
//        print(-5);
        /**
         *  正数 最高位0 表示数据31位 因为有0导致最大表示少了一个 => 2^31-1
         *  负数 最高位1 不需要表示0 最小-2^31
         *  计算机底层处理加减乘除都是使用位运算
         * */
//        System.out.println(Integer.MIN_VALUE);
//        System.out.println(Integer.MAX_VALUE);

        /**
         *  右移
         *  >> 有符号右移 那符号位补0
         *  >>> 无符号右移
         * */
        int a = Integer.MIN_VALUE;
        print(a);
        print(a >> 1);
        print(a >>> 1);
    }
}
