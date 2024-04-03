package leetcode.problems;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/4/2 14:39
 */
public class LeetCode1723_bucket {

    int res = Integer.MAX_VALUE;
    int n;
    int k;
    int full;

    public int minimumTimeRequired(int[] jobs, int k) {
        this.n = jobs.length;
        this.k = k;
        this.full = (int) Math.pow(2, n) - 1;
        Arrays.sort(jobs);
        reverse(jobs);
        backtrack(jobs, 0, 0, 0, new int[k], 0, 0);
        return res;
    }

    private void backtrack(int[] jobs, int start, int people, int time, int[] times, int max, int used) {
        if (people == k) {
            if (used == full) {
                res = Math.min(res, max);
            }
            return;
        }
        if (max > res) {
            return;
        }
        if (people > 0 && (times[people - 1] == 0)) {
            return;
        }
        if (max > 0) {
            backtrack(jobs, 0, people + 1, 0, times, max, used);
        }
        // 哪些 job 分配给当前的人？相当于子集
        HashSet<Integer> set = new HashSet<>();
        for (int i = start; i < n; i++) {
            if (((used >> i) & 1) == 1) {
                continue;
            }
            if (time + jobs[i] > res) {
                continue;
            }
            if (set.contains((used |= 1 << i) ^ full)) {
                continue;
            }
            used |= 1 << i;
            set.add(used);
            times[people] += jobs[i];
            backtrack(jobs, i + 1, people, time + jobs[i], times, Math.max(time + jobs[i], max), used);
            times[people] -= jobs[i];
            used ^= 1 << i;
        }
    }

    public void reverse(int[] nums) {
        int i = 0;
        int j = nums.length - 1;
        while (i < j) {
            int t = nums[i];
            nums[i] = nums[j];
            nums[j] = t;
            i++;
            j--;
        }
    }
}
