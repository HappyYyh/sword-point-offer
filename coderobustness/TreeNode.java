package coderobustness;

/**
 * @ClassName: TreeNode
 * @description: 二叉树
 * @author: yyh
 * @create: 2020-02-03 10:47
 **/
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }

    /**
     * 前序遍历
     * @param node
     */
    public static void pre(TreeNode node){
        if(node == null){
            return;
        }
        System.out.print(node.val + "->");
        if(node.left != null){
            pre(node.left);
        }
        if(node.right != null){
            pre(node.right);
        }
    }

    /**
     * 中序遍历
     * @param node
     */
    public static void infix(TreeNode node){
        if(node == null){
            return;
        }
        if(node.left != null){
            infix(node.left);
        }
        System.out.print(node.val + "->");
        if(node.right != null){
            infix(node.right);
        }
    }

    /**
     * 后序遍历
     * @param node
     */
    public static void hou(TreeNode node){
        if(node == null){
            return;
        }
        if(node.left != null){
            hou(node.left);
        }
        if(node.right != null){
            hou(node.right);
        }
        System.out.print(node.val + "->");
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        TreeNode node8 = new TreeNode(8);
        node1.left= node2;
        node2.left = node4;
        node4.right = node7;
        node1.right = node3;
        node3.left = node5;
        node3.right = node6;
        node6.left = node8;
        pre(node1);
        System.out.println();
        infix(node1);
        System.out.println();
        hou(node1);
    }
}
