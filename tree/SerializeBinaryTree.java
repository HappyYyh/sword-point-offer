package tree;


/**
 * 请实现两个函数，分别用来序列化和反序列化二叉树
 *
 * 1、二叉树的序列化是指：把一棵二叉树按照某种遍历方式的结果以某种格式保存为字符串，
 * 从而使得内存中建立起来的二叉树可以持久保存。
 * 序列化可以基于先序、中序、后序、层序的二叉树遍历方式来进行修改，序列化的结果是一个字符串，
 * 序列化时通过 某种符号表示空节点（#），以 ！ 表示一个结点值的结束（value!）。
 *
 * 2、二叉树的反序列化是指：根据某种遍历顺序得到的序列化字符串结果str，重构二叉树。
 *
 * @ClassName: SerializeBinaryTree
 * @description: 序列化二叉树
 * @author: yyh
 * @create: 2020-02-08 11:20
 **/
public class SerializeBinaryTree {

    /**
     * 用于反序列化是记录字符索引
     */
    private static int index = -1;

    /**
     * 分别遍历左节点和右节点，空使用#代替，节点之间，隔开
     *
     * @param root
     * @return
     */
    private static String Serialize(TreeNode root) {
        if(root == null){
            return "#";
        }
        StringBuilder sb = new StringBuilder();
        SerializeHelper(root,sb);
        return sb.toString();
    }

    /**
     * 根据前序遍历进行序列化
     * @param root
     * @param sb
     */
    private static void SerializeHelper(TreeNode root,StringBuilder sb) {
        if(root == null){
            sb.append("#").append(",");
            return;
        }
        sb.append(root.val).append(",");
        SerializeHelper(root.left, sb);
        SerializeHelper(root.right,sb);
    }


    /**
     * 分割字符串
     *
     * @param str
     * @return
     */
    private static TreeNode Deserialize(String str) {
        //将序列化之后的序列用，分隔符转化为数组
        String[] s = str.split(",");
        return DeserializeHelper(s);
    }

    /**
     * 使用index来设置树节点的val值，递归遍历左节点和右节点（前面是前序遍历，所以这里也是按照前序遍历），
     * 如果值是#则表示是空节点，直接返回
     * @param s
     * @return
     */
    private static TreeNode DeserializeHelper(String[] s){
        //索引每次加一
        index++;
        int len = s.length;
        if (index > len) {
            return null;
        }
        TreeNode treeNode = null;
        if (!"#".equals(s[index])) {
            //不是叶子节点 继续走 是叶子节点出递归
            treeNode = new TreeNode(Integer.parseInt(s[index]));
            treeNode.left = DeserializeHelper(s);
            treeNode.right = DeserializeHelper(s);
        }
        return treeNode;
    }

    /**
     *       1
     *      / \
     *     2   3
     *    /\   /\
     *   4      7
     *   前序遍历 ： 1 2 4 # 3 # 7
     *
     * @param args
     */
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node7 = new TreeNode(7);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node3.right = node7;
        String serialize = Serialize(null);
        System.out.println(serialize);
        TreeNode treeNode = Deserialize(serialize);
        TreeNode.pre(treeNode);
    }
}
