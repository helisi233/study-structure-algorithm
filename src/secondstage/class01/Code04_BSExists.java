package secondstage.class01;

// 二分法 在有序数组中判断某个数是否存在
public class Code04_BSExists {

    public static boolean exists(int[] arr, int target) {
        if(arr == null || arr.length == 0) {
            return false;
        }
        int L = 0;
        int R = arr.length-1;
        while(L <= R) {
            int mid = L + ((R - L) >> 1);
            if(arr[mid] == target) {
                return true;
            }else if(arr[mid] < target) {
                L = mid + 1;
            }else {
                R = mid - 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] test = {1,2,3,4,5,6,7,8,9,10};
        System.out.println("exists(test, 3) = " + exists(test, 3));
    }
}
