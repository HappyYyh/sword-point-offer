package recursionandloop;

/**
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。
 * 求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
 * @ClassName: JumpFloor
 * @description: 跳台阶
 * @author: yyh
 * @create: 2020-02-16 10:47
 **/
public class JumpFloor {

    /**
     * my result (once pass) :
     * 由观察可以看出 每一个target第一步可以选择 1 或 2
     * 如果选1，那剩下的就是 Jum(target-1)，如果选2，那剩下的就是 Jum(target-2)，所以这个就等同于斐波那契数列
     *
     * @param target
     * @return
     */
    private static int JumpFloor(int target) {
        if(target <= 0){
            return 0;
        }
        if(target == 1 || target == 2){
            return target;
        }
        return JumpFloor(target- 1) + JumpFloor(target -2);
    }

    /**
     * 同样可以使用上一个斐波那契数列的解法，注意点是F(2) = 2
     * @param target
     * @return
     */
    private static int JumpFloor2(int target) {
        int curr = 1 ,next = 2;
        while (target -- > 1){
            next = curr + next;
            curr = next - curr;
        }
        return curr;
    }

    /**
     *  n         跳法
     *  1          1
     *  2          1 1 / 2
     *  3          1 1 1 / 1 2 / 2 1
     *  4          1 1 1 1 / 1 2 1 / 2 1 1 / 1 1 2/ 2 2
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(JumpFloor2(30));
    }
}
