package leetcode.lists.classic;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/12/30 11:15
 */

public class Classic0814 {

    Map<String, int[]> memo;

    int result;

    public int countEval(String s, int result) {
        memo = new HashMap<>();
        this.result = result;
        return dfs(s)[result];
    }

    private int[] dfs(String s) {
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

            int[] left = dfs(s.substring(0, i));
            int[] right = dfs(s.substring(i + 1));

            for (int l = 0; l <= 1; l++) {
                for (int r = 0; r <= 1; r++) {
                    int ret = 0;
                    if (ch == '|') {
                        ret = l | r;
                    } else if (ch == '^') {
                        ret = l ^ r;
                    } else {
                        ret = l & r;
                    }
                    curRes[ret] += left[l] * right[r];
                }
            }
        }
        memo.put(s, curRes);
        return curRes;
    }
}
