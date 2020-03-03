package example;

import java.util.ArrayList;

/**
 * 输入一颗二叉树的根节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
 * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 * (注意: 在返回值的list中，数组长度大的数组靠前)
 * 
 * All rights Reserved, Designed By yyh
 * 二叉树中和为某一值的路径
 * @Package example
 * @author: yyh
 * @date: 2020-03-03 10:16
 * @since V1.0.0-SNAPSHOT
 */
public class PathSumOfBinaryTree {

    private static class TreeNode{
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
        public TreeNode(int val) {
            this.val = val;
        }
    }

    private static ArrayList<ArrayList<Integer>> result = new ArrayList<>();

    /**
     * my result :递归
     * @param root
     * @param target
     * @return
     */
    private static ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        if(root == null){
            return result;
        }
        find(new ArrayList<>(),root,0,target);
        //这里可以优化，可以在添加的时候进行大小判断,即用其他的数据结构
        result.sort((o1, o2) -> o2.size() - o1.size());
        return result;
    }

    /**
     * 递归添加
     * @param list   包含之前路径的list
     * @param root   树
     * @param sum    已走过路径之和
     * @param target 目标值
     */
    private static void find(ArrayList<Integer> list,TreeNode root,int sum,int target){
        sum += root.val;
        list.add(root.val);
        //当sum == target并且tree为叶子节点时满足 路径条件
        if(sum == target && root.left == null && root.right == null){
            result.add(list);
        }else {
            if(root.left != null){
                //创建一个临时list，把之前的路径添加进去
                ArrayList<Integer> tmp = new ArrayList<>(list);
                find(tmp,root.left,sum,target);
            }
            if(root.right != null){
                ArrayList<Integer> tmp = new ArrayList<>(list);
                find(tmp,root.right,sum,target);
            }
        }
    }

    /**
     *       1
     *      /\
     *     3  10
     *    /\  \
     *   6 7   2
     *   target = 11 ,路径两条 [1->3->7,1->10]
     * @param args
     */
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(10);
        TreeNode node4 = new TreeNode(6);
        TreeNode node5 = new TreeNode(7);
        TreeNode node6 = new TreeNode(2);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.right = node6;
        ArrayList<ArrayList<Integer>> arrayLists = FindPath(node1, 11);
        for (ArrayList<Integer> list : arrayLists){
            list.forEach(x->System.out.print(x+"\t"));
            System.out.println();
        }
    }
}
