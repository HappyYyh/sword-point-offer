package example;

/**
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
 * 如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
 *
 * All rights Reserved, Designed By yyh
 * 二叉搜索树的后序遍历序列
 * @Package example
 * @author: yyh
 * @date: 2020-03-02 14:15
 * @since V1.0.0-SNAPSHOT
 */
public class PostOrderOfBinarySearchTree {

    private static boolean VerifySquenceOfBST(int [] sequence) {
        if(sequence.length == 0){
            return false;
        }
        return isBST(sequence,0,sequence.length-1);
    }

    /**
     * 判断序列是否是BST
     * @param seq   序列
     * @param start 起始位置
     * @param end   结束位置
     * @return
     */
    private static boolean isBST(int[] seq, int start, int end) {
        if (start >= end) {
            return true;
        }
        //最后一个
        int val = seq[end];
        //左右子树分割点
        int split = start;
        //通过for循环让split++
        for (; split < end && seq[split] < val; split++) ;
        //判断右子树是否有小于root的值，有就返回false
        for (int i = split; i < end; i++) {
            if (seq[i] < val) {
                return false;
            }
        }
        //递归左右子树判断
        return isBST(seq, start, split - 1) &&
                isBST(seq, split, end - 1);
    }

    /**
     *       7
     *      / \
     *     5   9
     *    /\  /\
     *   4 6 8 10
     *   其后序遍历结果为：4 6 5 8 10 9 7
     *   对于二叉搜索树，其根节点是后序序列的最后一个树
     *   [4 6 5] [8 10 9] 7
     *   [4 6] 5 ,[8 10] 9
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(VerifySquenceOfBST(new int[]{4,6,5,8,10,9,7}));
    }
}
