package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/6/1 19:16
 */
public class LeetCode1208_sd {

    public int equalSubstring(String s, String t, int maxCost) {
        int n = s.length();
        int[] diff = new int[n];
        for (int i = 0; i < n; i++) {
            diff[i] = Math.abs(s.charAt(i) - t.charAt(i));
        }
        int max = 0;
        int left = 0, right = 0;
        int count = 0;
        while (right < n) {
            count += diff[right];
            while (count > maxCost) {
                count -= diff[left];
                left++;
            }
            max = Math.max(max, right - left + 1);
            right++;
        }
        return max;
    }
}
