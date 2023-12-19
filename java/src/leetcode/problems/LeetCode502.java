package leetcode.problems;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/12/19 23:00
 * @description 排序 + 堆
 */
public class LeetCode502 {

    public int findMaximizedCapital(int k, int w, int[] Profits, int[] Capital) {
        List<int[]> proj = new ArrayList<>();
        for (int i = 0; i < Profits.length; i++) {
            proj.add(new int[]{Capital[i], Profits[i]});
        }
        proj.sort(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        int count = 0;
        int i = 0;
        while (count < k) {
            while (i < proj.size() && proj.get(i)[0] <= w) {
                pq.offer(proj.get(i)[1]);
                i++;
            }
            if (!pq.isEmpty()) {
                w += pq.poll();
                count++;
            } else {
                break;
            }
        }
        return w;
    }
}
