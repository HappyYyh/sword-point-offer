# sword-point-offer（剑指offer）


## 数组

### [二维数组中的查找](arr/FindIn2DArray.java)

**考察点：数组、迭代、找规律、二分查找**

### [数组中的重复数字](arr/DuplicateNumbers.java)

**考察点：数组、哈希表、查找**

### [构建乘积数组](arr/ConstructProductArray.java)

**考察点：数组、矩阵**



## 字符串

### [替换空格](str/ReplaceSpace.java)

**考察点：字符串遍历、api**

### [正则表达式匹配](str/RegularExpressionMatch.java)

**考察点：递归、回溯、动态规划**

注：该题还没有彻底研究，同[Leetcode10](https://github.com/HappyYyh/leetCode/blob/master/hard/Hard_10.java)

### [表示数值的字符串](str/IsNumberString.java)

**考察点：正则表达式、数字校验**

### [字符流中第一个不重复的字符](str/FirstUniqueCharacter.java)

**考察点：哈希表**



## 链表

### [从尾到头打印链表](linkedlist/ReversePrintLinkedList.java)

**考察点：链表遍历、递归、迭代**

### [链表中环的入口结点](linkedlist/EntryNodeOfLoop.java)

**考察点：环形链表、双指针**

### [删除链表中重复的结点](linkedlist/DeleteDuplication.java)

**考察点：链表、递归**



## 二叉树

### [重建二叉树](tree/ReConstructBinaryTree.java)

**考察点：二叉树的前序遍历、中序遍历、递归**

### [二叉树的下一个结点](tree/BinaryTreeNextNode.java)

**考察点：中序遍历**

### [对称的二叉树](tree/SymmetricBinaryTree.java)

**考察点：递归、迭代**

同[leetcode101](https://github.com/HappyYyh/leetCode/blob/master/simple/Simple_101.java)

### [按之字形顺序打印二叉树](tree/PrintBinaryTree.java)

**考察点：DFS和BFS**

同[leetcode107](https://github.com/HappyYyh/leetCode/blob/master/simple/Simple_107.java)

### [把二叉树打印成多行](tree/PrintBinaryTree2.java)

**考察点：DFS和BFS**

同[leetcode107](https://github.com/HappyYyh/leetCode/blob/master/simple/Simple_107.java)

### [序列化二叉树](tree/SerializeBinaryTree.java)

**考察点：二叉树的遍历、递归**

### [二叉搜索树的第k个结点](tree/KthNode.java)

**考察点：二叉搜索树、中序遍历**

### [数据流中的中位数](tree/MedianInDataStream.java)

**考察点：二叉搜索树、优先队列、堆**



## 栈和队列

### [用两个栈实现队列](stackandqueue/ImplementQueueWithTwoStack.java)

**考察点：栈、队列特性**

### [滑动窗口的最大值](stackandqueue/MaxValueOfSlidingWindow.java)

**考察点：优先队列、大根堆**



## 查找和排序

### [旋转数组的最小数字](findandsort/MinNumberInRotateArray.java)

**考察点：线性查找、二分查找**



## 递归和循环

### [斐波那契数列](recursionandloop/Fibonacci.java)

**考察点：递归、循环、动态规划**

### [跳台阶](recursionandloop/JumpFloor.java)

**考察点：递归**

注：等同于上一题，斐波那契数列

### [变态跳台阶](recursionandloop/JumpFloorII.java)

**考察点：找规律**

注：复杂度更低，由上一题变种得来

### [矩形覆盖](recursionandloop/RectangularCover.java)

**考察点：斐波那契、递归**



## 位运算

### [二进制中1的个数](bitoperation/NumberOf1InBinary.java)

**考察点：位运算**



## 代码完整性

### [数值的整数次方](codeintegrity/IntegerPower.java)

### [调整数组顺序使奇数位于偶数前面](codeintegrity/AdjustArrayOrder.java)

**考察点：排序**



## 代码的鲁棒性

### [链表中倒数第k个结点](coderobustness/KthListNode.java)

**考察点：链表遍历、快慢指针**

### [反转链表](coderobustness/ReverseListNode.java)

**考察点：链表的迭代、递归**

注，同[leetcode206](https://github.com/HappyYyh/leetCode/blob/master/simple/Simple_206.java)

### [合并两个排序的链表](coderobustness/MergeTwoSortedListNode.java)

**考察点：链表的合并、递归、迭代**

注，同[leetcode21](https://github.com/HappyYyh/leetCode/blob/master/simple/Simple_21.java)

### [树的子结构](coderobustness/SubstructureOfTree.java)

**考察点：树的递归**



## 面试思路

### [二叉树的镜像](interviewideas/MirrorOfBinaryTree.java)

**考察点：二叉树的递归、迭代**



## 画图让抽象形象化

### [顺时针打印矩阵](draw/PrintMatrixClockwise.java)

**考察点：迭代**



## 举例让抽象具体化

### [包含min函数的栈](example/MinFunctionStack.java)

**考察点：栈**

### [栈的压入、弹出序列](example/StackPushAndSequencePop.java)

**考察点：栈、队列**

### [从上往下打印二叉树](example/PrintBinaryTreeFromTopToBottom.java)

**考察点：BFS**

注：同题[《把二叉树打印成多行》](tree/PrintBinaryTree2.java)

### [二叉搜索树的后序遍历序列](example/PostOrderOfBinarySearchTree.java)

**考察点：二叉搜索树、后序遍历**

### [二叉树中和为某一值的路径](example/PathSumOfBinaryTree.java)

**考察点：二叉树递归、回溯**



## 分解让复杂问题简单

### [复杂链表的复制](decompose/CopyComplexRandomListNode.java)

**考察点：链表的复制、随机链表**

### [二叉搜索树与双向链表](decompose/BinarySearchTreeAndDoublyListNode.java)

**考察点：二叉搜索树递归**

### [字符串的排列](decompose/PermutationOfStr.java)

该题为**字典序全排列**，即对于1.2..n有n!种排列方式，且数字小的在前;

完全不会！！！

**考察点：递归、回溯**



##  时间效率

###  [数组中出现次数超过一半的数字](timeefficiency/AppearMoreThanHalf.java)

注，同[leetcode169](https://github.com/HappyYyh/leetCode/blob/master/simple/Simple_169.java)

**考察点：数组迭代**

### [最小的K个数](timeefficiency/MinimumNumberOfK.java)

**考察点：大根堆、快排**

### [连续子数组的最大和](timeefficiency/MaximumSumOfConsecutiveSubArrays.java)

注：同[leetcode53](https://github.com/HappyYyh/leetCode/blob/master/simple/Simple_53.java)

**考察点：动态规划**

### [整数中1出现的次数（从1到n整数中1出现的次数）](timeefficiency/OccurrencesOf1InTheInteger.java)

**考察点：数学归纳法**

### [把数组排成最小的数](timeefficiency/ArrangeTheArrayToTheSmallestNumber.java)

**考察点：排序**



##  时间空间效率的平衡

### [丑数](efficiencybalance/UglyNumber.java)

**考察点：动态规划**

### [第一个只出现一次的字符](efficiencybalance/FirstAppearOnceChar.java)

**考察点：Hash表、StringAPI**

### [数组中的逆序对](efficiencybalance/ReversePairsInArray.java)

完全不会！

**考察点：归并排序**

