package firststage.class03;

public class Code01_BSExist {

    /**
     *  要求传入的array必须有序
     *  使用二分法 在有序数组中查找num
     * */
    public static boolean find(int[] array, int num) {
        if(array == null || array.length < 2) {
            return false;
        }
        int l = 0;
        int r = array.length-1;
        while(l <= r) {
            int mid = l + (r-l)/2;
            if(array[mid] == num) {
                return true;
            }else if(array[mid] < num) {
                l = mid+1;
            }else {
                r = mid-1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] array = new int[15];
        for (int i = 0; i < 15; i++) {
            array[i] = i;
        }
        System.out.println(find(array, 20));
    }
}
