package firststage.class01;

public class Code01_SumOfFactorial {

    public static int f1(int num) {
        int sum = 0;
        int ans = 1;
        for (int i = 1; i <= num; i++) {
            ans *= i;
            sum += ans;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(f1(4));
    }
}
