package firststage.class02;

public class Code01_RandToRand {

    public static void testRandom() {
//        Math.random() -> double -> [0,1)
        int testTimes = 10000000;
//        int count = 0;
//        for (int i = 0; i < testTimes; i++) {
//            if(Math.random() < 0.3) {
//                count ++;
//            }
//        }
//        System.out.println((double)count / (double)testTimes);
        int[] results = new int[8];
        for (int i = 0; i < testTimes; i++) {
            int randomIndex = (int)(Math.random() * 8);
            results[randomIndex] ++;
        }
        for (int i = 0; i < 8; i++) {
            System.out.println(i + "出现了:" + results[i]);
        }
    }

    /**
     *  返回[0,1)的小数
     *  任意的x x属于[0,1) [0,1)范围上的数出现概率有原来的x调整为x的平方
     * */
    public static double xToXPower2() {
        return Math.max(Math.random(), Math.random());
    }

    public static double xToXPower3() {
        return Math.max(Math.random(), Math.max(Math.random(), Math.random()));
    }

    /**
     *  给出1~5随机函数 生成1~7随机函数
     *  1.f2使用f1生成等概率0 1返回器
     *  2.因为最大值7 二进制可以表示为110 使用f2生成000~111即0~7的随机函数
     *  3.生成0~6等概率随机函数
     *
     *  给出一个随机函数 要求生成另一个随机函数
     *  先生成0 1等概率随机函数
     *  使用0 1等概率随机函数 表示能包含要求随机函数的函数
     *  在通过加减的方式表示
     * */
    public static int f1() {
        return (int)(Math.random() * 5) + 1;
    }
    public static int f2() {
        int ans = 0;
        do{
            ans = f1();
        }while(ans == 3);
        return ans < 3 ? 0 : 1;
    }
    public static int f3() {
        return (f2() << 2) + (f2() << 1) + f2();
    }
    public static int f4() {
        int ans = 0;
        do{
            ans = f3();
        }while(ans == 7);
        return ans + 1;
    }

    public static void main(String[] args) {
        int testTimes = 10000000;
        int[] results = new int[9];
        for (int i = 0; i < testTimes; i++) {
            results[f4()]++;
        }
        for (int i = 0; i < 9; i++) {
            System.out.println(i + "出现了:" + results[i]);
        }
    }
}
