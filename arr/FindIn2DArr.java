package arr;

/**
 * 在一个二维数组中（每个一维数组的长度相同），
 * 每一行都按照从左到右递增的顺序排序，
 * 每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * All rights Reserved, Designed By yyh
 * 二维数组中的查找
 * @Package arr
 * @author: yyh
 * @date: 2020-01-08 19:29
 * @since V1.0.0-SNAPSHOT
 */
public class FindIn2DArr {

    /**
     * my result : 暴力查找，迭代每一个元素
     * 时间复杂度 : O(n^2)
     * @param target
     * @param array
     * @return
     */
    private static boolean Find(int target, int [][] array) {
        for (int[] arr : array){
            for (int val : arr){
                if(target == val){
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * other:把每一行看成递增数列，进行二分查找
     * 时间复杂度：O(n*logN)
     * @param array
     * @param target
     * @return
     */
    private static boolean Find2(int target,int [][] array) {
        for (int[] ints : array) {
            int low = 0;
            int high = ints.length - 1;
            while (low <= high) {
                int mid = (low + high) / 2;
                if (target > ints[mid]) {
                    low = mid + 1;
                } else if (target < ints[mid]) {
                    high = mid - 1;
                } else {
                    return true;
                }
            }
        }
        return false;
    }



    /**
     * other:思路
     * 矩阵是有序的，从左下角来看，向上数字递减，向右数字递增，
     * 因此从左下角开始查找，当要查找数字比左下角数字大时。右移
     * 要查找数字比左下角数字小时，上移
     * @param target
     * @param array
     * @return
     */
    private static boolean Find3(int target, int [][] array) {
        int rows = array.length;
        int cols = array[0].length;
        int i = rows - 1, j = 0;
        // 左下角开始查找
        while (i >= 0 && j < cols) {
            // 如果当前值比目标值大则往上找
            if (target < array[i][j]) {
                i--;
            } else if (target > array[i][j]) {
                // 如果当前值比目标值小则往右找
                j++;
            } else {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] arr = {
                {1,2,3},
                {2,4,5},
                {4,8,12}
        };
        System.out.println(Find2(5,arr));
    }
}
