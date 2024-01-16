package leetcode.problems;

import java.util.HashSet;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/1/16 20:21
 */
public class LeetCode967 {

    public int[] numsSameConsecDiff(int n, int k) {
        HashSet<String> set = new HashSet<>();
        backtrack(set, n, k, new StringBuilder());
        int[] res = new int[set.size()];

        int index = 0;
        for (String s : set) {
            res[index] = Integer.parseInt(s);
            index++;
        }
        return res;
    }

    private void backtrack(HashSet<String> list, int n, int k, StringBuilder sb) {
        if (sb.length() > n) {
            return;
        }
        if (sb.length() == n) {
            if (sb.length() > 1 && sb.charAt(0) == '0') {
                return;
            }
            list.add(sb.toString());
            return;
        }
        if (sb.isEmpty()) {
            for (int i = 1; i <= 9; i++) {
                sb.append(i);
                backtrack(list, n, k, sb);
                sb.deleteCharAt(sb.length() - 1);
            }
        } else {
            int last = sb.charAt(sb.length() - 1) - '0';
            if (last + k <= 9 && last + k >= 0) {
                sb.append(last + k);
                backtrack(list, n, k, sb);
                sb.deleteCharAt(sb.length() - 1);
            }
            if (last - k <= 9 && last - k >= 0) {
                sb.append((last - k));
                backtrack(list, n, k, sb);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }
}
