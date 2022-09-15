package secondstage.class02;

public class Code04_EvenTimesOddTimes2 {

    public static void printOddTimesNum2(int[] arr) {
        if(arr == null || arr.length == 0) {
            return;
        }
        int num1 = 0;
        int num2 = 0;
        for (int arrEle : arr) {
            num1 ^= arrEle;
        }
        int one = num1 & (~num1 + 1);
        for (int i = 0; i < arr.length; i++) {
            if((arr[i] & one) == one) {
                num2 ^= arr[i];
            }
        }
        System.out.println("num1:" + (num1 ^ num2) + " num2:" + num2);
    }

    public static void main(String[] args) {
        int[] tests = {1,1,2,2,3,3,4,4,5,5,5,6,6,6,6,7};
        printOddTimesNum2(tests);
    }
}
