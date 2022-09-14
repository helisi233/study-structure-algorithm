package secondstage.class01;

// 使用二分法 在有序数组中找到<=target元素的位置
public class Code05_BSNearLess {

    public static int findNearLess(int[] arr, int target) {
        if(arr == null || arr.length == 0) {
            return -1;
        }
        int L = 0;
        int R = arr.length-1;
        int mid = 0;
        int index = -1;
        while(L <= R) {
            mid = L + ((R - L) >> 1);
            if(arr[mid] <= target) {
                index = mid;
                L = mid + 1;
            }else {
                R = mid - 1;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        int[] tests = {1,2,2,2,3,3,4,4,4,4,5,5,5,6};
        System.out.println("findNearLess(tests, 2) = " + findNearLess(tests, 2));
    }
}
