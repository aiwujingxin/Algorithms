package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/6/1 19:21
 */
public class LeetCode1208 {

    public int equalSubstring(String s, String t, int maxCost) {
        int n = s.length();
        int[] accDiff = new int[n + 1];
        for (int i = 0; i < n; i++) {
            accDiff[i + 1] = accDiff[i] + Math.abs(s.charAt(i) - t.charAt(i));
        }
        int maxLength = 0;
        for (int i = 1; i <= n; i++) {
            int start = leftBound(accDiff, i, accDiff[i] - maxCost);
            maxLength = Math.max(maxLength, i - start);
        }
        return maxLength;
    }

    public int leftBound(int[] accDiff, int endIndex, int target) {
        int left = 0, right = endIndex;
        while (left < right) {
            int mid = (right - left) / 2 + left;
            if (accDiff[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}
