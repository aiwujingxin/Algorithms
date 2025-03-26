package leetcode.lists.classic;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 3/3/25 23:11
 */
public class Classic0814 {

    public int countEval(String s, int result) {
        Map<String, int[]> memo = new HashMap<>();
        return dfs(s, memo)[result];
    }

    private int[] dfs(String s, Map<String, int[]> memo) {
        if (memo.containsKey(s)) {
            return memo.get(s);
        }
        if (s.length() == 1) {
            int[] curRes = new int[2];
            if (s.charAt(0) == '0') {
                curRes[0]++;
            } else {
                curRes[1]++;
            }
            memo.put(s, curRes);
            return curRes;
        }

        int[] curRes = new int[2];
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch >= '0' && ch <= '9') {
                continue;
            }

            int[] left = dfs(s.substring(0, i), memo);
            int[] right = dfs(s.substring(i + 1), memo);

            for (int l = 0; l <= 1; l++) {
                for (int r = 0; r <= 1; r++) {
                    int ret;
                    if (ch == '|') {
                        ret = l | r;
                    } else if (ch == '^') {
                        ret = l ^ r;
                    } else {
                        ret = l & r;
                    }
                    if (ret == 0) {
                        curRes[0] += left[l] * right[r];
                    } else {
                        curRes[1] += left[l] * right[r];
                    }
                }
            }
        }
        memo.put(s, curRes);
        return curRes;
    }
}
