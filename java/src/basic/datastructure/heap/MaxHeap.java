package basic.datastructure.heap;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/7/23 16:33
 * <a href="https://github.com/labuladong/fucking-algorithm/blob/master/%E6%95%B0%E6%8D%AE%E7%BB%93%E6%9E%84%E7%B3%BB%E5%88%97/%E4%BA%8C%E5%8F%89%E5%A0%86%E8%AF%A6%E8%A7%A3%E5%AE%9E%E7%8E%B0%E4%BC%98%E5%85%88%E7%BA%A7%E9%98%9F%E5%88%97.md">...</a>
 * @see basic.algorithm.sort.HeapSort
 * @see basic.algorithm.sort.HeapSelect
 */

public class MaxHeap<Key extends Comparable<Key>> {

    private final Key[] pq; // 基于堆的完全二叉树
    private int N = 0; // 存储于 pq[1 .. N] 中，pq[0] 没有使用

    @SuppressWarnings("unchecked")
    public MaxHeap(int capacity) { // 创建一个初始容量为 capacity 的优先队列
        pq = (Key[]) new Comparable[capacity + 1];
    }

    // 插入一个元素
    public void insert(Key v) {
        pq[++N] = v;
        up(N);
    }

    // 集合中的最大值
    public Key Max() {
        return pq[1];
    }

    // 删除并返回最大元素
    public Key delMax() {
        Key max = pq[1];    // 从根结点得到最大元素
        swap(1, N--);    // 将其和最后一个结点交换
        pq[N + 1] = null;    // 防止对象游离
        down(1);    // 恢复堆的有序性
        return max;
    }


    // 删除任意一个元素

    // 修改任意一个元素


    // 由下至上的堆有序化（上浮）的实现
    private void up(int k) {
        while (k > 1 && less(k / 2, k)) {
            swap(k / 2, k);
            k = k / 2;
        }
    }

    // 由上至下的堆有序化（下沉）的实现
    private void down(int k) {
        while (2 * k <= N) {
            int j = 2 * k;
            //将它和它的两个子结点中的较大者交换来恢复堆
            if (j < N && less(j, j + 1)) {
                j++;
            }
            if (!less(k, j)) {
                break;
            }
            swap(k, j);
            //交换可能会在子结点处继续打破堆 的有序状态，因此我们需要不断地用相同的方式将其修复
            //将结点向下移动直到它的子结点都比它 更小或是到达了堆的底部
            k = j;
        }
    }

    private void swap(int i, int j) {
        Key t = pq[i];
        pq[i] = pq[j];
        pq[j] = t;
    }

    boolean isEmpty() { // 返回队列是否为空
        return N == 0;
    }

    public int size() { // 返回优先队列中的元素个数
        return N;
    }

    private boolean less(int i, int j) {
        return pq[i].compareTo(pq[j]) >= 0;
    }

}
