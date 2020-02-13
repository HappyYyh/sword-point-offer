package findandsort;

import java.util.Arrays;

/**
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
 * NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 *
 * @ClassName: MinNumberInRotateArray
 * @description: 旋转数组的最小数字
 * @author: yyh
 * @create: 2020-02-13 09:27
 **/
public class MinNumberInRotateArray {

    /**
     * my result(once pass): 偷懒用法，直接排序
     * 时间复杂度：O(nlogn)
     * @param array
     * @return
     */
    private static int minNumberInRotateArray(int [] array) {
        if(array.length <= 0){
            return 0;
        }
        Arrays.sort(array);
        return array[0];
    }

    /**
     * my result(once pass) : 线性查找，由于旋转特性，所以遍历时出现 当前元素比之前的小，则为最小值
     * 时间复杂度：O(n)
     * @param array
     * @return
     */
    private static int minNumberInRotateArray2(int [] array) {
        if(array.length <= 0){
            return 0;
        }
        int min = array[0];
        for (int i = 1; i < array.length ; i++) {
            if(array[i] < array[i-1]){
                min = array[i];
                break;
            }
        }
        return min;
    }

    /**
     * 类似于二分查找
     * @param array
     * @return
     */
    private static int minNumberInRotateArray3(int [] array) {
        if(array.length <= 0){
            return 0;
        }
        int left = 0;
        int right = array.length - 1;
        while (left < right){
            // 如果没有旋转过，直接返回
            if (array[left] < array[right]) {
                return array[left];
            }
            // 取中间值
            int mid = (left + right) >> 1;
            // 如果中间值大于起始值，说明一直在递增
            if (array[mid] > array[left]) {
                left = mid + 1;
            } else if (array[mid] < array[right]) {
                // 如果是mid-1，则可能会错过最小值，因为找的就是最小值
                right = mid;
            } else {
                // 巧妙避免了offer书上说的坑点（1 0 1 1 1）
                left++;
            }
        }
        return array[left];
    }

    /**
     * 非递减 约等于 递增， 即会有重复数字
     * @param args
     */
    public static void main(String[] args) {
        int[] array = {2,3,4,5,1,2};
        System.out.println(minNumberInRotateArray3(array));
    }
}
