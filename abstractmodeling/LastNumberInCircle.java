package abstractmodeling;

import java.util.ArrayList;

/**
 * 每年六一儿童节,牛客都会准备一些小礼物去看望孤儿院的小朋友,今年亦是如此。
 * HF作为牛客的资深元老,自然也准备了一些小游戏。
 * 其中,有个游戏是这样的:首先,让小朋友们围成一个大圈。
 * 然后,他随机指定一个数m,让编号为0的小朋友开始报数。
 * 每次喊到m-1的那个小朋友要出列唱首歌,然后可以在礼品箱中任意的挑选礼物,并且不再回到圈中,
 * 从他的下一个小朋友开始,继续0...m-1报数....这样下去....直到剩下最后一个小朋友,可以不用表演,
 * 并且拿到牛客名贵的“名侦探柯南”典藏版(名额有限哦!!^_^)。
 * 请你试着想下,哪个小朋友会得到这份礼品呢？(注：小朋友的编号是从0到n-1)
 * <p>
 * 如果没有小朋友，请返回-1
 * <p>
 * All rights Reserved, Designed By yyh
 * 孩子们的游戏(圆圈中最后剩下的数)
 *
 * @Package abstractmodeling
 * @author: yyh
 * @date: 2020-03-27 9:42
 * @since V1.0.0-SNAPSHOT
 */
public class LastNumberInCircle {

    /**
     * 使用一个list来模拟，并使用一个索引cur类指向删除的位置，当cur的值为list的size，就让cur到头位置。
     *
     * @param n
     * @param m
     * @return
     */
    private static int LastRemaining_Solution(int n, int m) {
        if (n <= 0 || m <= 0) {
            return -1;
        }
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        int cur = -1;
        while (list.size() > 1) {
            for (int i = 0; i < m; i++) {
                cur++;
                if (cur == list.size()) {
                    cur = 0;
                }
            }
            list.remove(cur);
            //cur--的原因，因为新的list中cur指向了下一个元素，为了保证移动m个准确性，所以cur向前移动一位。
            cur--;
        }
        return list.get(0);
    }

    /**
     * 上一题的优化
     * @param n
     * @param m
     * @return
     */
    private static int LastRemaining_Solution2(int n, int m) {
        if (n <= 0 || m <= 0) {
            return -1;
        }
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        int start = 0;
        while (list.size() > 1) {
            start = (start + m - 1) % list.size();
            list.remove(start);
        }
        return list.get(0);
    }

    /**
     * 数学公式
     *
     * @param n
     * @param m
     * @return
     */
    private static int LastRemaining_Solution3(int n, int m) {
        if (n <= 0 || m <= 0) {
            return -1;
        }
        int ans = 0;
        //执行n-1次
        for (int i = 2; i <= n; i++) {
            //直接计算应该移除的位置
            ans = (ans + m) % i;
        }
        return ans;
    }

    /**
     * 数学公式
     *
     * @param n
     * @param m
     * @return
     */
    private static int LastRemaining_Solution4(int n, int m) {
        // 不满足的条件
        if (n <= 0 || m <= 0) {
            return -1;
        }
        return n == 1 ? 0 : (LastRemaining_Solution4(n - 1, m) + m) % n;
    }

    /**
     * 0 1 2 3 4 5 6 7
     * 0 1 3 4 6 7
     * 1 3 6 7
     * 3 6 7
     * 6 7
     * 6
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(LastRemaining_Solution2(8, 3));
    }
}
