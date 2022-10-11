package secondstage.class04;

public class Code01_MergeSort2 {

    public static void mergeSort(int[] array) {
        int N = array.length;
        int mergeSize = 1;
        while(mergeSize < N) {
            // 当前左组的子一个位置
            int L = 0;
            while(L < N) {
                int M = L + mergeSize - 1;
                if(M >= N) {
                    break;
                }
                int R = Math.min(M + mergeSize, N - 1);
                merge(array, L, M, R);
                L = R + 1;
            }
            if(mergeSize > N / 2) {
                break;
            }
            mergeSize <<= 1;
        }
    }

    public static void merge(int[] arr, int l, int m, int r) {

    }

    public static void main(String[] args) {

    }
}
