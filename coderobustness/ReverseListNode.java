package coderobustness;

/**
 * 输入一个链表，反转链表后，输出新链表的表头。
 * @ClassName: ReverseListNode
 * @description: 反转链表
 * @author: yyh
 * @create: 2020-02-23 10:17
 **/
public class ReverseListNode {

    /**
     * leetcode206:迭代
     * head       prev       curr         nextTemp
     * 2->3->5    null       2->3->5
     *           2->null     3->5           3->5
     *           3->2->null  5              5
     *
     * 即 每次用一个临时变量保存curr.next，然后让prev赋给curr.next（即curr= 当前节点值+prev，prev为反转后的链表）
     *    然后prev = curr，这样就让prev取得了当前翻转后的链表
     * @param head
     * @return
     */
    private static ListNode ReverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }

    /**
     * leetcode206:递归
     * @param head
     * @return
     */
    private static ListNode ReverseList2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode p = ReverseList2(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }


    /**
     *  2->3->5   变成   5->3->2
     * @param args
     */
    public static void main(String[] args) {
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        ListNode.iterator(node1);
        ListNode reverse = ReverseList(node1);
        ListNode.iterator(reverse);
    }
}
