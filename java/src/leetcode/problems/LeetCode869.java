package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/2/4 13:38
 */
public class LeetCode869 {

    boolean[] used;

    public boolean reorderedPowerOf2(int n) {
        if (n == 1) {
            return true;
        }
        String s = String.valueOf(n);
        int len = s.length();
        used = new boolean[len];
        return backtrack(s, new StringBuilder());
    }

    private boolean backtrack(String s, StringBuilder sb) {
        if (sb.length() == s.length()) {
            if (sb.length() > 1 && sb.charAt(0) == '0') {
                return false;
            }
            int num = Integer.parseInt(sb.toString());
            return (num - (num & -num)) == 0;
        }

        for (int i = 0; i < s.length(); i++) {
            if (used[i]) {
                continue;
            }
            used[i] = true;
            sb.append(s.charAt(i));
            if (backtrack(s, sb)) {
                return true;
            }
            sb.deleteCharAt(sb.length() - 1);
            used[i] = false;
        }
        return false;
    }
}
