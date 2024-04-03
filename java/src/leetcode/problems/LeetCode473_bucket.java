package leetcode.problems;

import java.util.Arrays;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/4/2 01:44
 * @description 子集
 */
public class LeetCode473_bucket {

    int[] matchsticks;
    int n;
    int sum;
    int target;
    boolean[] visited;

    public boolean makesquare(int[] matchsticks) {
        for (int matchstick : matchsticks) {
            sum += matchstick;
        }
        if (sum % 4 != 0) {
            return false;
        }
        this.n = matchsticks.length;
        this.target = sum / 4;
        this.visited = new boolean[n];
        Arrays.sort(matchsticks);
        reverse(matchsticks);
        this.matchsticks = matchsticks;
        return backtrack(0, 0, 0);
    }

    private boolean backtrack(int start, int k, int len) {
        if (k == 4) {
            return true;
        }
        if (len > sum / 4) {
            return false;
        }
        if (len == sum / 4) {
            return backtrack(0, k + 1, 0);
        }
        for (int i = start; i < n; i++) {
            if (i > 0 && matchsticks[i] == matchsticks[i - 1] && !visited[i - 1]) {
                continue;
            }
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            if (backtrack(i + 1, k, len + matchsticks[i])) {
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
