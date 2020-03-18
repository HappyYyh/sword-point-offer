package knowledge;

/**
 * 输入一棵二叉树，判断该二叉树是否是平衡二叉树。
 * 平衡二叉树（Balanced Binary Tree）具有以下性质：
 * 它是一棵空树或它的左右两个子树的高度差的绝对值不超过1，并且左右两个子树都是一棵平衡二叉树。
 
 * All rights Reserved, Designed By yyh
 * 平衡二叉树
 * @Package knowledge
 * @author: yyh
 * @date: 2020-03-18 10:40
 * @since V1.0.0-SNAPSHOT
 */
public class BalancedBinaryTree {

    private static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
        public TreeNode(int val) {
            this.val = val;
        }
    }

    /**
     * my result (once pass) : 利用上一题测出左右子树的深度，然后判断左右子树深度相差 <2
     * @param root
     * @return
     */
    private static boolean IsBalanced_Solution(TreeNode root) {
        if(root == null){
            return true;
        }
        return Math.abs(TreeDepth(root.left) - TreeDepth(root.right)) < 2;
    }

    private static int TreeDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        return Math.max(TreeDepth(root.left),TreeDepth(root.right)) + 1;
    }

    /**
     * other :和我的题解差不多
     * @param root
     * @return
     */
    private static boolean IsBalanced_Solution2(TreeNode root) {
        return depth(root) != -1;
    }

    private static int depth(TreeNode root){
        if(root == null) {
            return 0;
        }
        int left = depth(root.left);
        if(left == -1) {
            //如果发现子树不平衡之后就没有必要进行下面的高度的求解了
            return -1;
        }
        int right = depth(root.right);
        if(right == -1) {
            //如果发现子树不平衡之后就没有必要进行下面的高度的求解了
            return -1;
        }
        if(left - right <(-1) || left - right > 1) {
            return -1;
        } else {
            return 1+(Math.max(left, right));
        }
    }

    /**
     *     1
     *    / \
     *   3   5
     *  / \
     * 6  7
     */
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node3 = new TreeNode(3);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        node1.left = node3;
        node1.right = node5;
        node3.left = node6;
        node3.right = node7;
        System.out.println(IsBalanced_Solution(node1));
    }
}
