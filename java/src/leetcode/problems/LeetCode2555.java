package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/1/1 19:25
 */
public class LeetCode2555 {

    public int maximizeWin(int[] prizePositions, int k) {
        int ans = 0;
        int left = 0;
        int right = 0;
        int n = prizePositions.length;
        int[] pre = new int[n + 1];
        while (right < n) {
            while (prizePositions[right] - prizePositions[left] > k) {
                left++;
            }
            ans = Math.max(ans, right - left + 1 + pre[left]);
            pre[right + 1] = Math.max(pre[right], right - left + 1);
            right++;
        }
        return ans;
    }
}
