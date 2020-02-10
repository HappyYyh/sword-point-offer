package tree;

import java.util.*;

/**
 * 如何得到一个数据流中的中位数？
 * 如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。
 * 如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
 * 我们使用Insert()方法读取数据流，使用GetMedian()方法获取当前读取数据的中位数。
 * @ClassName: MedianInDataStream
 * @description: 数据流中的中位数
 * @author: yyh
 * @create: 2020-02-10 10:48
 **/
public class MedianInDataStream {

    private static TreeNode treeNode;
    private static List<Double> list = new ArrayList<>();

    /**
     * my result:建立二叉搜索树
     * @param num
     */
    private static void Insert(Integer num) {
        if(treeNode == null){
            treeNode = new TreeNode(num);
            return;
        }
        create(treeNode,num);
    }

    /**
     * 创建二叉搜索树
     * @param node
     * @param num
     * @return
     */
    private static TreeNode create(TreeNode node , Integer num){
        if(node == null){
            node = new TreeNode(num);
        }else {
            if(node.val >= num){
              node.left = create(node.left,num);
            }else {
              node.right = create(node.right,num);
            }
        }
        return node;
    }

    /**
     * 获取中位数
     * @return
     */
    private static Double GetMedian() {
        list.clear();
        infix(treeNode);
        int size = list.size();
        if(size == 0){
            return 0.0;
        }
        if( size % 2 == 0){
            return (list.get(size / 2) + list.get(size/2 - 1)) / 2;
        }else {
            return list.get(size / 2);
        }

    }

    /**
     * 中序遍历
     * @param node
     */
    private static void infix(TreeNode node){
        if(node != null){
            infix(node.left);
            list.add((double) node.val);
            infix(node.right);
        }
    }


    /**
     * other : 利用优先队列
     */
    private static PriorityQueue<Integer> left = new PriorityQueue<>((o1, o2) -> o2 - o1);
    private static PriorityQueue<Integer> right = new PriorityQueue<>();
    private static int N;

    private static void Insert2(Integer num) {
        if (N % 2 == 0) {
            left.add(num);
            right.add(left.poll());
        } else {
            right.add(num);
            left.add(right.poll());
        }
        N++;
    }

    private static Double GetMedian2() {
        if (N % 2 == 0) {
            return (left.peek() + right.peek()) / 2.0;
        } else {
            return (double) right.peek();
        }
    }


    /**
     * other : 利用treeMap有序
     */
    private static TreeMap treeMap = new TreeMap<Integer, Integer>();

    private static void Insert3(Integer num) {
        if (treeMap.containsKey(num)) {
            int sum = (Integer) treeMap.get(num);
            treeMap.replace(num, sum, sum + 1);
        } else {
            treeMap.put(num, 1);
        }
    }

    private static Double GetMedian3() {
        int size = treeMap.size();
        Map.Entry entry = treeMap.firstEntry();
        int i = (int) entry.getValue();
        int mid = (size + 1) / 2;
        while (i < mid) {
            entry = treeMap.higherEntry(entry.getKey());
            i += (int) entry.getValue();
        }
        if (size % 2 == 0 && i == mid) {
            return ((int) entry.getKey() * 1.0 + (int) treeMap.higherEntry(entry.getKey()).getKey() * 1.0) / 2;
        }
        return (int) entry.getKey() * 1.0;
    }

    public static void main(String[] args) {
        //5,2,3,4,1,6,7,0,8
        Insert(5);
        System.out.println(GetMedian());
        Insert(2);
        System.out.println(GetMedian());
        Insert(3);
        System.out.println(GetMedian());
        Insert(4);
        System.out.println(GetMedian());
        Insert(1);
        System.out.println(GetMedian());
        Insert(6);
        System.out.println(GetMedian());
        Insert(7);
        System.out.println(GetMedian());
        Insert(0);
        System.out.println(GetMedian());
        Insert(8);
        System.out.println(GetMedian());
        TreeNode.infix(treeNode);
    }
}
