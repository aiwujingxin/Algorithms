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

    //https://www.youtube.com/watch?v=siNqiP6tk94&t=302s
    // 1) 关键是最多的任务 2) 最多的任务有几个?maxCountSame个
    // A _ _ _ _ _ A _ _ _ _ _ A....
    // (n+1)*(maxCount - 1) + maxCountSame
    // 3) 比较 整个长度
    public int leastInterval_greedy(char[] tasks, int n) {
        int[] freq = new int[26];
        for (char task : tasks) {
            freq[task - 'A']++;
        }
        int maxCount = 0;
        int maxCountSame = 0;
        for (int num : freq) {
            if (num > maxCount) {
                maxCount = num;
                maxCountSame = 1;
            } else if (num == maxCount) {
                maxCountSame++;
            }
        }
        int res = (maxCount - 1) * (n + 1) + maxCountSame;
        return Math.max(res, tasks.length);
    }

}
