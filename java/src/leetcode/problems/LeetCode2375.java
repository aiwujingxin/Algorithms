package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 9/17/25 13:47
 */
public class LeetCode2375 {

    StringBuilder res = new StringBuilder();

    public String smallestNumber(String pattern) {
        for (int i = 1; i <= 9; i++) {
            StringBuilder sb = new StringBuilder();
            boolean[] used = new boolean[10];
            used[i] = true;
            sb.append(i);
            if (backtrack(pattern, 0, sb, used)) {
                break;
            }
        }
        return res.toString();
    }

    private boolean backtrack(String pattern, int idx, StringBuilder sb, boolean[] used) {
        if (idx == pattern.length()) {
            if (res.isEmpty() || sb.toString().compareTo(res.toString()) < 0) {
                res = sb;
            }
            return true;
        }
        char c = pattern.charAt(idx);
        int last = sb.charAt(sb.length() - 1) - '0';
        int start = c == 'I' ? last + 1 : 1;
        int end = c == 'D' ? last - 1 : 9;
        for (int num = start; num <= end; num++) {
            if (num < 1 || num > 9 || used[num]) continue;
            used[num] = true;
            sb.append(num);
            if (backtrack(pattern, idx + 1, sb, used)) {
                return true;
            }
            sb.deleteCharAt(sb.length() - 1);
            used[num] = false;
        }
        return false;
    }
}
