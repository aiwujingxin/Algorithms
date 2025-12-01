package leetcode.problems;

import java.util.Arrays;

/**
 * @author wujingxinit@outlook.com
 * @date 11/24/25 15:08
 * @see LeetCode47
 */
public class LeetCode1079 {

    public int numTilePossibilities(String tiles) {
        char[] chars = tiles.toCharArray();
        Arrays.sort(chars);
        return backtrack(chars, new boolean[chars.length]);
    }

    private int backtrack(char[] chars, boolean[] used) {
        int count = 0;
        for (int i = 0; i < chars.length; i++) {
            if (used[i]) continue;
            if (i > 0 && chars[i] == chars[i - 1] && !used[i - 1]) continue;
            used[i] = true;
            count++;
            count += backtrack(chars, used);
            used[i] = false;
        }
        return count;
    }
}
