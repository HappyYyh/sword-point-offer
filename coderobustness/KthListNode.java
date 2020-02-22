package coderobustness;

import java.util.ArrayList;
import java.util.List;

/**
 * 输入一个链表，输出该链表中倒数第k个结点。
 * @ClassName: KthListNode
 * @description: 链表中倒数第k个结点
 * @author: yyh
 * @create: 2020-02-22 13:14
 **/
public class KthListNode {

    /**
     * my result : 利用list存储node，然后找出倒数低k个
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     * @param head
     * @param k
     * @return
     */
    private static ListNode FindKthToTail(ListNode head,int k) {
        if(head == null || k == 0){
            return null;
        }
        List<ListNode> list = new ArrayList<>();
        while (head != null){
            list.add(head);
            head = head.next;
        }
        return k > list.size() ? null : list.get(list.size() - k);
    }

    /**
     * my result : 两次遍历链表，第一次找出链表深度，第二次返回结果
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     * @param head
     * @param k
     * @return
     */
    private static ListNode FindKthToTail2(ListNode head,int k) {
        if(head == null || k == 0){
            return null;
        }
        ListNode tmp = head;
        // 第一次遍历找出深度
        int depth = 0;
        while (tmp != null){
            tmp = tmp.next;
            depth++;
        }
        if(k > depth){
            return null;
        }
        int count = 0;
        while (head.next != null){
            if(count == depth -k){
                break;
            }
            head = head.next;
            count++;
        }
        return head;
    }

    /**
     * 快慢指针 ：快指针走k次，然后快慢一起走，当 快指针为null是慢指针即为倒数第k个
     * 举例  depth    k     fast          slow
     *       5       3     先走3再走2       走2
     *       8       2     先走2再走6       走6
     * 观察 fast先走 k ，然后走 n-k  slow走n-k即为结果
     * @param head
     * @param k
     * @return
     */
    private static ListNode FindKthToTail3(ListNode head,int k) {
        if(head == null || k == 0){
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;
        for (int i = 0; i < k; i++) {
            if (fast == null) {
                return null;
            }
            fast = fast.next;
        }
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

    /**
     *   1->2->3->4->5 倒数低3个为3
     * @param args
     */
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        ListNode res = FindKthToTail3(node1,1);
        System.out.println(res == null ? "null" : res.val);
    }
}
