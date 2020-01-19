package linkedlist;

/**
 * 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，
 * 重复的结点不保留，返回链表头指针。
 * <p>
 * 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 * <p>
 * All rights Reserved, Designed By yyh
 * 删除链表中重复的结点
 *
 * @Package linkedlist
 * @author: yyh
 * @date: 2020-01-19 9:36
 * @since V1.0.0-SNAPSHOT
 */
public class DeleteDuplication {

    private static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    /**
     * other: 非递归
     * 1、首先添加一个头节点，以方便碰到第一个，第二个节点就相同的情况
     * 2.设置 pre ，last 指针， pre指针指向当前确定不重复的那个节点，
     * 而last指针相当于工作指针，一直往后面搜索。
     * @param pHead
     * @return
     */
    private static ListNode deleteDuplication(ListNode pHead) {
        if (pHead == null || pHead.next == null) {
            return pHead;
        }
        ListNode head = new ListNode(0);
        head.next = pHead;
        ListNode pre = head;
        ListNode last = head.next;
        while (last != null) {
            if (last.next != null && last.val == last.next.val) {
                // 找到最后的一个相同节点
                while (last.next != null && last.val == last.next.val) {
                    last = last.next;
                }
                pre.next = last.next;
                last = last.next;
            } else {
                // 没有和后一个节点重复则同时后移
                pre = pre.next;
                last = last.next;
            }
        }
        return head.next;
    }

    /**
     * other : 递归
     * @param pHead
     * @return
     */
    private static ListNode deleteDuplication2(ListNode pHead) {
        if (pHead == null || pHead.next == null) {
            return pHead;
        }
        if (pHead.val == pHead.next.val) {
            // 当前结点是重复结点
            ListNode pNode = pHead.next;
            while (pNode != null && pNode.val == pHead.val) {
                // 跳过值与当前结点相同的全部结点,找到第一个与当前结点不同的结点
                pNode = pNode.next;
            }
            // 从第一个与当前结点不同的结点开始递归
            return deleteDuplication2(pNode);
        } else {
            // 当前结点不是重复结点
            // 保留当前结点，从下一个结点开始递归
            pHead.next = deleteDuplication2(pHead.next);
            return pHead;
        }
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(3);
        ListNode node5 = new ListNode(4);
        ListNode node6 = new ListNode(4);
        ListNode node7 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        ListNode listNode = deleteDuplication2(node1);
        while (listNode != null) {
            System.out.print(listNode.val + " ->");
            listNode = listNode.next;
        }
    }
}
