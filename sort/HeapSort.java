package sort;

import java.util.Arrays;

/**
 * All rights Reserved, Designed By yyh
 * 堆排序
 *
 * @Package sort
 * @author: yyh
 * @date: 2020-03-23 13:43
 * @since V1.0.0-SNAPSHOT
 */
public class HeapSort {

    /**
     * 堆排序：构建大顶堆
     *
     * @param array
     */
    private static void headSort(int[] array) {
        for (int i = array.length - 1; i > 0; i--) {
            maxHeapify(array, i);
            //堆顶元素(第一个元素)与Kn交换
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;
        }
    }

    /***
     *
     *  将数组堆化
     *  i = 第一个非叶子节点。
     *  从第一个非叶子节点开始即可。无需从最后一个叶子节点开始。
     *  叶子节点可以看作已符合堆要求的节点，根节点就是它自己且自己以下值为最大。
     *
     * @param array
     * @param n
     */
    public static void maxHeapify(int[] array, int n) {
        int child;
        for (int i = (n - 1) / 2; i >= 0; i--) {
            //左子节点位置
            child = 2 * i + 1;
            //右子节点存在且大于左子节点，child变成右子节点
            if (child != n && array[child] < array[child + 1]) {
                child++;
            }
            //交换父节点与左右子节点中的最大值
            if (array[i] < array[child]) {
                int temp = array[i];
                array[i] = array[child];
                array[child] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[] array = {4, 3, 5, 2, 1};
        System.out.println("排序前顺序：" + Arrays.toString(array));
        headSort(array);
        System.out.println("排序后顺序：" + Arrays.toString(array));
    }
}
