package secondstage.class05;

public class Code02_HollandFlag {

    public static void swap(int[] array, int x, int y) {
        int temp = array[x];
        array[x] = array[y];
        array[y] = temp;
    }

    public static int Partition1(int[] array, int l, int r) {
        int tmp = array[r-1];
        int p = l-1;
        for (int i = l; i < r; i++) {
            if(array[i] <= tmp) {
                swap(array, i, ++p);
            }
        }
        swap(array, array.length-1, ++p);
//        for (int i = 0; i < array.length; i++) {
//            System.out.print(array[i] + " ");
//        }
        return p;
    }

    // 返回等于区域下标
    public static int[] Partition2(int[] array, int l, int r) {
        if(l > r) {
            return new int[]{-1,-1};
        }
        if(l == r) {
            return new int[]{l, r};
        }
        int p = l-1;
        int q = r-1;
        int index = l;
        int tmp = array[r-1];
        while(index < q) {
            if(array[index] < tmp) {
                swap(array, index++, ++p);
            }else if(array[index] == tmp) {
                index ++;
            }else {
                swap(array, index, --q);
            }
        }
        swap(array, q, r-1);
        for (int i = l; i < r; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
        return new int[]{p+1, q};
    }

    public static void main(String[] args) {
        int[] array = {0,1,2,9,4,7,3,8,2,1,6,8,5,5};
        int[] ints = Partition2(array, 0, array.length);
        System.out.println(ints[0] + " " + ints[1]);
    }
}
