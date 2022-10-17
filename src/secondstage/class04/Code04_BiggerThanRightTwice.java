package secondstage.class04;

public class Code04_BiggerThanRightTwice {

    // mergesort可以把比较信息变成有序的东西，这个有序的东西可以快速的求出很多事
    public static int biggerTwice(int[] arr) {
        return process(arr, 0, arr.length-1);
    }

    public static int process(int[] arr, int l, int r) {
        if(l == r) {
            return 0;
        }
        int mid = l + ((r - l) >> 1);
        return process(arr, l, mid) + process(arr, mid+1, r) + merge(arr, l, mid, r);
    }

    public static int merge(int[] arr, int l, int m, int r) {
        int ans = 0;
        // 目前囊括进来的数 是从[m+1,windowR)
        int windowR = m + 1;
        for (int i = l; i <= m; i++) {
            while(windowR <= r && arr[i] > (arr[windowR] << 1)) {
                windowR ++;
            }
            ans += windowR - m - 1;
        }
        int[] help = new int[r - l + 1];
        int p1 = l,p2 = m + 1;
        int index = 0;
        while(p1 <= m && p2 <= r) {
            help[index++] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++];
        }
        while(p1 <= m) {
            help[index++] = arr[p1++];
        }
        while(p2 <= r) {
            help[index++] = arr[p2++];
        }

        return ans;
    }

    public static void main(String[] args) {

    }
}
