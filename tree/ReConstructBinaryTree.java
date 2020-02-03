package tree;

import java.util.Arrays;

/**
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 *
 * @ClassName: ReConstructBinaryTree
 * @description: 重建二叉树
 * @author: yyh
 * @create: 2020-02-03 10:30
 **/
public class ReConstructBinaryTree {

    /**
     * other
     * 根据前序和中序可以确定一个二叉树；
     * 前序的第一个是二叉树的根节点，在中序中找到该节点则 该节点左侧为一个二叉树，右侧为一个二叉树
     * 即题中 1为根节点 2,4,7（4,7,2）为左子树 3,5,6,8（5,3,8,6）为右子树
     * 然后递归，继续找相同节点
     * @param pre
     * @param in
     * @return
     */
    private static TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        if (pre.length == 0 || in.length == 0) {
            return null;
        }
        TreeNode node = new TreeNode(pre[0]);
        for (int i = 0; i < in.length; i++) {
            if (pre[0] == in[i]) {
                // 牛客网编译器貌似无法识别Arrays.copyOfRange方法，所以用System.arraycopy
                int[] leftPreTmp = new int[i];
                System.arraycopy(pre,1,leftPreTmp,0,i);
                int[] leftInTmp = new int[i];
                System.arraycopy(in,0,leftInTmp,0,i);
                node.left = reConstructBinaryTree(leftPreTmp,leftInTmp);
                int[] rightPreTmp = new int[in.length - i -1];
                System.arraycopy(pre,i+1,rightPreTmp,0,in.length - i -1);
                int[] rightInTmp = new int[in.length - i -1];
                System.arraycopy(in,i+1,rightInTmp,0,in.length - i -1);
                node.right = reConstructBinaryTree(rightPreTmp,rightInTmp);
                // 左子树，注意 copyOfRange 函数，左闭右开
                //node.left = reConstructBinaryTree(Arrays.copyOfRange(pre, 1, i + 1), Arrays.copyOfRange(in, 0, i));
                // 右子树，注意 copyOfRange 函数，左闭右开
                //node.right = reConstructBinaryTree(Arrays.copyOfRange(pre, i + 1, pre.length), Arrays.copyOfRange(in, i + 1, in.length));
            }
        }
        return node;
    }

    /**
     *      1
     *     / \
     *    2   3
     *   /    / \
     *  4    5   6
     *  \       /
     *   7     8
     * @param args
     */
    public static void main(String[] args) {
        int [] pre = {1,2,4,7,3,5,6,8};
        int [] in = {4,7,2,1,5,3,8,6};
        TreeNode node = reConstructBinaryTree(pre, in);
        TreeNode.pre(node);
        System.out.println();
        TreeNode.infix(node);
        System.out.println();
        TreeNode.hou(node);
    }

}
