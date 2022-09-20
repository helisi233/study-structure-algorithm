package secondstage.class03;

import java.util.LinkedList;
import java.util.Queue;

public class Code08_TwoQueueImplementStack {

    public static class QueueImplStack {
        Queue<Integer> queue;
        Queue<Integer> help;

        public QueueImplStack() {
            queue = new LinkedList<>();
            help = new LinkedList<>();
        }

        public void push(Integer num) {
            queue.offer(num);
        }

        public Integer poll() {
            while(queue.size() > 1) {
                help.offer(queue.poll());
            }
            int ans = queue.poll();
            Queue<Integer> tmp = queue;
            queue = help;
            help = tmp;
            return ans;
        }

        public Integer peek() {
            while(queue.size() > 1) {
                help.offer(queue.poll());
            }
            int ans = queue.poll();
            help.offer(ans);
            Queue<Integer> tmp = queue;
            queue = help;
            help = tmp;
            return ans;
        }
    }
}
