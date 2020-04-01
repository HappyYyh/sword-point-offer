package backtrack;

/**
 * 地上有一个m行和n列的方格。
 * 一个机器人从坐标0,0的格子开始移动，每一次只能向左，右，上，下四个方向移动一格，
 * 但是不能进入行坐标和列坐标的数位之和大于k的格子。
 * 例如，当k为18时，机器人能够进入方格（35,37），因为3+5+3+7 = 18。
 * 但是，它不能进入方格（35,38），因为3+5+3+8 = 19。
 * 请问该机器人能够达到多少个格子？
 * <p>
 * All rights Reserved, Designed By yyh
 * 机器人的运动范围
 *
 * @Package backtrack
 * @author: yyh
 * @date: 2020-04-01 9:08
 * @since V1.0.0-SNAPSHOT
 */
public class RobotMoveRange {

    /**
     * 记录是否访问过
     */
    private static boolean[][] flags;

    /**
     * 计数
     */
    private static int count = 0;

    /**
     * my result
     *
     * @param threshold
     * @param rows
     * @param cols
     * @return
     */
    private static int movingCount(int threshold, int rows, int cols) {
        if (threshold < 0 || rows <= 0 || cols <= 0) {
            return 0;
        }
        flags = new boolean[rows][cols];
        count(threshold, 0, 0);
        return count;
    }

    /**
     * 回溯
     *
     * @param threshold
     * @param x
     * @param y
     */
    private static void count(int threshold, int x, int y) {
        flags[x][y] = true;
        count++;
        if (x - 1 >= 0 && !flags[x - 1][y] && sum(x - 1, y) <= threshold) {
            count(threshold, x - 1, y);
        }
        if (x + 1 < flags.length && !flags[x + 1][y] && sum(x + 1, y) <= threshold) {
            count(threshold, x + 1, y);
        }
        if (y - 1 >= 0 && !flags[x][y - 1] && sum(x, y - 1) <= threshold) {
            count(threshold, x, y - 1);
        }
        if (y + 1 < flags[x].length && !flags[x][y + 1] && sum(x, y + 1) <= threshold) {
            count(threshold, x, y + 1);
        }
    }

    /**
     * 计算两数位之和
     *
     * @param x
     * @param y
     * @return
     */
    private static int sum(int x, int y) {
        String str = x + String.valueOf(y);
        int sum = 0;
        for (char c : str.toCharArray()) {
            sum += c - '0';
        }
        return sum;
    }

    private final int[] dx = {1, -1, 0, 0};
    private final int[] dy = {0, 0, 1, -1};

    public int sum(int x) {
        int ans = 0;
        while (x > 0) {
            ans += x % 10;
            x /= 10;
        }
        return ans;
    }

    /**
     * other ： dfs
     *
     * @param threshold
     * @param rows
     * @param cols
     * @param x
     * @param y
     * @param vis
     * @return
     */
    public int move(int threshold, int rows, int cols, int x, int y, boolean[][] vis) {
        vis[x][y] = true;
        int ans = 0;
        for (int i = 0; i < 4; i++) {
            // 向四个方向走
            int X = x + dx[i];
            int Y = y + dy[i];
            if (X >= 0 && Y >= 0 && X < rows && Y < cols && !vis[X][Y] && sum(X) + sum(Y) <= threshold) {
                ans += move(threshold, rows, cols, X, Y, vis) + 1;
            }
        }
        return ans;
    }

    public int movingCount2(int threshold, int rows, int cols) {
        if (threshold < 0 || rows <= 0 || cols <= 0) {
            return 0;
        }
        boolean[][] vis = new boolean[rows][cols];
        return move(threshold, rows, cols, 0, 0, vis) + 1;
    }

    /**
     * (0,0) (0,1) (0,2) (0,3)
     * (1,0) (1,1) (1,2) (1,3)
     * (2,0) (2,1) (2,2) (2,3)
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(movingCount(4, 3, 4));
        System.out.println(new RobotMoveRange().movingCount2(4, 3, 4));
    }
}
