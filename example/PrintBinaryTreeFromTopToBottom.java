package example;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 * @ClassName: PrintBinaryTreeFromTopToBottom
 * @description: 从上往下打印二叉树
 * @author: yyh
 * @create: 2020-03-01 11:23
 **/
public class PrintBinaryTreeFromTopToBottom {

    private static class TreeNode{
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
        public TreeNode(int val) {
            this.val = val;
        }
    }

    /**
     * my result(once pass)：利用queue进行广度优先遍历
     * (对于queue的理解还不是很到位)
     * @param root
     * @return
     */
    private static ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            TreeNode poll = queue.poll();
            result.add(poll.val);
            if(poll.left != null) {
                queue.add(poll.left);
            }
            if(poll.right != null) {
                queue.add(poll.right);
            }
        }
        return result;
    }

    /**
     *       1
     *      /\
     *     3  5
     *    /\  \
     *   6 7   8
     *  打印顺序为：1，3，5，6，7，8
     * @param args
     */
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(5);
        TreeNode node4 = new TreeNode(6);
        TreeNode node5 = new TreeNode(7);
        TreeNode node6 = new TreeNode(8);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.right = node6;
        ArrayList<Integer> list = PrintFromTopToBottom(node1);
        list.forEach(x->System.out.print(x+"\t"));
    }
}
