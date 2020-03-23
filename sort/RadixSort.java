package sort;

import java.util.Arrays;

/**
 * All rights Reserved, Designed By yyh
 *
 * @Package sort
 * @author: yyh
 * @date: 2020-03-23 16:26
 * @since V1.0.0-SNAPSHOT
 */
public class RadixSort {

    /**
     * 基数排序
     * @param array
     */
    public static void radixSort(int[] array) {
        if (array.length <= 1) {
            return;
        }
        //取得数组中的最大数，并取得位数
        int max = 0;
        for (int value : array) {
            if (max < value) {
                max = value;
            }
        }
        int maxDigit = 1;
        while (max / 10 > 0) {
            maxDigit++;
            max = max / 10;
        }
        //申请一个桶空间
        int[][] buckets = new int[10][array.length];
        int base = 10;

        //从低位到高位，对每一位遍历，将所有元素分配到桶中
        for (int i = 0; i < maxDigit; i++) {
            //存储各个桶中存储元素的数量
            int[] bktLen = new int[10];
            //分配：将所有元素分配到桶中
            for (int value : array) {
                int whichBucket = (value % base) / (base / 10);
                buckets[whichBucket][bktLen[whichBucket]] = value;
                bktLen[whichBucket]++;
            }
            //收集：将不同桶里数据挨个捞出来,为下一轮高位排序做准备,由于靠近桶底的元素排名靠前,因此从桶底先捞
            int k = 0;
            for (int b = 0; b < buckets.length; b++) {
                for (int p = 0; p < bktLen[b]; p++) {
                    array[k++] = buckets[b][p];
                }
            }
            base *= 10;
        }
    }

    public static void main(String[] args) {
        int[] array = {4, 3, 5, 2, 1};
        System.out.println("排序前顺序：" + Arrays.toString(array));
        radixSort(array);
        System.out.println("排序后顺序：" + Arrays.toString(array));
    }
}
