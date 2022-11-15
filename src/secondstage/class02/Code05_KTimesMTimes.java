package secondstage.class02;

public class Code05_KTimesMTimes {

    // 使用数组和位 存储数字
    public static void findKTimes(int[] arr, int k, int m) {
        if(arr == null || arr.length == 0) {
            return;
        }
        int[] numTimes = new int[32];
        for (int num : arr){
            for (int i = 0; i < 32; i++) {
                numTimes[i] += (num >> i) & 1;
            }
        }
        int result = 0;
        for (int i = 0; i < 32; i++) {
            if((numTimes[i] % m) != 0) {
                result |= (1 << i);
            }
        }
        System.out.println("result " + result + " appear " + k + " Times");
    }

    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2,2,3,3,3,4,4,4,5,5,5,6,6,6,7,7};
        findKTimes(nums, 2, 3);
    }
}
