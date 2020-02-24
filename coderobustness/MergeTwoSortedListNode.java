package coderobustness;

/**
 * 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 * @ClassName: MergeTwoSortedListNode
 * @description: 合并两个排序的链表
 * @author: yyh
 * @create: 2020-02-24 10:02
 **/
public class MergeTwoSortedListNode {

    /**
     * leetcode21：递归的合并链表
     * 举例
     * list1  1->3->5
     * list2  2->4->6
     * 1-> Merge(3->5,2->4->6)
     * 1->2->Merge(3->5,4->6)
     * 1->2->3->Merge(5,4->6)
     * 1->2->3->4->Merge(5,6)
     * 1->2->3->4->5->Merge(null,6)
     * 1->2->3->4->5->6
     * @param list1
     * @param list2
     * @return
     */
    private static ListNode Merge(ListNode list1,ListNode list2) {
        if (list1 == null) {
            return list2;
        } else if (list2 == null) {
            return list1;
        } else if (list1.val < list2.val) {
            list1.next = Merge(list1.next, list2);
            return list1;
        } else {
            list2.next = Merge(list1, list2.next);
            return list2;
        }
    }

    /**
     * other:迭代
     * @param list1
     * @param list2
     * @return
     */
    private static ListNode Merge2(ListNode list1, ListNode list2) {
        ListNode h = new ListNode(-1);
        ListNode cur = h;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                cur.next = list1;
                list1 = list1.next;
            } else {
                cur.next = list2;
                list2 = list2.next;
            }
            cur = cur.next;
        }
        if (list1 != null) {
            cur.next = list1;
        }
        if (list2 != null) {
            cur.next = list2;
        }
        return h.next;
    }

    public static void main(String[] args) {
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(3);
        list1.next.next = new ListNode(5);
        ListNode list2 = new ListNode(2);
        list2.next = new ListNode(4);
        list2.next.next = new ListNode(6);
        ListNode merge = Merge2(list1,list2);
        ListNode.iterator(merge);
    }
}
