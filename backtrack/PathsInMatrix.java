package backtrack;


/**
 * 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。
 * 路径可以从矩阵中的任意一个格子开始，每一步可以在矩阵中向左，向右，向上，向下移动一个格子。
 * 如果一条路径经过了矩阵中的某一个格子，则该路径不能再进入该格子。
 * 例如 [a b c e
 *       s f c a
 *       a d e e]
 * 矩阵中包含一条字符串"bcced"的路径，但是矩阵中不包含"abcb"路径，
 * 因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入该格子。
 *
 * All rights Reserved, Designed By yyh
 * 矩阵中的路径
 * @Package backtrack
 * @author: yyh
 * @date: 2020-03-31 9:30
 * @since V1.0.0-SNAPSHOT
 */
public class PathsInMatrix {

    /**
     * 标记是否被访问
     */
    private static boolean[] visited = null;

    private static boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        visited = new boolean[matrix.length];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (subHasPath(matrix, rows, cols, str, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean subHasPath(char[] matrix, int rows, int cols, char[] str, int row, int col, int len) {
        // 当前字符不等于寻找的字符 || 当前字符已经被访问过
        if (matrix[row * cols + col] != str[len] || visited[row * cols + col]) {
            return false;
        }
        // 找到路径后
        if (len == str.length - 1) {
            return true;
        }
        visited[row * cols + col] = true;
        if (row > 0 && subHasPath(matrix, rows, cols, str, row - 1, col, len + 1)) {
            return true;
        }
        if (row < rows - 1 && subHasPath(matrix, rows, cols, str, row + 1, col, len + 1)) {
            return true;
        }
        if (col > 0 && subHasPath(matrix, rows, cols, str, row, col - 1, len + 1)) {
            return true;
        }
        if (col < cols - 1 && subHasPath(matrix, rows, cols, str, row, col + 1, len + 1)) {
            return true;
        }
        visited[row * cols + col] = false;
        return false;
    }

    public static void main(String[] args) {
        char[] matrix = {'a','b','c','e','s','f','c','a','a','d','e','e'};
        char[] str = {'b','c','c','e','f'};
        System.out.println(hasPath(matrix,3,4,str));
    }
}
