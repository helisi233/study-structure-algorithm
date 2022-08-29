package firststage.utils;

public class ArrayUtils {

    public static int[] generateRandomArray(int maxLength, int maxValue) {
        int[] array = new int[maxLength];
        for (int i = 0; i < maxLength; i++) {
            array[i] = (int)(Math.random() * maxValue);
        }
        return array;
    }

    public static void printlnArray(int[] array) {
        if(array == null) return;
        for (int elements : array) {
            System.out.print(elements + ", ");
        }
        System.out.println();
    }

    public static void SwapElementArray(int[] array, int first, int second) {
        int temp = array[first];
        array[first] = array[second];
        array[second] = temp;
    }

    public static boolean isSorted(int[] array1, int[] array2) {
        if(array1.length != array2.length) {
            return false;
        }
        int length = array1.length;
        for (int i = 0; i < length; i++) {
            if(array1[i] != array2[i]) {
                return false;
            }
        }
        return true;
    }
}
