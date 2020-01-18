package linkedlist;

/**
 * 给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，输出null。
 *
 * @ClassName: EntryNodeOfLoop
 * @description: 链表中环的入口结点
 * @author: yyh
 * @create: 2020-01-18 11:33
 **/
public class EntryNodeOfLoop {

    private static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    /**
     * other ：双指针
     * 设置快慢指针，快指针走两步，慢指针走一步，如果为环形链表则最终会相遇（这个很好理解）
     * 然后让慢指针从头节点出发，快指针从相遇点出发，最后一定在入口点相遇（这个是别人推导出的数学定理。。https://www.nowcoder.com/questionTerminal/253d2c59ec3e4bc68da16833f79a38e4?f=discussion）
     * 举例：1->2->3->2 其中2为环行入口
     * 设快慢指针从头结点开始
     * 快  3  3
     * 慢  2  3
     * 相遇点为3
     * 然后 慢指针 从1开始
     * 快  3 2
     * 慢  1 2
     * 此时在2相等，即2为入口
     * @param pHead
     * @return
     */
    private static ListNode entryNodeOfLoop(ListNode pHead) {
        ListNode fast = pHead;
        ListNode low = pHead;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            low = low.next;
            if (fast == low) {
                break;
            }
        }
        if (fast == null || fast.next == null) {
            return null;
        }
        low = pHead;
        while (fast != low) {
            fast = fast.next;
            low = low.next;
        }
        return low;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        node1.next = node2;
        node2.next = node3;
        node3.next = node2;
        ListNode node = entryNodeOfLoop(node1);
        System.out.println(" 环节点的指： "+ (node == null ? "" : node.val));
    }
}
