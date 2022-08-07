package firststage.class03;

public class Code02_BSNearLeft {

    public static int findNearLeft(int[] array, int num) {
        if(array == null || array.length < 2) {
            return -1;
        }
        int l = 0;
        int r = array.length-1;
        int t = -1;
        while(l <= r) {
            int mid = l + (r-l) / 2;
            if(array[mid] >= num) {
                t = mid;
                r = mid - 1;
            }else {
                l = mid + 1;
            }
        }
        return t;
    }

    public static void main(String[] args) {
        int[] array = {1,1,1,2,2,2,3,4,4,5,5,5};
        System.out.println(findNearLeft(array, 2));
    }
}
