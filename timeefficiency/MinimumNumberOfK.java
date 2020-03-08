package timeefficiency;

import java.util.*;

/**
 * 输入n个整数，找出其中最小的K个数。
 * 例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
 *
 * @ClassName: MinimumNumberOfK
 * @description: 最小的K个数
 * @author: yyh
 * @create: 2020-03-08 10:41
 **/
public class MinimumNumberOfK {

    /**
     * my result (once pass): 利用TreeMap排序特性，空间换时间
     * 时间复杂度: O(n)
     * 空间复杂度: O(n)
     * @param input
     * @param k
     * @return
     */
    private static ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> result = new ArrayList<>();
        if(k <= 0 || k > input.length){
            return result;
        }
        Map<Integer,Integer> map = new TreeMap<>();
        for (int val : input){
            map.put(val,map.getOrDefault(val,0) + 1);
        }
        for (Map.Entry<Integer,Integer> entry : map.entrySet()){
            int val = entry.getKey();
            int count = entry.getValue();
            if(k > 0){
                //有重复的数据则全部添加
                for (int i = 0; i < count && i < k ; i++) {
                    result.add(val);
                }
                k -= count;
            }else {
                break;
            }
        }
        return result;
    }

    /**
     * other:用最大堆（优先队列）保存这k个数，每次只和堆顶比，如果比堆顶小，删除堆顶，新数入堆。
     * @param input
     * @param k
     * @return
     */
    private static ArrayList<Integer> GetLeastNumbers_Solution2(int [] input, int k) {
        ArrayList<Integer> arr = new ArrayList<>();
        if(k <= 0 || k > input.length){
            return arr;
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(k, Comparator.reverseOrder());
        for (int value : input) {
            if (pq.size() != k) {
                //添加错误返回false而不是抛出异常，这比add抛出异常不一样
                pq.offer(value);
            } else if (value < pq.peek()) {
                pq.poll();
                pq.offer(value);
            }
        }
        //按顺序优化
        while (pq.size() > 0) {
            arr.add(0, pq.poll());
        }
        return arr;
    }


    public static void main(String[] args) {
        int[] input = {4,5,1,6,2,7,3,8,1};
        ArrayList<Integer> list = GetLeastNumbers_Solution2(input, 5);
        list.forEach(val-> System.out.print(val + "\t"));
    }
}
