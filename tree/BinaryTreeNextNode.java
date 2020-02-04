package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。
 * 注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
 * @ClassName: BinaryTreeNextNode
 * @description: 二叉树的下一个结点
 * @author: yyh
 * @create: 2020-02-04 09:17
 **/
public class BinaryTreeNextNode {

    private static List<TreeLinkNode> list = new ArrayList<>();

    /**
     * other:还原二叉树
     * 给出了某个节点，且二叉树存储着指向父结点的指针（next）则找到树的根节点，
     * 再对树进行中序遍历，最后根据中序遍历结果找到给定结点的下一结点
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     * @param pNode
     * @return
     */
    private static TreeLinkNode GetNext(TreeLinkNode pNode) {
        TreeLinkNode par = pNode;
        while(par.next != null){
            par = par.next;
        }
        inOrder(par);
        for (int i = 0; i < list.size(); i++) {
            if (pNode == list.get(i)) {
                return i == list.size() - 1 ? null : list.get(i + 1);
            }
        }
        return null;
    }

    private static void inOrder(TreeLinkNode pNode){
        if (pNode != null) {
            inOrder(pNode.left);
            list.add(pNode);
            inOrder(pNode.right);
        }
    }


    /**
     * other:直接找下一结点
     * 该二叉树为例，中序遍历为：{D,B,H,E,I,A,F,C,G}
     *              A
     *             / \
     *            B   C
     *           /\  /\
     *          D E F G
     *           /\
     *          H  I
     *
     * 仔细观察，可以把中序下一结点归为几种类型：
     * 1、有右子树，下一结点是右子树中的最左结点，例如 B，下一结点是 H
     * 2、无右子树，且结点是该结点父结点的左子树，则下一结点是该结点的父结点，例如 H，下一结点是 E
     * 3、无右子树，且结点是该结点父结点的右子树，则我们一直沿着父结点追朔，直到找到某个结点是其父结点的左子树
     * ，如果存在这样的结点，那么这个结点的父结点就是我们要找的下一结点。例如 I，下一结点是 A；例如 G，并没有符合情况的结点，所以 G 没有下一结点
     * @param pNode
     * @return
     */
    private static TreeLinkNode GetNext2(TreeLinkNode pNode) {
        // 1.有右子树
        if (pNode.right != null) {
            TreeLinkNode pRight = pNode.right;
            while (pRight.left != null) {
                pRight = pRight.left;
            }
            return pRight;
        }
        // 2.无右子树，且结点是该结点父结点的左子树
        if (pNode.next != null && pNode.next.left == pNode) {
            return pNode.next;
        }
        // 3.
        if (pNode.next != null) {
            TreeLinkNode pNext = pNode.next;
            while (pNext.next != null && pNext.next.right == pNext) {
                pNext = pNext.next;
            }
            return pNext.next;
        }
        return null;
    }

    public static void main(String[] args) {

    }
}
