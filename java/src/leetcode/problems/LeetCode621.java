package leetcode.problems;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/9/20 22:49
 */
public class LeetCode621 {

    public int leastInterval(char[] tasks, int n) {
        // 1.字符类型计数
        n++;
        int[] freq = new int[26];
        for (char t : tasks) {
            freq[t - 'A']++;
        }
        Queue<Integer> pq = new PriorityQueue<>(((o1, o2) -> o2 - o1));
        for (int f : freq) {
            if (f > 0) {
                pq.add(f);
            }
        }
        int res = 0;
        // 2.开始进行贪心操作,就是我们每次操作都要选择次数最多的
        while (!pq.isEmpty()) {
            List<Integer> temp = new ArrayList<>();
            int k = Math.min(n, pq.size());
            for (int i = 0; i < k; i++) {
                int f = pq.poll();
                f--;
                if (f != 0) {
                    temp.add(f);
                }
            }
            if (!temp.isEmpty()) {
                res += n;
            } else {
                res += k;
            }
            pq.addAll(temp);
        }
        return res;
    }

    public int leastInterval_greedy(char[] tasks, int n) {
        int[] counts = new int[26];
        int maxCount = 0;
        for (char task : tasks) {
            counts[task - 'A']++;
            maxCount = Math.max(maxCount, counts[task - 'A']);
        }
        int maxCountTasks = 0;
        for (int count : counts) {
            if (count == maxCount) {
                maxCountTasks++;
            }
        }
        int minTime = (maxCount - 1) * (n + 1) + maxCountTasks;
        return Math.max(tasks.length, minTime);
    }
}
