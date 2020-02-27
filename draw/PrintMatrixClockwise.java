package draw;

import java.util.ArrayList;

/**
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，例
 * 如，如果输入如下4 X 4矩阵：
 * 1 2 3 4
 * 5 6 7 8
 * 9 10 11 12
 * 13 14 15 16
 * 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 * All rights Reserved, Designed By yyh
 * 顺时针打印矩阵
 * @Package draw
 * @author: yyh
 * @date: 2020-02-27 10:15
 * @since V1.0.0-SNAPSHOT
 */
public class PrintMatrixClockwise {

    /**
     * other:
     * 不断地收缩矩阵的边界
     * 定义四个变量代表范围，up、down、left、right
     *
     * 向右走存入整行的值，当存入后，该行再也不会被遍历，代表上边界的 up 加一，同时判断是否和代表下边界的 down 交错
     * 向下走存入整列的值，当存入后，该列再也不会被遍历，代表右边界的 right 减一，同时判断是否和代表左边界的 left 交错
     * 向左走存入整行的值，当存入后，该行再也不会被遍历，代表下边界的 down 减一，同时判断是否和代表上边界的 up 交错
     * 向上走存入整列的值，当存入后，该列再也不会被遍历，代表左边界的 left 加一，同时判断是否和代表右边界的 right 交错
     *
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     * @param matrix
     * @return
     */
    private static ArrayList<Integer> printMatrix(int [][] matrix) {
        ArrayList<Integer> list = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return list;
        }
        int up = 0;
        int down = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;
        while (true) {
            // 最上面一行
            for (int col = left; col <= right; col++) {
                list.add(matrix[up][col]);
            }
            // 向下逼近
            up++;
            // 判断是否越界
            if (up > down) {
                break;
            }
            // 最右边一行
            for (int row = up; row <= down; row++) {
                list.add(matrix[row][right]);
            }
            // 向左逼近
            right--;
            // 判断是否越界
            if (left > right) {
                break;
            }
            // 最下面一行
            for (int col = right; col >= left; col--) {
                list.add(matrix[down][col]);
            }
            // 向上逼近
            down--;
            // 判断是否越界
            if (up > down) {
                break;
            }
            // 最左边一行
            for (int row = down; row >= up; row--) {
                list.add(matrix[row][left]);
            }
            // 向右逼近
            left++;
            // 判断是否越界
            if (left > right) {
                break;
            }
        }
        return list;
    }

    public static void main(String[] args) {
        // 1 2 3 6 9 8 7 4 5
        int[][] matrix = {
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };
        // 1 2 3 4 8 12 16 15 14 13 9 5 6 7 11 10
        int[][] matrix2 = {
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12},
                {13,14,15,16}
        };
        ArrayList<Integer> res1 = printMatrix(matrix);
        ArrayList<Integer> res2 = printMatrix(matrix2);
        res1.forEach(x-> System.out.print(x+"\t"));
        System.out.println("\n---我是分隔符---");
        res2.forEach(x-> System.out.print(x+"\t"));
    }
}
