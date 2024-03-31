package leetcode.problems;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/3/13 22:30
 */
public class LeetCode1723 {

    int res = Integer.MAX_VALUE;

    public int minimumTimeRequired(int[] jobs, int k) {
        // 尽可能提前剪枝
        Arrays.sort(jobs);
        for (int i = 0, j = jobs.length - 1; i < j; i++, j--) {
            int t = jobs[i];
            jobs[i] = jobs[j];
            jobs[j] = t;
        }
        backtrack(jobs, new int[k], 0, k, 0);
        return res;
    }

    private void backtrack(int[] jobs, int[] times, int index, int k, int max) {
        if (index == jobs.length) {
            res = Math.min(max, res);
            return;
        }
        for (int i = 0; i < k; i++) {
            //每次分配任务，如果前面有人是没有任务的，就停止搜索. 避免重复
            if (i > 0 && times[i - 1] == 0) {
                continue;
            }
            times[i] += jobs[index];
            if (Math.max(times[i], max) < res) {
                backtrack(jobs, times, index + 1, k, Math.max(times[i], max));
            }
            times[i] -= jobs[index];
        }
    }
}
