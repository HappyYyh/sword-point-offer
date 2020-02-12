package stackandqueue;

import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * 给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。
 * 例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，那么一共存在6个滑动窗口，
 * 他们的最大值分别为{4,4,6,6,6,5}；
 * 针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个：
 * {[2,3,4],2,6,2,5,1}，
 * {2,[3,4,2],6,2,5,1}，
 * {2,3,[4,2,6],2,5,1}，
 * {2,3,4,[2,6,2],5,1}，
 * {2,3,4,2,[6,2,5],1}，
 * {2,3,4,2,6,[2,5,1]}。
 * @ClassName: MaxValueOfSlidingWindow
 * @description: 滑动窗口的最大值
 * @author: yyh
 * @create: 2020-02-12 10:26
 **/
public class MaxValueOfSlidingWindow {

    /**
     * my result : 迭代
     * 时间复杂度：O(n * m) n为num大小，m为size大小
     * @param num
     * @param size
     * @return
     */
    private static ArrayList<Integer> maxInWindows(int [] num, int size) {
        ArrayList<Integer> list = new ArrayList<>();
        if(size == 0){
            return list;
        }
        for (int i = 0; i <= num.length - size ; i++) {
            int max = 0;
            for (int j = i; j < i + size ; j++) {
                if(num[j] > max) {
                    max = num[j];
                }
            }
            list.add(max);
        }
        return list;
    }

    /**
     * other:利用优先队列
     * @param num
     * @param size
     * @return
     */
    private static ArrayList<Integer> maxInWindows2(int[] num, int size) {
        ArrayList<Integer> ret = new ArrayList<>();
        if (size > num.length || size < 1) {
            return ret;
        }
        /* 大顶堆 */
        PriorityQueue<Integer> heap = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int i = 0; i < size; i++) {
            //第一个滑动窗口
            heap.add(num[i]);
        }
        ret.add(heap.peek());
        for (int i = 0, j = i + size; j < num.length; i++, j++) {
            /* 维护一个大小为 size 的大顶堆 */
            // i为上一个窗口的startIndex  j为本次窗口的endIndex
            // 总环次数为窗口数
            // 删除、进入模拟滑动过程
            // 删除操作 O(log(size))
            heap.remove(num[i]);
            // 入堆操纵 O(log(size))
            heap.add(num[j]);
            // 取栈顶，为最大值
            ret.add(heap.peek());
        }
        return ret;
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = maxInWindows2(new int[]{2, 3, 4, 2, 6, 2, 5, 1}, 3);
        list.forEach(System.out::print);
    }
}
