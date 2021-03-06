package knowledge;

import java.util.ArrayList;

/**
 * 小明很喜欢数学,有一天他在做数学作业时,要求计算出9~16的和,他马上就写出了正确答案是100。但
 * 是他并不满足于此,他在想究竟有多少种连续的正数序列的和为100(至少包括两个数)。
 * 没多久,他就得到另一组连续正数和为100的序列:18,19,20,21,22。
 * 现在把问题交给你,你能不能也很快的找出所有和为S的连续正数序列? Good Luck!
 *
 * 输出所有和为S的连续正数序列。序列内按照从小至大的顺序，序列间按照开始数字从小到大的顺序
 *
 * All rights Reserved, Designed By yyh
 * 和为S的连续正数序列
 * @Package knowledge
 * @author: yyh
 * @date: 2020-03-20 9:53
 * @since V1.0.0-SNAPSHOT
 */
public class ContinuousSequence {

    /**
     * my result : 暴力计算
     * 时间复杂度 : O(n^2)
     * @param sum
     * @return
     */
    private static ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        for (int i = 1; i < sum ; i++) {
            ArrayList<Integer> list = new ArrayList<>();
            int tmp = 0;
            for (int j = i ; j < sum ; j++) {
                tmp += j;
                list.add(j);
                if(tmp == sum){
                    result.add(list);
                    break;
                }else if(tmp > sum){
                    break;
                }
            }
        }
        return result;
    }

    /**
     * other:双指针
     * 第一个指针从1开始，第二个指针从2开始 ，然后 比较两个指针中间的和与sum的大小
     * 如果小于sum则，右指针++，然后加上右指针
     * 如果等于则，存放结果，然后右指针++
     * 如果大于则减去左值针，左值针++
     * @param sum
     * @return
     */
    private static ArrayList<ArrayList<Integer>> FindContinuousSequence2(int sum) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if(sum <= 0){
            return result;
        }
        int left = 1;
        int right = 2;
        int sumVal = left + right;
        while (right < sum){
            if(sumVal < sum){
                sumVal += ++right ;
            }else if(sumVal > sum){
                sumVal -= left++;
            }else {
                ArrayList<Integer> list = new ArrayList<>();
                for (int i = left; i <= right ; i++) {
                    list.add(i);
                }
                result.add(list);
                sumVal += ++right;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> arrayLists = FindContinuousSequence2(3);
        if(arrayLists.size() == 0){
            return;
        }
        for (ArrayList<Integer> list : arrayLists){
            for (Integer val : list){
                System.out.print(val + "\t");
            }
            System.out.println();
        }
    }
}
