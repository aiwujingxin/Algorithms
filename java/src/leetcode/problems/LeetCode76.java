package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/11/10 12:44
 */
public class LeetCode76 {

    public String minWindow(String s, String t) {
        int[] sArr = new int[256], tArr = new int[256];
        int need = 0;
        for (char c : t.toCharArray()) {
            if (tArr[c] == 0) need++;
            tArr[c]++;
        }
        int l = 0;
        int r = 0;
        int valid = 0;
        int start = 0;
        int minLen = Integer.MAX_VALUE;
        while (r < s.length()) {
            char c = s.charAt(r);
            sArr[c]++;
            if (sArr[c] == tArr[c]) valid++;
            while (valid == need) {
                if (r - l + 1 < minLen) {
                    minLen = r - l + 1;
                    start = l;
                }
                char d = s.charAt(l);
                if (sArr[d] == tArr[d]) valid--;
                sArr[d]--;
                l++;
            }
            r++;
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    }
}
