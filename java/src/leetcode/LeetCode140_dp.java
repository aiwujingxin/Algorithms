package leetcode;

import java.util.*;

/**
 * @author aiwujingxin@gmail.com
 * @date 2022/7/8 00:13
 */
public class LeetCode140_dp {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("cat");
        list.add("cats");
        list.add("and");
        list.add("sand");
        list.add("dog");
        System.out.println(new LeetCode140_dp().wordBreak("catsanddog", list));
    }


    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> rst = new ArrayList<>();
        if (s == null || s.isEmpty() || wordDict == null) {
            return rst;
        }

        boolean[] dp = new boolean[s.length()];
        Arrays.fill(dp, true);
        StringBuilder sb = new StringBuilder();
        dfs(0, rst, sb, s, new HashSet<>(wordDict), dp);
        System.out.println(Arrays.toString(dp));
        return rst;
    }

    private void dfs(int index, List<String> rst, StringBuilder sb, String s, Set<String> dict, boolean[] dp) {
        if (index == s.length()) {
            rst.add(sb.substring(1));
            return;
        }

        if (!dp[index]) {
            return;
        }

        for (int i = index + 1; i <= s.length(); i++) {
            String word = s.substring(index, i);
            if (!dict.contains(word)) {
                continue;
            }
            int sbBeforeAdd = sb.length();
            sb.append(" ").append(word);

            int rstBeforeDFS = rst.size();
            dfs(i, rst, sb, s, dict, dp);
            if (rst.size() == rstBeforeDFS) {
                dp[i] = false;
            }
            sb.delete(sbBeforeAdd, sb.length());
        }
    }
}
