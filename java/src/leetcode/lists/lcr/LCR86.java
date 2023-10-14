package leetcode.lists.lcr;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/9/28 16:43
 */
public class LCR86 {

    List<List<String>> list = new ArrayList<>();
    boolean[][] dp;

    public String[][] partition(String s) {
        if (s == null || s.isEmpty()) {
            return new String[][]{};
        }
        int n = s.length();
        dp = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                if (s.charAt(j) == s.charAt(i) && (i - j < 3 || dp[j + 1][i - 1])) {
                    dp[j][i] = true;
                }
            }
        }
        backtrack(s, 0, new ArrayList<>());
        String[][] res = new String[list.size()][];
        for (int i = 0; i < list.size(); i++) {
            String[] l = new String[list.get(i).size()];
            for (int j = 0; j < list.get(i).size(); j++) {
                l[j] = list.get(i).get(j);
            }
            res[i] = l;
        }
        return res;
    }

    private void backtrack(String s, int i, ArrayList<String> temp) {
        if (i == s.length()) {
            list.add(new ArrayList<>(temp));
            return;
        }
        for (int j = i; j < s.length(); ++j) {
            if (dp[i][j]) {
                temp.add(s.substring(i, j + 1));
                backtrack(s, j + 1, temp);
                temp.remove(temp.size() - 1);
            }
        }
    }
}
