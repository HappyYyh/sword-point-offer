package sort;

import java.util.Arrays;

/**
 * @ClassName: QuickSort
 * @description: 快速排序
 * @author: yyh
 * @create: 2020-03-21 17:25
 **/
public class QuickSort {

    /**
     * 快速排序：以第一个元素为基准值
     *
     * @param array
     * @param low
     * @param high
     */
    private static void quickSort(int[] array, int low, int high) {
        if (low > high) {
            return;
        }
        int left = low;
        int right = high;
        // 中轴值
        int pivot = array[low];
        while (left < right) {
            // 从右边找比基准值小的
            while (left < right && array[right] >= pivot) {
                right--;
            }
            // 从左边找比基准值大的
            while (left < right && array[left] <= pivot) {
                left++;
            }
            if (left < right) {
                int tmp = array[left];
                array[left] = array[right];
                array[right] = tmp;
            }
        }
        // 当左右指针相遇时重新调整基准值
        int tmp = array[left];
        array[left] = array[low];
        array[low] = tmp;
        quickSort(array, low, left - 1);
        quickSort(array, left + 1, high);
    }

    /**
     * 快速排序：以中间值为基准
     *
     * @param array
     * @param low
     * @param high
     */
    private static void quickSort2(int[] array, int low, int high) {
        int left = low;
        int right = high;
        int mix = array[(low + high) / 2];
        int tmp;
        while (left < right) {
            while (array[left] < mix) {
                left++;
            }
            while (array[right] > mix) {
                right--;
            }
            if (left >= right) {
                break;
            }
            tmp = array[right];
            array[right] = array[left];
            array[left] = tmp;
            if (array[left] == mix) {
                right--;
            }
            if (array[right] == mix) {
                left++;
            }
        }
        if (left == right) {
            left++;
            right--;
        }
        if (low < right) {
            quickSort2(array, low, left - 1);
        }
        if (high > left) {
            quickSort2(array, right + 1, high);
        }
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        int[] array = {4, 3, 5, 2, 1};
        System.out.println("排序前顺序：" + Arrays.toString(array));
        quickSort2(array, 0, array.length - 1);
        System.out.println("排序后顺序：" + Arrays.toString(array));
    }
}
