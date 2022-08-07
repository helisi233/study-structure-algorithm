package firststage.class03;

public class Code03_BSNearRight {

    public static int findNearRight(int[] array, int num) {
        if(array == null || array.length < 2) {
            return -1;
        }
        int t = -1;
        int l = 0;
        int r = array.length-1;
        while(l <= r) {
            int mid = l + (r-l) / 2;
            if(array[mid] <= num) {
                t = mid;
                l = mid+1;
            }else {
                r = mid-1;
            }
        }
        return t;
    }

    public static void main(String[] args) {
        int[] array = {1,1,1,2,2,2,3,4,4,5,5,5};
        System.out.println(findNearRight(array, 2));
    }
}
