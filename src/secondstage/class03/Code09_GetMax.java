package secondstage.class03;

public class Code09_GetMax {

    // 任何递归都可以改成非递归
    // 递归的写法
    // max左-[l,mid] max右-[mid+1,r]
    public int getMax(int[] arr) {
        return process(arr, 0, arr.length-1);
    }

    public int process(int[] arr, int l, int r) {
        if(l == r) {
            return arr[l];
        }
        int mid = l + ((r - l) >> 1);
        int leftMax = process(arr, l, mid);
        int rightMax = process(arr, mid+1, r);
        return Math.max(leftMax, rightMax);
    }


}
