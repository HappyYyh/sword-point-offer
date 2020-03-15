package efficiencybalance;

import java.util.ArrayList;

/**
 * 输入两个链表，找出它们的第一个公共结点。
 * （注意因为传入数据是链表，所以错误测试数据的提示是用其他方式显示的，保证传入数据是正确的）
 *
 * @ClassName: FirstCommonNodeOfTwoListNode
 * @description: 两个链表的第一个公共结点
 * @author: yyh
 * @create: 2020-03-15 12:19
 **/
public class FirstCommonNodeOfTwoListNode {

    private static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    /**
     * my result(once pass) : 先用list存储node1的值，然后遍历node2，找到相同的值则返回其结点（比较取巧，无法保证相同值后面结点相同）
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     * @param pHead1
     * @param pHead2
     * @return
     */
    private static ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        ArrayList<Integer> list = new ArrayList<>();
        while (pHead1 != null){
            list.add(pHead1.val);
            pHead1 = pHead1.next;
        }
        while (pHead2 != null){
            if(list.contains(pHead2.val)){
                return pHead2;
            }else {
                pHead2 = pHead2.next;
            }
        }
        return null;
    }

    /**
     * other：双指针法
     * 创建两个指针p1和p2,分别指向两个链表的头结点，然后依次往后遍历。
     * 如果某个指针到达末尾，则将该指针指向另一个链表的头结点；
     * 如果两个指针所指的节点相同，则循环结束，返回当前指针指向的节点。
     * 比如两个链表分别为：1->3->4->5->6和2->7->8->9->5->6
     * 短链表的指针p1会先到达尾部，然后重新指向长链表头部，
     * 当长链表的指针p2到达尾部时，重新指向短链表头部，
     * 此时p1在长链表中已经多走了k步(k为两个链表的长度差值)，
     * p1和p2位于同一起跑线，往后遍历找到相同节点即可。
     *
     * @param pHead1
     * @param pHead2
     * @return
     */
    private static ListNode FindFirstCommonNode2(ListNode pHead1, ListNode pHead2) {
        if(pHead1 == null || pHead2 == null) {
            return null;
        }
        ListNode p1 = pHead1;
        ListNode p2 = pHead2;
        while (p1 != p2) {
            p1 = p1 == null ? pHead2 : p1.next;
            p2 = p2 == null ? pHead1 : p2.next;
        }
        return p1;
    }

    /**
     *  1->3->5
     *  2->3->5
     *  第一个公共结点是3
     *  当一个节点相等后,说明这个节点后面的节点都重合了,肯定也是相等的,这就是为什么只要求第一个重合的节点了
     * @param args
     */
    public static void main(String[] args) {
        ListNode pHead1 = new ListNode(1);
        pHead1.next = new ListNode(3);
        pHead1.next.next = new ListNode(5);
        ListNode pHead2 = new ListNode(2);
        pHead2.next = new ListNode(4);
        pHead2.next.next = new ListNode(3);
        pHead2.next.next.next = new ListNode(5);
        ListNode commonNode = FindFirstCommonNode2(pHead1, pHead2);
        if(commonNode == null){
            System.out.println("null");
        }else {
            System.out.println(commonNode.val);
        }
    }
}
