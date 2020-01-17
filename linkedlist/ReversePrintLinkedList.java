package linkedlist;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 输入一个链表，按链表从尾到头的顺序返回一个ArrayList。
 * 和LeetCode206一样
 * All rights Reserved, Designed By yyh
 * 从尾到头打印链表
 * @Package linkedlist
 * @author: yyh
 * @date: 2020-01-17 17:19
 * @since V1.0.0-SNAPSHOT
 */
public class ReversePrintLinkedList {

    private static class ListNode {
        int val;
        ListNode next = null;
        ListNode(int val) {
            this.val = val;
        }
    }

    /**
     * my result : 顺序遍历放入栈中，然后把栈中元素放入list（偷鸡）
     * @param listNode
     * @return
     */
    private static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> result = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        while (listNode != null){
            stack.push(listNode.val);
            listNode = listNode.next;
        }
        while (!stack.isEmpty()){
            result.add(stack.pop());
        }
        return result;
    }

    /**
     * my result :迭代反转链表
     * prev 存放结果
     * curr 当前指针
     * 每次遍历curr的时候用tmp保存curr的后续节点，然后把当前节点的后续变成 prev，
     * 然后把当前节点给prev（这时的prev就是当前反转后的结果）
     * 比如：1->2->3
     * 第一次循环
     *     prev null
     *     curr 1->2->3
     *     tmp 2->3
     *     curr.next = null 即 curr = 1->null
     *     prev = 1->null
     *     curr = tmp 即 curr = 2->3
     * 第二次循环
     *     prev 1->null
     *     curr 2->3
     *     tmp  3
     *     curr.next = prev 即 curr = 2->1->null
     *     prev = curr 即2->1->null
     *     curr = tmp 即 curr = 3
     * 第三次循环
     *     prev 2->1->null
     *     curr 3
     *     tmp  null
     *     curr.next = prev 即 curr = 3->2->1->null
     *     prev = curr 即 prev = 3->2->1->nul
     *     curr = tmp = null
     * 结束循环
     * @param listNode
     * @return
     */
    private static ArrayList<Integer> printListFromTailToHead2(ListNode listNode) {
        ArrayList<Integer> result = new ArrayList<>();
        ListNode prev = null;
        ListNode curr = listNode;
        while (curr != null){
            ListNode tmp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = tmp;
        }
        while (prev!=null){
            result.add(prev.val);
            prev = prev.next;
        }
        return result;
    }

    /**
     * my result :递归翻转链表
     * @param listNode
     * @return
     */
    private static ArrayList<Integer> printListFromTailToHead3(ListNode listNode) {
        ArrayList<Integer> result = new ArrayList<>();
        ListNode node = reverseListNode(listNode);
        while (node != null){
            result.add(node.val);
            node = node.next;
        }
        return result;
    }

    /**
     * 翻转listNode
     * @param head
     * @return
     */
    private static ListNode reverseListNode(ListNode head){
        if (head == null || head.next == null) {
            return head;
        }
        ListNode p = reverseListNode(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }

    public static void main(String[] args) {
        ListNode root = new ListNode(1);
        root.next = new ListNode(2);
        root.next.next = new ListNode(3);
        System.out.println(printListFromTailToHead3(root));
    }
}
