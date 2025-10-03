package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 7/29/25 13:15
 */
public class LeetCode1540 {
    public boolean canConvertString(String s, String t, int k) {
        if (s.length() != t.length()) return false;
        int[] diffs = new int[26];
        int maxStep = 0;
        for (int i = 0; i < s.length(); i++) {
            int diff = (t.charAt(i) - s.charAt(i) + 26) % 26;
            if (diff == 0) continue;
            diffs[diff]++;
            // 计算当前这个diff的第几次出现，需要多少步
            int step = diff + 26 * (diffs[diff] - 1);
            maxStep = Math.max(maxStep, step);
        }
        return maxStep <= k;
    }
}
