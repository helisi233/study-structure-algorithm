package firststage.class01;

/**
 *  有一个数组 [3,4,2,1,6,7,8]
 *  需求: 查找数组L到R位置的和 1~5 2~6位置的和
 * */
public class Code05_PreSum {

    /**
     *  使用前缀和数组
     *  将数组中元素加在一起 新数组的每个位置都是从0位置开始到当前位置的和
     *  [3,7,9,10,16,23,31]
     *  返回[l,r]的和
     * */
    public static int preSum(int[] array, int l, int r) {
        int length = array.length;
        int[] result = new int[length];
        int sum = 0;
        for (int i = 0; i < length; i++) {
            sum += array[i];
            result[i] = sum;
        }
        if(l == 0) {
            return result[r];
        }
        return result[r] - result[l-1];
    }

    public static void main(String[] args) {
        int[] array = {3,4,2,1,6,7,8};
        int sum = preSum(array, 5, 6);
        System.out.println(sum);
    }
}
