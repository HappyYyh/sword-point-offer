package sort;

import java.util.Arrays;

/**
 * All rights Reserved, Designed By yyh
 * 归并排序
 * @Package sort
 * @author: yyh
 * @date: 2020-03-23 15:53
 * @since V1.0.0-SNAPSHOT
 */
public class MergeSort {

    /**
     * 归并所需的辅助数组
     */
    private static int[] aux;

    /**
     * 归并排序
     * @param array
     */
    public static void mergeSort(int[] array) {
        //一次性分配空间
        aux = new int[array.length];
        decompose(array, 0, array.length - 1);
    }

    /**
     * 分解
     * @param array
     * @param low
     * @param high
     */
    public static void decompose(int[] array, int low, int high) {
        if (low >= high) {
            return;
        }
        int mid = (low + high) / 2;
        //将左半边排序
        decompose(array, low, mid);
        //将右半边排序
        decompose(array, mid + 1, high);
        merge(array, low, mid, high);
    }

    /**
     * 该方法先将所有元素复制到aux[]中，然后在归并会array[]中。方法咋归并时(第二个for循环)
     * 进行了4个条件判断：
     * - 左半边用尽(取右半边的元素)
     * - 右半边用尽(取左半边的元素)
     * - 右半边的当前元素小于左半边的当前元素(取右半边的元素)
     * - 右半边的当前元素大于等于左半边的当前元素(取左半边的元素)
     * @param array
     * @param low
     * @param mid
     * @param high
     */
    public static void merge(int[] array, int low, int mid, int high) {
        //将a[low..mid]和a[mid+1..high]归并
        int i = low, j = mid + 1;
        for (int k = low; k <= high; k++) {
            aux[k] = array[k];
        }
        for (int k = low; k <= high; k++) {
            if (i > mid) {
                array[k] = aux[j++];
            } else if (j > high) {
                array[k] = aux[i++];
            } else if (aux[j] < aux[i]) {
                array[k] = aux[j++];
            } else {
                array[k] = aux[i++];
            }
        }
    }

    public static void main(String[] args) {
        int[] array = {4, 3, 5, 2, 1};
        System.out.println("排序前顺序：" + Arrays.toString(array));
        mergeSort(array);
        System.out.println("排序后顺序：" + Arrays.toString(array));
    }
}
