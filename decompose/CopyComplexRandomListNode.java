package decompose;

import java.util.HashMap;

/**
 * 输入一个复杂链表
 * （每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点），
 * 返回结果为复制后复杂链表的head。
 *
 * （注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
 *
 * All rights Reserved, Designed By yyh
 * 复杂链表的复制
 * @Package decompose
 * @author: yyh
 * @date: 2020-03-04 10:11
 * @since V1.0.0-SNAPSHOT
 */
public class CopyComplexRandomListNode {

    private static class RandomListNode {
        int label;
        RandomListNode next = null;
        RandomListNode random = null;

        RandomListNode(int label) {
            this.label = label;
        }
    }

    /**
     * other；利用Map存储新旧链表节点的对应的结点关系,迭代旧链表，从而在 map中更新新链表的 next 与 random 两个字段
     * 比如 next关系： 1->3->5
     * 第一次遍历后：
     * map存储的是： (1->3->5,1) (3->5,3) (5,5)
     * 第二次遍历：
     * map.get(1->3->5) 即 1.next = map.get(3->5) 得： 1->3 而1.random = 1.random
     * map.get(3->5) 即 3.next = map.get(5) 得：3->5 而 3.random = 3.random
     * map.get(5) 即 5.next = null 得5->null 而 5.random = 5.random
     * 所以遍历完成后 map中（1->3->5，1->3->5) (3->5,3->5) (5->5)这样就完成了复制
     * @param pHead
     * @return
     */
    private static RandomListNode Clone(RandomListNode pHead) {
        if(pHead == null){
            return null;
        }
        RandomListNode p1 = pHead;
        RandomListNode p2 = pHead;
        HashMap<RandomListNode, RandomListNode> map = new HashMap<>();
        while (p1 != null) {
            //key：原始链表 value：以原始链表的值构建的节点
            map.put(p1, new RandomListNode(p1.label));
            p1 = p1.next;
        }

        while (p2 != null) {
            //遍历head
            if (p2.next != null) {
                //如果原始节点next ！= null，则 以原始链表值构建的节点 next = 原始节点的next
                map.get(p2).next = map.get(p2.next);
            } else {
                map.get(p2).next = null;
            }
            map.get(p2).random = map.get(p2.random);
            p2 = p2.next;
        }
        return map.get(pHead);
    }

    /**
     * other:
     * 解题思路：
     * 1、遍历链表，复制每个结点，如复制结点A得到A1，将结点A1插到结点A后面；
     * 2、重新遍历链表，复制老结点的随机指针给新结点，如A1.random = A.random.next;
     * 3、拆分链表，将链表拆分为原链表和复制后的链表
     *
     * @param pHead
     * @return
     */
    private static RandomListNode Clone2(RandomListNode pHead) {
        if(pHead == null) {
            return null;
        }

        RandomListNode currentNode = pHead;
        //1、复制每个结点，如复制结点A得到A1，将结点A1插到结点A后面；
        while(currentNode != null){
            RandomListNode cloneNode = new RandomListNode(currentNode.label);
            RandomListNode nextNode = currentNode.next;
            currentNode.next = cloneNode;
            cloneNode.next = nextNode;
            currentNode = nextNode;
        }

        currentNode = pHead;
        //2、重新遍历链表，复制老结点的随机指针给新结点，如A1.random = A.random.next;
        while(currentNode != null) {
            currentNode.next.random = currentNode.random==null?null:currentNode.random.next;
            currentNode = currentNode.next.next;
        }

        //3、拆分链表，将链表拆分为原链表和复制后的链表
        currentNode = pHead;
        RandomListNode pCloneHead = pHead.next;
        while(currentNode != null) {
            RandomListNode cloneNode = currentNode.next;
            currentNode.next = cloneNode.next;
            cloneNode.next = cloneNode.next==null?null:cloneNode.next.next;
            currentNode = currentNode.next;
        }

        return pCloneHead;
    }

    /**
     * 假如有链表
     *  next指向：1->3 ->5->null
     *  random指向：1->5->3->null
     * @param args
     */
    public static void main(String[] args) {
        RandomListNode node1 = new RandomListNode(1);
        RandomListNode node3 = new RandomListNode(3);
        RandomListNode node5 = new RandomListNode(5);
        node1.next = node3;
        node1.random = node5;
        node3.next = node5;
        node5.next = null;
        node5.random = node3;
        RandomListNode result = Clone2(node1);
        if(result == null){
            System.out.println("null");
        }else {
            RandomListNode random = result;
            System.out.print("next : " +result.label + "->");
            while (result.next != null){
                System.out.print(result.next.label + "->");
                result = result.next;
            }
            System.out.print("\nrandom : " +random.label + "->");
            //可能需要遍历环形链表
        }
    }
}
