package timeefficiency;

import java.util.HashMap;

/**
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。
 * 由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
 *
 * @ClassName: AppearMoreThanHalf
 * @description: 数组中出现次数超过一半的数字
 * @author: yyh
 * @create: 2020-03-07 10:39
 **/
public class AppearMoreThanHalf {

    /**
     * my result(once pass) : 空间换时间，利用hash表
     * 时间复杂度:O(n)
     * 空间复杂度:O(n)
     * @param array
     * @return
     */
    private static int MoreThanHalfNum_Solution(int [] array) {
        if(array == null || array.length == 0){
            return 0;
        }
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int val : array) {
            map.put(val,map.getOrDefault(val,0) + 1);
        }
        int res = 0;
        for (int key : map.keySet()){
            if(map.get(key) > array.length / 2 ){
                return key;
            }
        }
        return res;
    }

    /**
     * other:两次遍历，第一次遍历记录出现次数较多的值，第二次遍历判断该值是否超过一半
     * 时间复杂度:O(n)
     * 空间复杂度:O(1)
     * @param array
     * @return
     */
    private static int MoreThanHalfNum_Solution2(int [] array) {
        if(array == null || array.length == 0){
            return 0;
        }
        int preVal = array[0];
        int count = 1;
        for (int i = 1; i < array.length ; i++) {
            if(array[i] == preVal){
                count++;
            }else {
                count--;
                if(count == 0){
                    //count==0的时候就需要更新值，因为如果存在超过数组长度一半的值，那么最后preValue一定会是该值。
                    preVal = array[i];
                    count = 1;
                }
            }
        }
        //需要判断是否真的是大于一半数
        int num = 0;
        for (int value : array) {
            if (value == preVal) {
                num++;
            }
        }
        return (num > array.length / 2) ? preVal : 0;
    }

    /**
     * leetcode169:投票法
     * @param array
     * @return
     */
    private static int MoreThanHalfNum_Solution3(int [] array) {
        int count = 0;
        int candidate = 0;
        for (int num : array) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }
        return candidate;
    }

    public static void main(String[] args) {
        int[] array = {1,2,3,2,2,2,5,4,2};
        System.out.println(MoreThanHalfNum_Solution3(array));
    }
}
