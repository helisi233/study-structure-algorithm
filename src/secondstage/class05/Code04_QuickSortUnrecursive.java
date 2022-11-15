package secondstage.class05;

import java.util.Stack;

// 迭代版本的快速排序
public class Code04_QuickSortUnrecursive {
    static class OP {
        public int l;
        public int r;
        public OP(int l, int r) {
            this.l = l;
            this.r = r;
        }
    }

    public static void swap(int[] array, int x, int y) {
        int temp = array[x];
        array[x] = array[y];
        array[y] = temp;
    }



    public static void quickSort(int[] array) {
        if(array == null || array.length < 2) {
            return;
        }
        int[] equalArea = netherlandsFlag(array, 0, array.length - 1);
        int el = equalArea[0];
        int er = equalArea[1];
        Stack<OP> stack = new Stack<>();
        stack.push(new OP(0, el-1));
        stack.push(new OP(er+1, array.length-1));
        // 用栈代替递归调用
        while(!stack.isEmpty()) {
            OP op = stack.pop();
            if(op.l < op.r) {
                equalArea = netherlandsFlag(array, op.l, op.r);
                el = equalArea[0];
                er = equalArea[1];
                stack.push(new OP(op.l, el-1));
                stack.push(new OP(er+1, op.r));
            }
        }
    }

    // 分区
    private static int[] netherlandsFlag(int[] array, int l, int r) {
        return null;
    }
}
