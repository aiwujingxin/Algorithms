package leetcode.problems;

import java.util.Arrays;
import java.util.Objects;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/1/31 10:47
 */
public class LeetCode949 {

    String ans = "";

    public String largestTimeFromDigits(int[] arr) {
        Arrays.sort(arr);
        boolean[] used = new boolean[arr.length];
        backtrack(arr, 0, new StringBuilder(), used);
        return "".equals(ans) ? "" : ans.substring(0, 2) + ":" + ans.substring(2, 4);
    }

    private void backtrack(int[] arr, int index, StringBuilder sb, boolean[] used) {
        if (index == arr.length) {
            if (compare(ans, sb.toString())) {
                ans = sb.toString();
            }
            return;
        }

        if (sb.length() >= 2 && Integer.parseInt(sb.substring(0, 2)) >= 24) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            if (used[i]) {
                continue;
            }
            if (i > 0 && arr[i] == arr[i - 1] && !used[i - 1]) {
                continue;
            }
            used[i] = true;
            sb.append(arr[i]);
            backtrack(arr, index + 1, sb, used);
            sb.deleteCharAt(sb.length() - 1);
            used[i] = false;
        }
    }


    private boolean compare(String ans, String t) {
        int thour = Integer.parseInt(t.substring(0, 2));
        int tmin = Integer.parseInt(t.substring(2, 4));
        if (thour >= 24 || tmin > 59) {
            return false;
        }
        if (Objects.equals(ans, "")) {
            return true;
        }
        int ahour = Integer.parseInt(ans.substring(0, 2));
        int amin = Integer.parseInt(ans.substring(2, 4));
        if (thour > ahour) {
            return true;
        }
        if (thour < ahour) {
            return false;
        }
        if (tmin > amin) {
            return true;
        }
        if (tmin < amin) {
            return false;
        }
        return true;
    }
}
