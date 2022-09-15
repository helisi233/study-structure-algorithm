package secondstage.class02;

public class Code03_ExtractIntNumRightOne {

    public static void printBinary(int num) {
        for (int i = 31; i >= 0; i--) {
            System.out.print((num & (1 << i)) == 0 ? "0" : "1");
        }
        System.out.println();
    }

    public static void findRightOne(int num) {
        printBinary(num);
        printBinary(num & (~num + 1));
    }

    public static void main(String[] args) {
        findRightOne(270);
    }
}
