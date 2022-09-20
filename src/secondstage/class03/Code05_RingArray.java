package secondstage.class03;

public class Code05_RingArray {

    public static class MyQueue {
        private int[] arr;
        private int pushi;
        private int polli;
        private int size;
        private int limit;

        public MyQueue(int limit) {
            this.arr = new int[limit];
            this.pushi = 0;
            this.polli = 0;
            // 引入新变量 解耦pushi和polli
            this.size = 0;
            this.limit = limit;
        }

        public void push(int value) {
            if(size == limit) {
                throw new IllegalArgumentException("queue is full");
            }
            size ++;
            arr[pushi] = value;
            pushi = nextIndex(pushi);
        }

        public int poll() {
            if(size == 0) {
                throw new IllegalArgumentException("queue is empty");
            }
            size --;
            int ans = arr[polli];
            polli = nextIndex(polli);
            return ans;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        private int nextIndex(int index) {
            return index < limit - 1 ? index + 1 : 0;
        }
    }
}
