package leetcode.problems;

import java.util.PriorityQueue;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/1/8 17:53
 */
public class LeetCode1962 {

    public int minStoneSum(int[] piles, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> o2 - o1);
        int sum = 0;
        for (int i = 0; i < piles.length; i++) {
            queue.add(piles[i]);
            sum += piles[i];
        }

        while (k > 0) {
            int node = queue.poll();
            if (node % 2 == 0) {
                sum -= node / 2;
                node = node / 2;
            } else {
                sum -= node / 2;
                node = node / 2 + 1;
            }
            queue.add(node);
            k--;
        }

        return sum;
    }
}
