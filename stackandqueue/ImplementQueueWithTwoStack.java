package stackandqueue;

import java.util.Stack;

/**
 * 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
 * @ClassName: ImplementQueueWithTwoStack
 * @description: 用两个栈实现队列
 * @author: yyh
 * @create: 2020-02-11 10:47
 **/
public class ImplementQueueWithTwoStack {

    private static Stack<Integer> stack1 = new Stack<>();
    private static Stack<Integer> stack2 = new Stack<>();

    /**
     * my result (once pass):同leetcode232
     * @param node
     */
    private static void push(int node) {
        stack1.push(node);
    }

    private static int pop() {
        int top = stack1.get(0);
        // 清空stack2，注意不能用clear，因为下面stack1指向了stack2
        stack2 = new Stack<>();
        for (int i = 1; i < stack1.size() ; i++) {
            stack2.push(stack1.get(i));
        }
        stack1 = stack2;
        return top;
    }

    /**
     * other
     * @return
     */
    private static int pop2() {
        if (stack2.empty()) {
            while (stack1.size() != 0) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }

    public static void main(String[] args) {
        push(1);
        push(2);
        push(3);
        System.out.println(pop());
        System.out.println(pop());
        System.out.println(pop());
    }
}
