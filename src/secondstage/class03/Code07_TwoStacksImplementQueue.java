package secondstage.class03;

import java.util.Stack;

public class Code07_TwoStacksImplementQueue {

    public static class StackImpleQueue {
        public Stack<Integer> pushStack;
        public Stack<Integer> popStack;

        public StackImpleQueue() {
            pushStack = new Stack<Integer>();
            popStack = new Stack<Integer>();
        }

        public void pushToPop() {
            if(popStack.isEmpty()) {
                while(!pushStack.empty()) {
                    popStack.push(pushStack.pop());
                }
            }
        }

        public void push(Integer num) {
            pushStack.push(num);
            pushToPop();
        }

        public Integer poll() {
            if(pushStack.empty() && popStack.empty()) {
                throw new IllegalArgumentException("queue is empty");
            }
            pushToPop();
            return popStack.pop();
        }

        public Integer peek() {
            if(pushStack.empty() && popStack.empty()) {
                throw new IllegalArgumentException("queue is empty");
            }
            pushToPop();
            return popStack.peek();
        }
    }
}
