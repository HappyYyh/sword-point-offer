package coderobustness;


/**
 * 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 * @ClassName: SubstructureOfTree
 * @description: 树的子结构
 * @author: yyh
 * @create: 2020-02-25 10:05
 **/
public class SubstructureOfTree {

    /**
     * other：递归
     *
     * @param root1
     * @param root2
     * @return
     */
    private static boolean HasSubtree(TreeNode root1, TreeNode root2) {
        if(root1 == null || root2 == null){
            return false;
        }
        //拿本身，左子树，右子树和root2比，满足一个即可
        return judgeSubTree(root1, root2) ||
                judgeSubTree(root1.left, root2) ||
                judgeSubTree(root1.right, root2);
    }

    /**
     * 判断两者是否相同的结构
     * @param root1
     * @param root2
     * @return
     */
    private static boolean judgeSubTree(TreeNode root1, TreeNode root2) {
        if (root2 == null) {
            return true;
        }
        if (root1 == null) {
            return false;
        }
        if (root1.val != root2.val) {
            return judgeSubTree(root1.left, root2) ||
                    judgeSubTree(root1.right, root2);
        }
        //当root的val相同时，递归比较
        return judgeSubTree(root1.left, root2.left) &&
                judgeSubTree(root1.right, root2.right);
    }

    /**
     *     A           B
     *     1           3
     *    / \         /\
     *   3   5       7  9
     *  /\
     * 7 9
     * @param args
     */
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        node1.left = new TreeNode(3);
        node1.right = new TreeNode(5);
        node1.left.left = new TreeNode(7);
        node1.left.right = new TreeNode(9);
        TreeNode node2 = new TreeNode(3);
        node2.left = new TreeNode(7);
        node2.right = new TreeNode(9);

        System.out.println(HasSubtree(node1,node2));
    }
}
