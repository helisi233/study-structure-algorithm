package firststage.class08;

import firststage.utils.ArrayUtils;
import java.util.Stack;

public class Code04_QuickSortIteration {

    public static class Job {
        int start;
        int end;
        public Job(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static void swap(int[] array, int first, int second) {
        int temp = array[first];
        array[first] = array[second];
        array[second] = temp;
    }

    public static int[] partition(int[] array, int start, int end) {
        int less = start-1;
        int more = end;
        int index = start;

        while(index < more) {
            if(array[index] < array[end]) {
                swap(array, index++, ++less);
            }else if(array[index] > array[end]) {
                swap(array, index, --more);
            }else {
                index ++;
            }
        }

        swap(array, more, end);

        return new int[]{less, more};
    }

    public static void quickSortIteration(int[] array) {
        if(array == null || array.length < 2) {
            return;
        }
        Stack<Job> stack = new Stack<>();
        stack.push(new Job(0, array.length-1));
        while(!stack.isEmpty()) {
            Job cur = stack.pop();
            int[] results = partition(array, cur.start, cur.end);
            if(results[0] > cur.start) {
                stack.push(new Job(cur.start, results[0]));
            }
            if(results[1] < cur.end) {
                stack.push(new Job(results[1]+1, cur.end));
            }
        }
    }

    public static void main(String[] args) {
        int[] randomArray = ArrayUtils.generateRandomArray(10, 10);
        quickSortIteration(randomArray);
        ArrayUtils.printlnArray(randomArray);
    }
}
