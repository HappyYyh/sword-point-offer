package timeefficiency;

import java.util.ArrayList;

/**
 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 * 例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
 *
 * All rights Reserved, Designed By yyh
 * 把数组排成最小的数
 * @Package timeefficiency
 * @author: yyh
 * @date: 2020-03-11 9:58
 * @since V1.0.0-SNAPSHOT
 */
public class ArrangeTheArrayToTheSmallestNumber {

    /**
     * my result : 先把数字按照首字母进行分组，然后对每一组进行排序
     * 时间复杂度：O(n^2)
     * 空间复杂度：O(K + n) ,k为桶的数量，9
     * @param numbers
     * @return
     */
    private static String PrintMinNumber(int [] numbers) {
        ArrayList<Integer>[] bucket = new ArrayList[9];
        // 按首位大小入桶
        for (int val : numbers){
            int index = String.valueOf(val).charAt(0) - '0';
            ArrayList<Integer> list = bucket[index - 1];
            if(list == null){
                bucket[index - 1] = new ArrayList<>();
                bucket[index - 1].add(val);
            }else {
                list.add(val);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (ArrayList<Integer> list :bucket){
            if(list != null) {
                findMin(sb, list);
            }
        }
        return sb.toString();
    }

    private static void findMin(StringBuilder sb,ArrayList<Integer> list){
        // 交换排序
        for (int i = 0; i < list.size() ; i++) {
            for (int j = i + 1; j < list.size() ; j++) {
                Long one = Long.parseLong(list.get(i) +"" + list.get(j));
                Long two = Long.parseLong(list.get(j) +"" + list.get(i));
                if(one > two){
                    Integer tmp = list.get(i);
                    list.set(i,list.get(j));
                    list.set(j,tmp);
                }
            }
        }
        for (Integer integer : list) {
            sb.append(integer);
        }
    }

    /**
     * other : 不需要分组，直接比较排序也可以
     * @param numbers
     * @return
     */
    private static String PrintMinNumber2(int [] numbers) {
        if(numbers == null || numbers.length == 0) {
            return "";
        }
        for(int i=0; i < numbers.length; i++){
            for(int j = i+1; j < numbers.length; j++){
                long sum1 = Long.parseLong(numbers[i]+""+numbers[j]);
                long sum2 = Long.parseLong(numbers[j]+""+numbers[i]);
                if(sum1 > sum2){
                    int temp = numbers[j];
                    numbers[j] = numbers[i];
                    numbers[i] = temp;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int number : numbers) {
            sb.append(number);
        }
        return sb.toString();
    }

    /**
     * 如果str(a) + str(b) > str(b) + str(a),说明ab > ba，应该把b排在a前面
     * 简化代码，利用lambda
     * @param numbers
     * @return
     */
    private static String PrintMinNumber3(int [] numbers) {
        ArrayList<String> arrayList = new ArrayList<>();
        for(int i : numbers){
            arrayList.add( i + "" );
        }
        arrayList.sort((o1, o2) -> (o1 + o2).compareTo(o2 + o1));
        StringBuilder stringBuilder = new StringBuilder();
        for(String s : arrayList){
            stringBuilder.append(s);
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        int [] numbers = {3,32,321,99,45};
        System.out.println(PrintMinNumber3(numbers));
    }
}
