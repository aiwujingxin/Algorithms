package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 8/17/25 23:19
 */
public class LeetCode2275 {
    public int largestCombination(int[] candidates) {
        int mx = 0;
        for (int x : candidates) {
            mx = Math.max(mx, x);
        }

        int ans = 0;
        for (int i = 0; i < 24; i++) {
            int cnt = 0;
            for (int x : candidates) {
                cnt += x >> i & 1;
            }
            ans = Math.max(ans, cnt);
        }
        return ans;
    }
}

