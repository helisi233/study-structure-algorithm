package secondstage.class05;

// https://leetcode.com/problems/count-of-range-sum
public class Code01_CountOfRangeSum {

    public static int countRangeSum(int[] num, int lower, int upper) {
        if(num == null || num.length == 0) {
            return 0;
        }
        int[] sum = new int[num.length];
        sum[0] = num[0];
        for (int i = 1; i < num.length; i++) {
            sum[i] = sum[i-1] + num[i];
        }
        return count(sum, 0, num.length-1, lower, upper);
    }

    // 不在使用num[]，后续操作使用sum[]（前缀和数组）
    // 求num[l,r]的范围内，有多少子数组的和在[lower,upper]内
    public static int count(int[] sum, int l, int r, int lower, int upper) {
        // 前缀和数组的4-4，即原数组的0-4的和
        if(l == r) {
            if(sum[l] >= lower && sum[l] <= upper) {
                return 1;
            }else {
                return 0;
            }
        }
        // l != r，范围上有数
        int mid = l + ((r - l) >> 1);
        int leftCount = count(sum, l, mid, lower, upper);
        int rightCount = count(sum, mid+1, r, lower, upper);
        int merge = merge(sum, l, mid, r, lower, upper);
        return leftCount + rightCount + merge;
    }

    public static int merge(int[] sum, int l, int mid, int r, int lower, int upper) {
        int ans = 0;
        // 1.不merge，但是对于每一个右组x，判断左组有哪些数在[x-upper,x-lower]
        // 窗口区间左闭右开[windowL,windowR)
        int windowL = l;
        int windowR = l;
        for (int i = mid+1; i <= r; i++) {
            int max = sum[i] - lower;
            int min = sum[i] - upper;
            while(windowL <= mid && sum[windowL] < min) {
                windowL ++;
            }
            while(windowR <= mid && sum[windowR] <= max) {
                windowR ++;
            }
            ans += Math.max(0, windowR - windowL);
        }
        // 2.正常merge
        int[] help = new int[r - l + 1];
        int i = 0;
        int p1 = l;
        int p2 = mid + 1;
        while(p1 <= mid && p2 <= r) {
            help[i++] = sum[p1] <= sum[p2] ? sum[p1++] : sum[p2++];
        }
        while(p1 <= mid) {
            help[i++] = sum[p1++];
        }
        while(p2 <= r) {
            help[i++] = sum[p2++];
        }
        for (int j = 0; j < help.length; j++) {
            sum[l+j] = help[j];
        }
        // 3.返回
        return ans;
    }
}
