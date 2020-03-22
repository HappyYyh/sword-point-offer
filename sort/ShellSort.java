package sort;

import java.util.Arrays;

/**
 * @ClassName: ShellSort
 * @description: 希尔排序
 * @author: yyh
 * @create: 2020-03-22 11:36
 **/
public class ShellSort {

    /**
     * 希尔排序：交换法
     *
     * @param array
     */
    private static void shellSort(int[] array) {
        int tmp;
        for (int gap = array.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < array.length; i++) {
                // 遍历各组中所有的元素(共 gap 组，每组有个元素), 步长 gap
                for (int j = i - gap; j >= 0; j -= gap) {
                    // 如果当前元素大于加上步长后的那个元素，说明交换
                    if (array[j] > array[j + gap]) {
                        tmp = array[j];
                        array[j] = array[j + gap];
                        array[j + gap] = tmp;
                    }
                }
            }
        }
    }

    /**
     * 希尔排序：移位法
     *
     * @param array
     */
    private static void shellSort2(int[] array) {
        // 增量 gap, 并逐步的缩小增量
        for (int gap = array.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < array.length; i++) {
                int j = i;
                int tmp = array[j];
                if (array[j] < array[j - gap]) {
                    while (j - gap >= 0 && tmp < array[j - gap]) {
                        //移动
                        array[j] = array[j - gap];
                        j -= gap;
                    }
                    //当退出 while 后，就给 tmp 找到插入的位置
                    array[j] = tmp;
                }
            }
        }
    }

    /**
     * 《算法》中给出的步长选择策略
     * @param a
     */
    private static void shellSort3(int[] a) {
        int length = a.length;
        int gap = 1;
        while (gap < length / 3) {
            gap = 3 * gap + 1;
        }
        for (; gap >= 1; gap /= 3) {
            for (int i = 0; i < a.length - gap; i += gap) {
                for (int j = i + gap; j > 0; j -= gap) {
                    if (a[j] < a[j - gap]) {
                        int temp = a[j];
                        a[j] = a[j - gap];
                        a[j - gap] = temp;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] array = {8, 9, 1, 7, 2, 3, 5, 4, 6, 0};
        System.out.println("排序前顺序：" + Arrays.toString(array));
        shellSort3(array);
        System.out.println("排序后顺序：" + Arrays.toString(array));
    }
}
