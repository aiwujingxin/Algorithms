package knowledge.datastructure.heap;

import leetcode.problems.LeetCode295;
import leetcode.problems.LeetCode3321;
import leetcode.problems.LeetCode4;
import leetcode.problems.LeetCode480;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/12/26 23:16
 * @description 对顶堆
 * @see LeetCode4
 * @see LeetCode295
 * @see LeetCode480
 * @see LeetCode3321
 */
public interface DualHeap<T> {

    void add(T element);

    void remove(T element);

    int size();

    boolean isEmpty();

    void clear();
}
