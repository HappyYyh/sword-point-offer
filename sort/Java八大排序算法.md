# Java八大排序算法

## 排序算法的介绍

排序也称排序算法(SortAlgorithm)，排序是将 **一组数据**，依 **指定的顺序**进行 **排列**的过程。



## 排序的分类

按照是否使用内存可以分为内部排序和外部排序两种：

1. **内部排序:**
   指将需要处理的所有数据都加载到 内部存储器( 内存)中进行排序。

   ![排序算法分类](http://image.yangyhao.top/blog/%E6%8E%92%E5%BA%8F%E7%AE%97%E6%B3%95-%E5%88%86%E7%B1%BB.png)

2. **外部排序法：**
   数据量过大，无法全部加载到内存中，需要借助 外部存储( 文件等)进行排序。

按照是否稳定可以分为稳定排序和非稳定排序两种：

> 如果一个排序算法能够保留数组中重复元素的相对位置则可以被称为是 **稳定** 的。反之，则是 **非稳定** 的。



## 排序算法的实现

### 冒泡排序

**基本思想**

冒泡排序（Bubble Sort）是一种简单的排序算法。它重复地走访过要排序的数列，一次比较两个元素，如果他们的顺序错误就把他们交换过来。走访数列的工作是重复地进行直到没有再需要交换，也就是说该数列已经排序完成。这个算法的名字由来是因为越小的元素会经由交换慢慢“浮”到数列的顶端。

**算法描述**

冒泡排序算法的运作如下：

1. 比较相邻的元素。如果第一个比第二个大，就交换他们两个。
2. 对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对。这步做完后，最后的元素会是最大的数。
3. 针对所有的元素重复以上的步骤，除了最后一个。
4. 持续每次对越来越少的元素重复上面的步骤，直到没有任何一对数字需要比较。

**代码实现**

~~~java
/**
  * 冒泡排序(从小到大)：比较相邻的元素。如果第一个比第二个大，就交换他们两个。
  * @param array
  */
private static void bubbleSort(int[] array) {
    for (int i = 0; i < array.length - 1; i++) {
        for (int j = 0; j < array.length - 1 - i; j++) {
            if (array[j] > array[j + 1]) {
                int tmp = array[j];
                array[j] = array[j + 1];
                array[j + 1] = tmp;
            }
        }
    }
}
~~~

**复杂度分析**

| 平均时间复杂度 | 最好情况 | 最坏情况 | 空间复杂度 |
| :------------: | :------: | :------: | :--------: |
|     O(n²)      |   O(n)   |  O(n²)   |    O(1)    |

冒泡排序是最容易实现的排序,。

- 最坏的情况是每次都需要交换, 共需遍历并交换将近n²/2次, 时间复杂度为O(n²)。
- 最佳的情况是内循环遍历一次后发现排序是对的, 因此退出循环, 时间复杂度为O(n)。
- 平均来讲, 时间复杂度为O(n²)。
- 由于冒泡排序中只有缓存的temp变量需要内存空间, 因此空间复杂度为常量O(1)。

**总结与思考**

由于冒泡排序只在相邻元素大小不符合要求时才调换他们的位置, 它并不改变相同元素之间的相对顺序, 因此它是稳定的排序算法。



### 选择排序

**基本思想**

选择排序（Selection sort）是一种简单直观的排序算法。

它的工作原理如下:首先在未排序序列中找到最小（大）元素，存放到排序序列的起始位置，然后，再从剩余未排序元素中继续寻找最小（大）元素，然后放到已排序序列的末尾。以此类推，直到所有元素均排序完毕。

**算法描述**

1. 从未排序序列中，找到关键字最小的元素
2. 如果最小元素不是未排序序列的第一个元素，将其和未排序序列第一个元素互换
3. 重复1、2步，直到排序结束。

**代码实现**

~~~java
/**
  * 选择排序：在未排序序列中找到最小元素，存放到排序序列的起始位置。
  * @param array
  */
private static void selectSort(int[] array) {
    for (int i = 0; i < array.length - 1; i++) {
        int min = i;
        //选出之后待排序中值最小的位置
        for (int j = i + 1; j < array.length; j++) {
            if (array[j] < array[min]) {
                min = j;
            }
        }
        //最小值不等于当前值时进行交换
        if (min != i) {
            int temp = array[i];
            array[i] = array[min];
            array[min] = temp;
        }
    }
}
~~~

**复杂度分析**

以下是选择排序复杂度:

| 平均时间复杂度 | 最好情况 | 最坏情况 | 空间复杂度 |
| :------------: | :------: | :------: | :--------: |
|     O(n²)      |  O(n²)   |  O(n²)   |    O(1)    |

**总结与思考**

选择排序的简单和直观名副其实，这也造就了它”出了名的慢性子”，无论是哪种情况，哪怕原数组已排序完成，它也将花费将近n²/2次遍历来确认一遍。

即便是这样，它的排序结果也还是不稳定的。

 唯一值得高兴的是，它并不耗费额外的内存空间。



### 插入排序

**基本思想**

插入式排序属于内部排序法，是对于欲排序的元素以插入的方式找寻该元素的适当位置，以达到排序的目的。

**算法描述**

一般来说，插入排序都采用in-place在数组上实现。具体算法描述如下：

1. 从第一个元素开始，该元素可以认为已经被排序
2. 取出下一个元素，在已经排序的元素序列中从后向前扫描
3. 如果该元素（已排序）大于新元素，将该元素移到下一位置
4. 重复步骤3，直到找到已排序的元素小于或者等于新元素的位置
5. 将新元素插入到该位置后
6. 重复步骤2~5

**代码实现**

~~~java
/**
  * 插入排序：对于欲排序的元素以插入的方式找寻该元素的适当位置
  * @param array
  */
private static void insertSort(int[] array) {
    int insertVal;
    int insertIndex;
    for (int i = 1; i < array.length; i++) {
        insertVal = array[i];
        insertIndex = i - 1;
        // 给 insertVal 找到插入的位置
        // 说明
        // 1. insertIndex >= 0 保证在给 insertVal 找插入位置，不越界
        // 2. insertVal < arr[insertIndex] 待插入的数，还没有找到插入位置
        // 3. 就需要将 arr[insertIndex] 后移
        while (insertIndex >= 0 && insertVal < array[insertIndex]) {
            array[insertIndex + 1] = array[insertIndex];
            insertIndex--;
        }
        if (insertIndex + 1 != i) {
            array[insertIndex + 1] = insertVal;
        }
    }
}

/**
  * 插入排序
  * @param array
  */
private static void insertSort2(int[] array) {
    for (int i = 1; i < array.length; i++) {
        // 待插入的值
        int num = array[i];
        int j;
        for (j = i; j > 0 && num < array[j - 1]; j--) {
            array[j] = array[j - 1];
        }
        array[j] = num;
    }
}
~~~

**复杂度分析**

直接插入排序复杂度如下：

| 平均时间复杂度 | 最好情况 | 最坏情况 | 空间复杂度 |
| :------------: | :------: | :------: | :--------: |
|     O(n²)      |  O(n²)   |  O(n²)   |    O(1)    |

**总结与思考**

插入排序所需的时间取决于输入元素的**初始顺序**。

例如，对一个很大且其中的元素已经有序(或接近有序)的数组进行排序将会比随机顺序的数组或是逆序数组进行排序要快得多。



### 希尔排序

希尔排序，也称 **递减增量排序算法**，是插入排序的一种更高效的改进版本。希尔排序是 **非稳定排序算法**。

希尔排序是基于插入排序的以下两点性质而提出改进方法的：

- 插入排序在对几乎已经排好序的数据操作时，效率高，即可以达到线性排序的效率
- 但插入排序一般来说是低效的，因为插入排序每次只能将数据移动一

**基本思想**

希尔排序是把记录按下标的一定增量（gap）分组，对每组使用直接插入排序算法排序；随着增量逐渐减少，每组包含的关键词越来越多， 当增量减至 1  时，整个文件恰被分成一组，算法便终止

**算法描述**

1. 选择一个增量序列 t1，t2，……，tk，其中 ti > tj, tk = 1；
2. 按增量序列个数 k，对序列进行 k 趟排序；
3. 每趟排序，根据对应的增量 ti，将待排序列分割成若干长度为 m 的子序列，分别对各子表进行直接插入排序。仅增量因子为 1 时，整个序列作为一个表来处理，表长度即为整个序列的长度。

如下图所示：

![希尔排序-过程1](http://image.yangyhao.top/blog/%E5%B8%8C%E5%B0%94%E6%8E%92%E5%BA%8F-%E8%BF%87%E7%A8%8B1.png)

![希尔排序-过程2](http://image.yangyhao.top/blog/%E5%B8%8C%E5%B0%94%E6%8E%92%E5%BA%8F-%E8%BF%87%E7%A8%8B2.png)

**代码实现**

~~~java
/**
  * 希尔排序：交换法
  *
  * @param array
  */
private static void shellSort(int[] array) {
    int tmp;
    for (int gap = array.length / 2; gap > 0; gap /= 2) {
        for (int i = gap; i < array.length; i++) {
            // 遍历各组中所有的元素(共 gap 组，每组有个元素), 步长 gap
            for (int j = i - gap; j >= 0; j -= gap) {
                // 如果当前元素大于加上步长后的那个元素，说明交换
                if (array[j] > array[j + gap]) {
                    tmp = array[j];
                    array[j] = array[j + gap];
                    array[j + gap] = tmp;
                }
            }
        }
    }
}

/**
  * 希尔排序：移位法
  *
  * @param array
  */
private static void shellSort2(int[] array) {
    // 增量 gap, 并逐步的缩小增量
    for (int gap = array.length / 2; gap > 0; gap /= 2) {
        for (int i = gap; i < array.length; i++) {
            int j = i;
            int tmp = array[j];
            if (array[j] < array[j - gap]) {
                while (j - gap >= 0 && tmp < array[j - gap]) {
                    //移动
                    array[j] = array[j - gap];
                    j -= gap;
                }
                //当退出 while 后，就给 tmp 找到插入的位置
                array[j] = tmp;
            }
        }
    }
}

/**
  * 《算法》中给出的步长选择策略
  * @param a
  */
private static void shellSort3(int[] a) {
    int length = a.length;
    int gap = 1;
    while (gap < length / 3) {
        gap = 3 * gap + 1;
    }
    for (; gap >= 1; gap /= 3) {
        for (int i = 0; i < a.length - gap; i += gap) {
            for (int j = i + gap; j > 0; j -= gap) {
                if (a[j] < a[j - gap]) {
                    int temp = a[j];
                    a[j] = a[j - gap];
                    a[j - gap] = temp;
                }
            }
        }
    }
}
~~~

**复杂度分析**

以下是希尔排序复杂度:

| 平均时间复杂度 |  最好情况  |  最坏情况  | 空间复杂度 |
| :------------: | :--------: | :--------: | :--------: |
|   O(nlog2 n)   | O(nlog2 n) | O(nlog2 n) |    O(1)    |

**总结与思考**

希尔排序更高效的原因是它权衡了子数组的规模和有序性。排序之初，各个子数组都很短，排序之后子数组都是部分有序的，这两种情况都很适合插入排序。



### 快速排序

**基本思想**

快速排序（Quicksort）是对冒泡排序的一种改进。

快速排序的基本思想：通过一趟排序将要排序的数据分割成独立的两部分，其中一部分的所有数据都比另外一部分的所有数据都要小，然后再按此方法对这两部分数据分别进行快速排序， **整个排序过程可以递归进行**，以此达到整个数据变成有序序列。

**算法描述**

快速排序使用分治策略来把一个序列（list）分为两个子序列（sub-lists）。步骤为：

1. 从数列中挑出一个元素，称为"基准"（pivot）。
2. 重新排序数列，所有比基准值小的元素摆放在基准前面，所有比基准值大的元素摆在基准后面（相同的数可以到任一边）。在这个分区结束之后，该基准就处于数列的中间位置。这个称为分区（partition）操作。
3. 递归地（recursively）把小于基准值元素的子数列和大于基准值元素的子数列排序。

递归到最底部时，数列的大小是零或一，也就是已经排序好了。这个算法一定会结束，因为在每次的迭代（iteration）中，它至少会把一个元素摆到它最后的位置去。

**代码实现**

~~~java
/**
  * 快速排序：以第一个元素为基准值
  *
  * @param array
  * @param low
  * @param high
  */
private static void quickSort(int[] array, int low, int high) {
    if (low > high) {
        return;
    }
    int left = low;
    int right = high;
    // 中轴值
    int pivot = array[low];
    while (left < right) {
        // 从右边找比基准值小的
        while (left < right && array[right] >= pivot) {
            right--;
        }
        // 从左边找比基准值大的
        while (left < right && array[left] <= pivot) {
            left++;
        }
        if (left < right) {
            int tmp = array[left];
            array[left] = array[right];
            array[right] = tmp;
        }
    }
    // 当左右指针相遇时重新调整基准值
    int tmp = array[left];
    array[left] = array[low];
    array[low] = tmp;
    quickSort(array, low, left - 1);
    quickSort(array, left + 1, high);
}

/**
  * 快速排序：以中间值为基准
  *
  * @param array
  * @param low
  * @param high
  */
private static void quickSort2(int[] array, int low, int high) {
    int left = low;
    int right = high;
    int mix = array[(low + high) / 2];
    int tmp;
    while (left < right) {
        while (array[left] < mix) {
            left++;
        }
        while (array[right] > mix) {
            right--;
        }
        if (left >= right) {
            break;
        }
        tmp = array[right];
        array[right] = array[left];
        array[left] = tmp;
        if (array[left] == mix) {
            right--;
        }
        if (array[right] == mix) {
            left++;
        }
    }
    if (left == right) {
        left++;
        right--;
    }
    if (low < right) {
        quickSort2(array, low, left - 1);
    }
    if (high > left) {
        quickSort2(array, right + 1, high);
    }
}
~~~

**复杂度分析**

以下是快速排序算法复杂度:

| 平均时间复杂度 | 最好情况  | 最坏情况 |      空间复杂度       |
| :------------: | :-------: | :------: | :-------------------: |
|   O(nlog₂n)    | O(nlog₂n) |  O(n²)   | O(1)（原地分区递归版) |



### 堆排序

- 堆排序是利用堆这种数据结构而设计的一种排序算法，堆排序是一种选择排序，它的最坏，最好，平均时间复
  杂度均为 O(nlogn)，它也是不稳定排序。
- 堆是具有以下性质的完全二叉树：每个结点的值都大于或等于其左右孩子结点的值，称为大顶堆, 注意 : 没有
  要求结点的左孩子的值和右孩子的值的大小关系。



**基本思想**

**算法描述**

**代码实现**

**复杂度分析**

**总结与思考**

### 归并排序

**基本思想**

**算法描述**

**代码实现**

**复杂度分析**

**总结与思考**

### 基数排序

**基本思想**

**算法描述**

**代码实现**

**复杂度分析**

**总结与思考**



## 总结和对比

排序性能对比：

|   排序类型   | 平均情况  | 最好情况  |  最坏情况  | 辅助空间 | 稳定性 |
| :----------: | :-------: | :-------: | :--------: | :------: | :----: |
|   冒泡排序   |   O(n²)   |   O(n)    |   O(n²)    |   O(1)   |  稳定  |
|   选择排序   |   O(n²)   |   O(n²)   |   O(n²)    |   O(1)   | 不稳定 |
| 直接插入排序 |   O(n²)   |   O(n)    |   O(n²)    |   O(1)   |  稳定  |
|   希尔排序   | O(nlogn)  | O(nlogn)  |   O(n²)    |   O(1)   | 不稳定 |
|   归并排序   | O(nlogn)  | O(nlogn)  |  O(nlogn)  |   O(n)   |  稳定  |
|   快速排序   | O(nlogn)  | O(nlogn)  |   O(n²)    | O(nlogn) | 不稳定 |
|    堆排序    | O(nlogn)  | O(nlogn)  |  O(nlogn)  |   O(1)   | 不稳定 |
|   计数排序   |  O(n+k)   |  O(n+k)   |   O(n+k)   |   O(k)   |  稳定  |
|    桶排序    |  O(n+k)   |  O(n+k)   |   O(n²)    |  O(n+k)  |  稳定  |
|   基数排序   | O(d(n+k)) | O(d(n+k)) | O(d(n+kd)) | O(n+kd)  |  稳定  |

解释：n: 数据规模  k: “桶”的个数