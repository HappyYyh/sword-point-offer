package recursionandloop;

/**
 * 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。
 * 请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
 * @ClassName: RectangularCover
 * @description: 矩形覆盖
 * @author: yyh
 * @create: 2020-02-18 10:26
 **/
public class RectangularCover {

    /**
     * 还是斐波那契数列
     * @param target
     * @return
     */
    private static int RectCover(int target) {
        if(target <= 2){
            return target;
        }
        // n 最后使用一块，剩下 n-1 块的写法
        int pre1 = 2;
        // n 最后使用两块，剩下 n-2 块的写法
        int pre2 = 1;
        for (int i = 3; i <= target; i++){
            int cur = pre1 + pre2;
            pre2 = pre1;
            pre1 = cur;
        }
        //相对于 n+1 块来说，第 n 种的方法
        return pre1;
    }

    private static int RectCover2(int target) {
        // 被覆盖的目标矩形的形状： 2*n
        // 每次新增加的一列，（1）如果竖着放对应的情况与 target为 n-1 时相同；
        // （2如果横着放，对应的情况与 target 为 n-2 时相同。
        if(target <= 2){
            return target;
        }else{
            return RectCover2(target-1) + RectCover2(target-2);
        }
    }

    /**
     *
     * n = 1
     *      只能横着覆盖，一种
     * n = 2
     *      可以横着和竖着覆盖，两种
     * n = 3
     *      第三级横着覆盖，用了一级，剩下 n = 2，有两种覆盖方法
     *      第三级竖着覆盖，用了两级，剩下 n = 1，有一种覆盖方法
     *      总共有 3 种
     * n = 4
     *      第 4 级横着覆盖，用了一级，剩下 n = 3，有三种覆盖方法
     *      第 4 级竖着覆盖，用了两级，剩下 n = 2，有两种覆盖方法
     *      总共有 5 种方法
     * n = n
     *      第 n 级横着覆盖，用了一级，剩下 n = n - 1，所以关注第 n - 1 种有几种覆盖方法
     *      第 n 级竖着覆盖，用了两级，剩下 n = n - 2，所以关注第 n - 2 种有几种覆盖方法
     *      总和为两种情况的总和
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(RectCover(5));
    }
}
