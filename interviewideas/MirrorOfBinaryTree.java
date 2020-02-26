package interviewideas;

import java.util.Stack;

/**
 * 操作给定的二叉树，将其变换为源二叉树的镜像。
 * 二叉树的镜像定义：
 *        源二叉树
 *     	    8
 *     	   /  \
 *     	  6   10
 *     	 / \  / \
 *     	5  7 9 11
 *     	镜像二叉树
 *     	    8
 *     	   /  \
 *     	  10   6
 *     	 / \  / \
 *     	11 9 7  5
 * @ClassName: MirrorOfBinaryTree
 * @description: 二叉树的镜像
 * @author: yyh
 * @create: 2020-02-26 10:24
 **/
public class MirrorOfBinaryTree {

    /**
     * my result(once pass) :递归交换左右子树
     * @param root
     */
    private static void Mirror(TreeNode root) {
        if(root == null){
            return;
        }
        swap(root);
    }

    /**
     * 递归交换（这个可以合并到上面方法去）
     * @param root
     */
    private static void swap(TreeNode root){
        if(root.left == null && root.right == null){
            return;
        }
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        if(root.left != null) {
            swap(root.left);
        }
        if(root.right != null) {
            swap(root.right);
        }
    }

    /**
     * 上面的代码简化版
     * @param root
     */
    private static void Mirror2(TreeNode root) {
        if(root == null){
            return;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        Mirror2(root.left);
        Mirror2(root.right);
    }


    /**
     * other:手动压栈
     * @param root
     */
    public void Mirror3(TreeNode root) {
        // 空树
        if (root == null) {
            return;
        }
        // 左右均为空
        if (root.left == null && root.right == null) {
            return;
        }
        // 用来遍历的栈
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        TreeNode curNode;
        TreeNode tempNode;
        // 深度优先
        while (!stack.isEmpty()) {
            curNode = stack.pop();
            if(curNode == null) {
                continue;
            }
            if(curNode.left == null && curNode.right==null) {
                continue;
            }
            // 交换
            tempNode = curNode.left;
            curNode.left = curNode.right;
            curNode.right = tempNode;
            stack.push(curNode.left);
            stack.push(curNode.right);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(8);
        TreeNode node1 = new TreeNode(6);
        TreeNode node2 = new TreeNode(10);
        TreeNode node3 = new TreeNode(5);
        TreeNode node4 = new TreeNode(7);
        TreeNode node5 = new TreeNode(9);
        TreeNode node6 = new TreeNode(11);
        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;
        node2.left = node5;
        node2.right = node6;
        TreeNode.infix(root);
        Mirror2(root);
        System.out.println();
        TreeNode.infix(root);
    }

}
