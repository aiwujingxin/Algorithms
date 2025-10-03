package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/11/10 12:44
 */
public class LeetCode76 {

    public String minWindow(String s, String t) {
        int[] need = new int[128];
        for (char c : t.toCharArray()) need[c]++;
        int left = 0, right = 0, count = t.length();
        int len = Integer.MAX_VALUE, start = 0;
        while (right < s.length()) {
            if (need[s.charAt(right++)]-- > 0) count--;
            while (count == 0) {
                if (right - left < len) {
                    len = right - left;
                    start = left;
                }
                if (need[s.charAt(left++)]++ == 0) count++;
            }
        }
        return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);
    }
}
