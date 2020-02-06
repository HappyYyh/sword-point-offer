package tree;

import java.util.ArrayList;
import java.util.Collections;

/**
 * 请实现一个函数按照之字形打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右至左的顺序打印，
 * 第三行按照从左到右的顺序打印，其他行以此类推。
 * @ClassName: PrintBinaryTree
 * @description: 按之字形顺序打印二叉树
 * @author: yyh
 * @create: 2020-02-06 10:19
 **/
public class PrintBinaryTree {

    /**
     * my result (once pass):DFS,递归的把结果放入list中，遍历完成后根据奇偶层数进行倒置
     * @param pRoot
     * @return
     */
    private static ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
        put(pRoot,0,lists);
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        for (int i = 0; i < lists.size() ; i++) {
            if(i % 2 == 0 ){
                result.add(lists.get(i));
            }else {
                ArrayList<Integer> list = lists.get(i);
                Collections.reverse(list);
//                ArrayList<Integer> reverse = new ArrayList<>();
//                for (int j = list.size() -1 ; j >=0 ; j--) {
//                    reverse.add(list.get(j));
//                }
                result.add(list);
            }
        }
        return result;
    }

    private static void put(TreeNode node,int level,ArrayList<ArrayList<Integer>> lists){
        if (node == null) {
            return;
        }
        if (level >= lists.size()) {
            lists.add(new ArrayList<>());
        }
        lists.get(level).add(node.val);
        put(node.left, level + 1, lists);
        put(node.right, level + 1, lists);
    }

    /**
     *       1
     *      / \
     *     2   3
     *    /\   /\
     *   4 5  6  7
     *   打印结果为
     *   [
     *    [1],
     *    [3,2]
     *    [4,5,6,7]
     *   ]
     * @param args
     */
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
        ArrayList<ArrayList<Integer>> lists = Print(node1);
        for (ArrayList<Integer> list : lists){
            for (int val : list){
                System.out.print(val+"\t");
            }
            System.out.println();
        }
    }
}
