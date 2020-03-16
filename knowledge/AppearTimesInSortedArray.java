package knowledge;

/**
 * 统计一个数字在排序数组中出现的次数。
 *
 * All rights Reserved, Designed By yyh
 * 数字在排序数组中出现的次数
 * @Package knowledge
 * @author: yyh
 * @date: 2020-03-16 10:29
 * @since V1.0.0-SNAPSHOT
 */
public class AppearTimesInSortedArray {

    /**
     * my result(once pass)：迭代查找
     * 时间复杂度：O(n)
     * @param array
     * @param k
     * @return
     */
    private static int GetNumberOfK(int [] array , int k) {
        int count = 0;
        for (int val : array){
            if(val == k){
                count++;
            }
        }
        return count;
    }

    /**
     * my result(once pass) : 二分查找
     * 时间复杂度：O(logN)
     * @param array
     * @param k
     * @return
     */
    private static int GetNumberOfK2(int [] array , int k) {
        if(array.length == 0){
            return 0;
        }
        if(array.length == 1){
            return array[0] == k ? 1 : 0;
        }
        int count = 0;
        // 判断是递增还是递减
        boolean up = array[0] < array[array.length -1];
        int left = 0;
        int right = array.length - 1;
        while (left <= right){
            int mid = left + ((right - left) >> 1);
            if(up){
                if(array[mid] < k){
                    left = mid + 1;
                }else if(array[mid] > k){
                    right = mid - 1;
                }else {
                    count++;
                    int l = mid,r = mid;
                    while (l-- > left){
                        if(array[l] == k){
                            count++;
                        } else {
                            break;
                        }
                    }
                    while (r++ < right){
                        if(array[r] == k){
                            count++;
                        }else {
                            break;
                        }
                    }
                    break;
                }
            }else {
                if(array[mid] < k){
                    right = mid -1;
                }else if(array[mid] > k){
                    left = mid + 1;
                }else {
                    count++;
                    int l = mid,r = mid;
                    while (l-- > left){
                        if(array[l] == k){
                            count++;
                        } else {
                            break;
                        }
                    }
                    while (r++ < right){
                        if(array[r] == k){
                            count++;
                        }else {
                            break;
                        }
                    }
                    break;
                }
            }
        }
        return count;
    }

    /**
     * other:二分查找，两次二分查找寻找上界和下届，无须考虑升序还是降序
     * @param array
     * @param k
     * @return
     */
    private static int GetNumberOfK3(int[] array, int k) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int lowerIndex = lower_bound(array, k);
        int upperIndex = upper_bound(array, k);
        return upperIndex - lowerIndex;
    }

    private static int upper_bound(int[] array, int val) {
        int l = 0, r = array.length - 1, mid;
        while (l <= r) {
            mid = (l + r) >> 1;
            if (array[mid] <= val) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return r;
    }

    private static int lower_bound(int[] array, int val) {
        int l = 0, r = array.length - 1, mid;
        while (l <= r) {
            mid = (l + r) >> 1;
            if (array[mid] < val) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }

    /**
     * [7,5,4,3,3,1]  3
     * [1,3,3,4,5,7]  3
     * @param args
     */
    public static void main(String[] args) {
        int[] arr = {3,1};
        System.out.println(GetNumberOfK3(arr,3));
    }
}
