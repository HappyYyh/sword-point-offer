package example;

import java.util.Stack;

/**
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否可能为该栈的弹出顺序。
 * 假设压入栈的所有数字均不相等。
 *
 * 例如序列1,2,3,4,5是某栈的压入顺序，
 * 序列4,5,3,2,1是该压栈序列对应的一个弹出序列，
 * 但4,3,5,1,2就不可能是该压栈序列的弹出序列。（注意：这两个序列的长度是相等的）
 *
 * @ClassName: StackPushAndSequencePop
 * @description: 栈的压入、弹出序列
 * @author: yyh
 * @create: 2020-02-29 11:16
 **/
public class StackPushAndSequencePop {

    /**
     * other : 按照push的方式重新模拟入栈
     * 把push入栈，当遇到栈顶元素等同于pop元素时出栈，最后判断栈是否为空即可
     * @param pushA
     * @param popA
     * @return
     */
    private static boolean IsPopOrder(int [] pushA,int [] popA) {
        if (popA.length == 0 || popA.length != pushA.length) {
            return false;
        }
        Stack<Integer> stack = new Stack<>();
        //已经比较过的索引
        int index = 0;
        for (int value : pushA) {
            stack.push(value);
            //当遇到栈顶元素和未比较的push元素相等时
            while (!stack.isEmpty() && stack.peek() == popA[index]) {
                stack.pop();
                index++;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        int[] pushA = {1,2,3,4,5};
        int[] popA = {5,3,4,2,1};
        System.out.println(IsPopOrder(pushA,popA));
    }
}
