package leetcode.problems;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/4/2 01:44
 * @description 子集
 */
public class LeetCode473_v1 {

    int[] matchsticks;
    int n;

    public boolean makesquare(int[] matchsticks) {
        int sum = 0;
        for (int matchstick : matchsticks) {
            sum += matchstick;
        }
        if (sum % 4 != 0) {
            return false;
        }
        Arrays.sort(matchsticks);
        reverse(matchsticks);
        this.matchsticks = matchsticks;
        this.n = matchsticks.length;
        return backtrack(0, sum / 4, 0, 0, sum, new boolean[n]);
    }

    private boolean backtrack(int cur, int target, int k, int len, int remain, boolean[] visited) {
        if (k == 4 && remain == 0) {
            return true;
        }
        if ((remain + len) % (4 - k) != 0) {
            return false;
        }
        if (remain + len < target) {
            return false;
        }

        if (len == target) {
            return backtrack(0, target, k + 1, 0, remain, visited);
        }

        for (int i = cur; i < n; i++) {
            if (len + matchsticks[i] > target) {
                continue;
            }
            if (i > 0 && matchsticks[i] == matchsticks[i - 1] && !visited[i - 1]) {
                continue;
            }
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            if (backtrack(i + 1, target, k, len + matchsticks[i], remain - matchsticks[i], visited)) {
                return true;
            }
            visited[i] = false;
        }
        return false;
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
