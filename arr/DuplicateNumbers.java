package arr;

/**
 * 在一个长度为n的数组里的所有数字都在0到n-1的范围内。
 * 数组中某些数字是重复的，但不知道有几个数字是重复的。
 * 也不知道每个数字重复几次。
 * 请找出数组中任意一个重复的数字。
 * 例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，那么对应的输出是第一个重复的数字2。
 * @ClassName: DuplicateNumbers
 * @description: 数组中的重复数字
 * @author: yyh
 * @create: 2020-01-11 11:18
 **/
public class DuplicateNumbers {


    /**
     * my result:hash表
     * 时间复杂度O(n)
     * @param numbers an array of integers
     * @param length  the length of array numbers
     * @param duplication (Output) the duplicated number in the array number,length of duplication array is 1,so using duplication[0] = ? in implementation;
     *                      Here duplication like pointor in C/C++, duplication[0] equal *duplication in C/C++
     *         这里要特别注意~返回任意重复的一个，赋值duplication[0]
     * @return true if the input is valid, and there are some duplications in the array number
     *         otherwise false
     */
    private static boolean duplicate(int[] numbers,int length,int [] duplication) {
        if (length <= 0 || numbers == null) {
            return false;
        }
        int[] arr = new int[length];
        for (int num : numbers){
            arr[num] ++ ;
            if(arr[num] >= 2){
                duplication[0] = num;
                return true;
            }
        }
        return false;
    }

    /**
     * other：利用现有数组设置标志，当一个数字被访问过后，可以设置对应位上的数 + n，
     * 之后再遇到相同的数时，会发现对应位上的数已经大于等于n了，那么直接返回这个数即可
     * @param numbers
     * @param length
     * @param duplication
     * @return
     */
    private static boolean duplicate2(int[] numbers,int length,int [] duplication) {
        if (length <= 0 || numbers == null) {
            return false;
        }
        for (int i = 0; i < length; i++) {
            int index = numbers[i];
            if (index >= length) {
                index -= length;
            }
            if (numbers[index] >= length) {
                duplication[0] = index;
                return true;
            }
            //这里可能会溢出？
            numbers[index] += length;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] numbers = {2,3,1,0,2,5,3};
        int length = numbers.length;
        int[] duplication = new int[1];

        System.out.println(duplicate2(numbers,length,duplication));
        System.out.println(duplication[0]);
    }
}
