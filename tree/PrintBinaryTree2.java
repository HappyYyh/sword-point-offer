package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
 * @ClassName: PrintBinaryTree2
 * @description: 把二叉树打印成多行
 * @author: yyh
 * @create: 2020-02-07 14:08
 **/
public class PrintBinaryTree2 {

    /**
     * 这题和上一题几乎一模一样
     * @param pRoot
     * @return
     */
    private static ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
        DFS(pRoot,0,lists);
        return lists;
    }

    private static void DFS(TreeNode node, int level, ArrayList<ArrayList<Integer>> lists){
        if (node == null) {
            return;
        }
        if (level >= lists.size()) {
            lists.add(new ArrayList<>());
        }
        lists.get(level).add(node.val);
        DFS(node.left, level + 1, lists);
        DFS(node.right, level + 1, lists);
    }

    /**
     * BFS：利用队列
     * @param pRoot
     * @return
     */
    private static ArrayList<ArrayList<Integer> > Print2(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (pRoot == null) {
            return res;
        }
        ArrayList<Integer> list;
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode cur;
        // 首先把根节点放入队列
        queue.offer(pRoot);
        while (!queue.isEmpty()) {
            list = new ArrayList<>();
            int size = queue.size();
            while (size > 0) {
                //让上一层的节点依次出队列
                cur = queue.poll();
                list.add(cur.val);
                // 从左至右放入队列
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
                size--;
            }
            res.add(list);
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        ArrayList<ArrayList<Integer>> lists = Print2(node1);
        for (ArrayList<Integer> list : lists){
            for (int val : list){
                System.out.print(val+"\t");
            }
            System.out.println();
        }
    }
}
