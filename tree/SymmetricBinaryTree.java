package tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 请实现一个函数，用来判断一颗二叉树是不是对称的。
 * 注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
 * @ClassName: SymmetricBinaryTree
 * @description: 对称的二叉树
 * @author: yyh
 * @create: 2020-02-05 13:11
 **/
public class SymmetricBinaryTree {

    private static boolean isSymmetrical(TreeNode pRoot) {
        if(null == pRoot){
            return true;
        }
        return compare(pRoot.left,pRoot.right);
    }

    private static boolean compare(TreeNode left,TreeNode right){
        //两个同时为null，认为是相同的
        if(left == null || right == null){
            return left == null && right == null;
        }
        //左右值不一样则返回false
        if(left.val != right.val){
            return false;
        }
        //递归，让两棵树对称比较
        return compare(left.left,right.right) && compare(left.right,right.left);
    }

    /**
     * leetcode :迭代
     * 队列中每两个连续的结点应该是相等的，而且它们的子树互为镜像。
     * 最初，队列中包含的是 root 以及 root。该算法的工作原理类似于 BFS，但存在一些关键差异。
     * 每次提取两个结点并比较它们的值。然后，将两个结点的左右子结点按相反的顺序插入队列中。
     * 当队列为空时，或者我们检测到树不对称（即从队列中取出两个不相等的连续结点）时，该算法结束。
     *
     * @param root
     * @return
     */
    private static boolean isSymmetrical2(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(root);
        while (!q.isEmpty()) {
            //获取队列首个元素
            TreeNode t1 = q.poll();
            TreeNode t2 = q.poll();
            if (t1 == null && t2 == null) continue;
            if (t1 == null || t2 == null) return false;
            if (t1.val != t2.val) return false;
            q.add(t1.left);
            q.add(t2.right);
            q.add(t1.right);
            q.add(t2.left);
        }
        return true;
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(2);
        node.left.left = new TreeNode(3);
        node.left.right = new TreeNode(4);
        node.right.left = new TreeNode(4);
        node.right.right = new TreeNode(3);
        System.out.println(isSymmetrical(node));
    }
}
