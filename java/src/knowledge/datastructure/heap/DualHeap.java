package knowledge.datastructure.heap;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/12/26 23:16
 * @description 对顶堆
 * @see leetcode.problems.LeetCode4
 * @see leetcode.problems.LeetCode295
 * @see leetcode.problems.LeetCode480
 * @see leetcode.problems.LeetCode3321
 */
public interface DualHeap<T> {

    void add(T element);

    void remove(T element);

    int size();

    boolean isEmpty();

    void clear();
}
