package example;

import java.util.Scanner;
import java.util.Stack;

/**
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））。
 * 注意：保证测试中不会当栈为空的时候，对栈调用pop()或者min()或者top()方法。
 *
 * All rights Reserved, Designed By yyh
 * 包含min函数的栈
 * @Package example
 * @author: yyh
 * @date: 2020-02-28 9:59
 * @since V1.0.0-SNAPSHOT
 */
public class MinFunctionStack {

    Stack<Integer> stack = new Stack<>();
    Stack<Integer> minStack = new Stack<>();

    /**
     * 双栈法：stack保存所有数据，minStack递减
     * 比如 6 5 3 6 7 2 1
     * 对于stack 则是 6 5 3 6 7 2 1
     * 对于minStack  6 5 3 3 3 2 1
     * @param node
     */
    public void push(int node) {
        stack.push(node);
        if(minStack.isEmpty()){
            minStack.push(node);
        }else {
            if(node <= minStack.peek()){
                minStack.push(node);
            }else {
                //保证两个栈元素大小相同，压入一个最小值
                minStack.push(minStack.peek());
            }
        }
    }

    public void pop() {
        stack.pop();
        minStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return minStack.peek();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MinFunctionStack stack  = new MinFunctionStack();
        while (true){
            System.out.println("push:压入栈元素");
            System.out.println("pop:弹出栈顶元素");
            System.out.println("top:输出栈顶元素");
            System.out.println("min:输出栈中最小元素");
            System.out.println("exit:退出程序");
            String next = scanner.next();
            switch (next){
                case "push":
                    System.out.println("请输入元素：");
                    stack.push(scanner.nextInt());
                    break;
                case "pop":
                    System.out.println("弹出元素：");
                    stack.pop();
                    break;
                case "top":
                    System.out.println("栈顶元素："+stack.top());
                    break;
                case "min":
                    System.out.println("最小元素："+stack.min());
                    break;
                case "exit":
                    return;
                default:
                    System.out.println("输入不合法，请重新输入！");
                    break;
            }
        }
    }
}
