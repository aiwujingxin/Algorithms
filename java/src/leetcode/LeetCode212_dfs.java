package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/9/28 01:57
 */
public class LeetCode212_dfs {


    //https://leetcode.com/problems/word-break-ii/discuss/2236602/Java-implementation-or-3ms
    private List<String> output;

    public List<String> wordBreak(String s, List<String> wordDict) {
        output = new ArrayList<>();
        find(s, 0, s.length() - 1, wordDict, new ArrayList<>());
        return output;
    }

    private void find(String s, int l, int r, List<String> wordDict, List<String> list) {
        if (l > r) {
            java.util.StringJoiner stringJoiner = new java.util.StringJoiner(" ");
            list.forEach(stringJoiner::add);
            output.add(stringJoiner.toString());
            return;
        }
        for (int i = l; i <= r; ++i) {
            String substring = s.substring(l, i + 1);
            if (wordDict.contains(substring)) {
                list.add(substring);
                find(s, i + 1, r, wordDict, list);
                list.remove(list.size() - 1);
            }
        }
    }
}
