package secondstage.class02;

public class Code02_EvenTimesOddTimes {
    public static void printOddTimesNum1(int[] arr) {
        if(arr == null || arr.length == 0) {
            return;
        }
        int num = 0;
        for (int arrEle : arr) {
            num ^= arrEle;
        }
        System.out.println("Odd times num = " + num);
    }

    public static void main(String[] args) {
        int[] tests = {1,1,2,2,3,3,4,4,5,5,5,6,6,6,6};
        printOddTimesNum1(tests);
    }
}
