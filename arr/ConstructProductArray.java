package arr;

import java.util.Arrays;

/**
 * 给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],其中B中的元素
 * B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。不能使用除法。
 * eg：B[0] = A[1]*A[2]*...*A[n-1] 没有A[0]
 *     B[1] = A[0]*A[2]*...*A[n-1] 没有A[1]
 *     B[2] = A[0]*A[1]*...*A[n-1] 没有A[2]
 *     B[n-1] = A[0]*A[1]*...*A[n-2] 没有A[n-1]
 * @ClassName: ConstructProductArray
 * @description: 构建乘积数组
 * @author: yyh
 * @create: 2020-01-11 11:55
 **/
public class ConstructProductArray {

    /**
     * my result: 暴力计算
     * 时间复杂度：O(n^2)
     * @param A
     * @return
     */
    private static int[] multiply(int[] A) {
        int[] B = new int[A.length];
        for (int i = 0; i < B.length ; i++) {
            int multiply = 1;
            for (int j = 0; j < A.length; j++) {
                if(j != i){
                    multiply*=A[j];
                }
            }
            B[i] = multiply;
        }
        return B;
    }


    /**
     * other：B[i]的值可以看作下图的矩阵中每行的乘积。
     * B0:   1    A1    A2    ---    An-2    An-1
     * B1:   A0    1    A2    ---    An-2    An-1
     * B2:   A0    A1    1    ---    An-2    An-1
     * --    A0    A1    ---    1    An-2    An-1
     * Bn-2  A0    A1    ---    An-3    1    An-1
     * Bn-1  A0    A1    ---    An-3    An-2    1
     * 先算下三角中的连乘，即我们先算出B[i]中的一部分，然后倒过来按上三角中的分布规律，把另一部分也乘进去
     * @param A
     * @return
     */
    private static int[] multiply2(int[] A) {
        int length = A.length;
        int[] B = new int[length];
        if(length != 0 ){
            B[0] = 1;
            //计算下三角连乘
            for(int i = 1; i < length; i++){
                B[i] = B[i-1] * A[i-1];
            }
            int temp = 1;
            //计算上三角
            for(int j = length-2; j >= 0; j--){
                temp *= A[j+1];
                B[j] *= temp;
            }
        }
        return B;
    }

    public static void main(String[] args) {
        int[] A = {1,2,3,4,5};
        System.out.println(Arrays.toString(multiply2(A)));
    }
}
