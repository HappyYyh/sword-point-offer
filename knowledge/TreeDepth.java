package knowledge;

import javafx.util.Pair;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 输入一棵二叉树，求该树的深度。
 * 从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。
 *
 * All rights Reserved, Designed By yyh
 * 二叉树的深度
 * @Package knowledge
 * @author: yyh
 * @date: 2020-03-17 9:56
 * @since V1.0.0-SNAPSHOT
 */
public class TreeDepth {

    private static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
        public TreeNode(int val) {
            this.val = val;
        }
    }

    /**
     * my result(once pass):递归
     * @param root
     * @return
     */
    private static int TreeDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        return Math.max(TreeDepth(root.left),TreeDepth(root.right)) + 1;
    }

    /**
     * leetcode 104：迭代
     * @param root
     * @return
     */
    private static int TreeDepth2(TreeNode root) {
        Queue<Pair<TreeNode, Integer>> stack = new LinkedList<>();
        if (root != null) {
            stack.add(new Pair(root, 1));
        }
        int depth = 0;
        while (!stack.isEmpty()) {
            Pair<TreeNode, Integer> current = stack.poll();
            root = current.getKey();
            int currentDepth = current.getValue();
            if (root != null) {
                depth = Math.max(depth, currentDepth);
                stack.add(new Pair(root.left, currentDepth + 1));
                stack.add(new Pair(root.right, currentDepth + 1));
            }
        }
        return depth;
    }

    /**
     *      1
     *     / \
     *    3  5
     *   /\
     *  7  8
     * @param args
     */
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node3 = new TreeNode(3);
        TreeNode node5 = new TreeNode(5);
        TreeNode node7 = new TreeNode(7);
        TreeNode node8 = new TreeNode(8);
        node1.left = node3;
        node1.right = node5;
        node3.left = node7;
        node3.right = node8;
        System.out.println(TreeDepth2(node1));
    }
}
