package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一棵二叉搜索树，请找出其中的第k小的结点。
 * 例如， （5，3，7，2，4，6，8） 中，按结点数值大小顺序第三小结点的值为4。
 * @ClassName: KthNode
 * @description: 二叉搜索树的第k个结点
 * @author: yyh
 * @create: 2020-02-09 12:01
 **/
public class KthNode {

    private static List<TreeNode> list = new ArrayList<>();

    /**
     * 先用中序遍历把每个节点放入list中，然后比较即可
     * @param pRoot
     * @param k
     * @return
     */
    private static TreeNode KthNode(TreeNode pRoot, int k) {
        addNode(pRoot);
        if(k >0 && k <= list.size()){
            return list.get(k-1);
        }
        return null;
    }

    /**
     * 中序遍历
     * @param node
     */
    private static void addNode(TreeNode node){
        if(node != null){
            addNode(node.left);
            list.add(node);
            addNode(node.right);
        }
    }



    /**
     *           5
     *         /  \
     *        3    7
     *       / \  / \
     *      2  4 6   8
     * @param args
     */
    public static void main(String[] args) {
        TreeNode node5 = new TreeNode(5);
        TreeNode node3 = new TreeNode(3);
        TreeNode node7 = new TreeNode(7);
        TreeNode node2 = new TreeNode(2);
        TreeNode node4 = new TreeNode(4);
        TreeNode node6 = new TreeNode(6);
        TreeNode node8 = new TreeNode(8);
        node5.left = node3;
        node5.right = node7;
        node3.left = node2;
        node3.right = node4;
        node7.left = node6;
        node7.right = node8;
        TreeNode node = KthNode(node5, 1);
        System.out.println(node.val);
    }
}
