package decompose;


import java.util.ArrayList;

/**
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
 * 要求不能创建任何新的结点，只能调整树中结点指针的指向。
 *
 * All rights Reserved, Designed By yyh
 * 二叉搜索树与双向链表
 * @Package decompose
 * @author: yyh
 * @date: 2020-03-05 10:17
 * @since V1.0.0-SNAPSHOT
 */
public class BinarySearchTreeAndDoublyListNode {

    private static class TreeNode{
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
        public TreeNode(int val) {
            this.val = val;
        }
    }

    /**
     * my result(思路正确，但之前代码顺序有问题)：中序遍历放入list，即可得到有续的节点，然后连接起来
     * @param pRootOfTree
     * @return
     */
    private static TreeNode Convert(TreeNode pRootOfTree) {
        ArrayList<TreeNode> list = new ArrayList<>();
        infix(list,pRootOfTree);
        for (int i = 0; i < list.size() -1 ; i++) {
            list.get(i).right = list.get(i + 1);
            list.get(i + 1).left = list.get(i);
        }
        return list.size() > 0 ? list.get(0) : null;
    }

    private static void infix(ArrayList<TreeNode> list ,TreeNode root){
        if(root == null){
            return;
        }
        infix(list,root.left);
        list.add(root);
        infix(list,root.right);
    }

    private static TreeNode pre = null;

    /**
     * other
     * @param pRootOfTree
     * @return
     */
    private static TreeNode Convert2(TreeNode pRootOfTree) {
        if (pRootOfTree == null) {
            return null;
        }
        Convert2(pRootOfTree.right);
        if (pre == null) {
            pre = pRootOfTree;
        } else {
            pRootOfTree.right = pre;
            pre.left = pRootOfTree;
            pre = pRootOfTree;
        }
        Convert2(pRootOfTree.left);
        return pre;
    }

    /**
     *       8
     *      / \
     *     6   10
     *     \   /
     *     7  9
     *   改造后：6->7->8->9->10(left)
     *          6<-7-<8-<9<-10(right)
     *
     * @param args
     */
    public static void main(String[] args) {
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        TreeNode node8 = new TreeNode(8);
        TreeNode node9 = new TreeNode(9);
        TreeNode node10 = new TreeNode(10);
        node8.left = node6;
        node8.right = node10;
        node6.right = node7;
        node10.left = node9;
        TreeNode listNode = Convert2(node8);
        if(listNode == null){
            System.out.println("null");
        }else {
            System.out.print("left遍历：" + listNode.val);
            while (listNode.right != null) {
                System.out.print("->" + listNode.right.val);
                listNode = listNode.right;
            }
            System.out.print("\nright遍历：");
            while (listNode != null) {
                System.out.print(listNode.val + "->");
                listNode = listNode.left;
            }
        }
    }
}
