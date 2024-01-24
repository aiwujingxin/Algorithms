package leetcode.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/1/24 12:41
 */
public class LeetCode2094 {

    public int[] findEvenNumbers(int[] digits) {
        Arrays.sort(digits);
        boolean[] used = new boolean[digits.length];
        List<Integer> list = new ArrayList<>();
        backtrack(digits, list, new StringBuilder(), used);
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    private void backtrack(int[] digits, List<Integer> list, StringBuilder sb, boolean[] used) {
        if (sb.length() == 3) {
            if (sb.charAt(0) != '0' && Integer.parseInt(sb.toString()) % 2 == 0) {
                list.add(Integer.parseInt(sb.toString()));
            }
            return;
        }
        for (int i = 0; i < digits.length; i++) {
            if (used[i]) {
                continue;
            }
            if (i > 0 && digits[i] == digits[i - 1] && !used[i - 1]) {
                continue;
            }
            if (sb.length() == 2 && digits[i] % 2 != 0) {
                continue;
            }
            used[i] = true;
            sb.append(digits[i]);
            backtrack(digits, list, sb, used);
            sb.deleteCharAt(sb.length() - 1);
            used[i] = false;
        }
    }
}
