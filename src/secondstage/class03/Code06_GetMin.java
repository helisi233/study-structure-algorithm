package secondstage.class03;

import java.util.Stack;

public class Code06_GetMin {

    public static class MyStack {
        Stack<Integer> dataStack;
        Stack<Integer> minStack;

        public MyStack() {
            dataStack = new Stack<Integer>();
            minStack = new Stack<Integer>();
        }

        public void push(Integer newNum) {
            if(minStack.isEmpty()) {
                minStack.push(newNum);
            }
            if(newNum <= getMin()) {
                minStack.push(newNum);
            }
            dataStack.push(newNum);
        }

        public Integer pop() {
            if(dataStack.isEmpty()) {
                throw new IllegalArgumentException("stack is empty");
            }
            int value = dataStack.pop();
            if(value == getMin()) {
                minStack.pop();
            }
            return value;
        }

        public Integer getMin() {
            if(minStack.isEmpty()) {
                throw new IllegalArgumentException("stack is empty");
            }
            return minStack.peek();
        }
    }
}
