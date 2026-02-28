package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/11/10 12:44
 */
public class LeetCode76 {

    public String minWindow(String s, String t) {
        int[] sArr = new int[256], tArr = new int[256];
        int target = 0;
        for (char c : t.toCharArray()) {
            if (tArr[c] == 0) target++;
            tArr[c]++;
        }
        int left = 0;
        int right = 0;
        int valid = 0;
        int start = 0;
        int minLen = Integer.MAX_VALUE;
        while (right < s.length()) {
            char c = s.charAt(right);
            sArr[c]++;
            if (sArr[c] == tArr[c]) valid++;
            while (valid == target) {
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    start = left;
                }
                char d = s.charAt(left);
                if (sArr[d] == tArr[d]) valid--;
                sArr[d]--;
                left++;
            }
            right++;
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    }
}
