package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 9/16/25 15:24
 */
public class LeetCode2384 {

    public String largestPalindromic(String num) {
        int[] freq = new int[10];
        for (char c : num.toCharArray()) {
            freq[c - '0']++;
        }
        StringBuilder left = new StringBuilder();
        String mid = "";
        for (int d = 9; d >= 0; d--) {
            if (freq[d] % 2 == 1 && mid.isEmpty()) mid = String.valueOf(d);
            int pairs = freq[d] / 2;
            left.append(String.valueOf(d).repeat(pairs));
        }
        // 去掉前导零
        int i = 0;
        while (i < left.length() && left.charAt(i) == '0') i++;
        String l = left.substring(i);
        if (l.isEmpty()) return mid.isEmpty() ? "0" : mid;
        return l + mid + new StringBuilder(l).reverse();
    }
}
