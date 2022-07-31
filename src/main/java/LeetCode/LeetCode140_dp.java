package LeetCode;

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
        if (s == null || s.length() == 0 || wordDict == null) {
            return rst;
        }

        boolean[] canBreak = new boolean[s.length()];
        Arrays.fill(canBreak, true);
        StringBuilder sb = new StringBuilder();
        dfs(rst, sb, s, new HashSet<>(wordDict), canBreak, 0);
        return rst;
    }

    private void dfs(List<String> rst, StringBuilder sb, String s, Set<String> dict, boolean[] canBreak, int start) {
        if (start == s.length()) {
            rst.add(sb.substring(1));
            return;
        }

        if (!canBreak[start]) {
            return;
        }

        for (int i = start + 1; i <= s.length(); i++) {
            String word = s.substring(start, i);
            if (!dict.contains(word)) continue;

            int sbBeforeAdd = sb.length();
            sb.append(" ").append(word);

            int rstBeforeDFS = rst.size();
            dfs(rst, sb, s, dict, canBreak, i);
            if (rst.size() == rstBeforeDFS) {
                canBreak[i] = false;
            }
            sb.delete(sbBeforeAdd, sb.length());
        }
    }
}