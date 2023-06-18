package basic.algorithm.heap;

import java.util.Stack;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/7/23 16:33
 */
public class TopK implements basic.problems.array.TopK {

    public static void main(String[] args) {
        int M = 5;
        int[] arr = new int[]{1, 5, 3, 7, 2, 4, 6, 8, 9, 0};
        new TopK().findMinK(arr, M);
    }

    @Override
    public void findMinK(int[] arr, int M) {
        MaxHeap<Integer> pq = new MaxHeap<>(arr.length + 1);
        for (int j : arr) {
            pq.insert(j);
            if (pq.size() > M) {
                pq.delMax();
            }
        }
        Stack<Integer> sk = new Stack<>();
        while (!pq.isEmpty()) {
            sk.push(pq.delMax());
        }

        while (!sk.isEmpty()) {
            System.out.println(sk.pop());
        }
    }
}
