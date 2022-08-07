package firststage.class03;

public class Code04_BSAwesome {

    /**
     *  前提: 相邻数据不等的数组 求局部最小值的位置
     * */
    public static int oneMinIndex(int[] array) {
        if(array == null || array.length == 0) {
            return -1;
        }
        int length = array.length;
        if(length == 1) {
            return 0;
        }
        if(array[0] < array[1]) {
            return 0;
        }
        if(array[length-2] < array[length-2]) {
            return length-2;
        }
        int l = 0;
        int r = length-1;
        int ans = -1;
        while(l <= r) {
            int mid = l + (r-l) / 2;
            if(array[mid] < array[mid-1] && array[mid] < array[mid+1]) {
                ans = mid;
                break;
            }
            if(array[mid] > array[mid-1]) {
                r = mid-1;
                continue;
            }
            if(array[mid] > array[mid+1]){
                l = mid+1;
                continue;
            }
        }
        return ans;
    }

    public static void main(String[] args) {

    }
}
