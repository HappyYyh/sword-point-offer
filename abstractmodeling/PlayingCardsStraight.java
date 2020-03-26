package abstractmodeling;

import java.util.TreeMap;
import java.util.TreeSet;

/**
 * LL今天心情特别好,因为他去买了一副扑克牌,发现里面居然有2个大王,2个小王(一副牌原本是54张^_^)...
 * 他随机从中抽出了5张牌,想测测自己的手气,看看能不能抽到顺子,如果抽到的话,他决定去买体育彩票,嘿嘿！！
 * “红心A,黑桃3,小王,大王,方片5”,“Oh My God!”不是顺子.....LL不高兴了,他想了想,
 * 决定大\小 王可以看成任何数字,并且A看作1,J为11,Q为12,K为13。
 * 上面的5张牌就可以变成“1,2,3,4,5”(大小王分别看作2和4),“So Lucky!”。
 * LL决定去买体育彩票啦。
 * 现在,要求你使用这幅牌模拟上面的过程,然后告诉我们LL的运气如何，
 * 如果牌能组成顺子就输出true，否则就输出false。为了方便起见,你可以认为大小王是0。
 *
 * All rights Reserved, Designed By yyh
 * 扑克牌顺子
 * @Package abstractmodeling
 * @author: yyh
 * @date: 2020-03-26 10:36
 * @since V1.0.0-SNAPSHOT
 */
public class PlayingCardsStraight {

    /**
     * my result(once pass) : 利用treeMap进行排序、过滤
     * @param numbers
     * @return
     */
    private static boolean isContinuous(int [] numbers) {
        if(numbers.length != 5){
            return false;
        }
        TreeMap<Integer,Integer> map = new TreeMap<>();
        int king = 0;
        for (int num : numbers){
            if(num == 0){
                king ++ ;
                continue;
            }
            // 如果有重复肯定不满足顺子条件
            if(map.containsKey(num)){
                return false;
            }
            map.put(num,1);
        }
        // 如果有4张王肯定可以变成顺子
        if(king == 4){
            return true;
        }else{
            Integer firstKey = map.firstKey();
            Integer lastKey = map.lastKey();
            return lastKey - firstKey < 5;
        }
    }

    /**
     * my result : 上一题的改进；非重复情况下，只要满足首尾差5即为顺子
     * @param numbers
     * @return
     */
    private static boolean isContinuous2(int [] numbers) {
        if(numbers.length != 5){
            return false;
        }
        TreeSet<Integer> set = new TreeSet<>();
        for (int num : numbers){
            if(num == 0){
                continue;
            }
            // 如果有重复肯定不满足顺子条件
            if(set.contains(num)){
                return false;
            }
            set.add(num);
        }
        return set.last() - set.first() < 5;
    }

    /**
     * my result : 借助数组去重
     * @param numbers
     * @return
     */
    private static boolean isContinuous3(int [] numbers) {
        if(numbers.length != 5){
            return false;
        }
        int[] tmp = new int[14];
        int min = 14;
        int max = -1;
        for (int num : numbers){
            if(num == 0){
                continue;
            }
            // 借助数组去重
            if(tmp[num] > 0){
                return false;
            }else {
                tmp[num] = 1;
            }
            if(num > max){
                max = num;
            }
            if(num < min ){
                min = num;
            }
        }
        return max - min < 5;
    }

    /**
     *  大王/小王 A 2 3 4 5 6 7 8 9 10 J  Q  K
     *      0    1 2 3 4 5 6 7 8 9 10 11 12 13
     * @param args
     */
    public static void main(String[] args) {
        int[] numbers = {0,0,0,0,5};
        System.out.println(isContinuous3(numbers));
    }
}
