package leetcode.problems;


import java.util.ArrayList;
import java.util.List;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/9/28 01:56
 */
public class LeetCode212_dp {

    //https://leetcode.com/problems/word-break-ii/discuss/2527158/Java-solution-or-1ms-or-faster-than-99

    public List<String> wordBreak(String s, List<String> wordDict) {
        List<List<String>> dp = new ArrayList<>();

        for (int i = 0; i < s.length() + 1; i++) {
            dp.add(new ArrayList<>());
        }

        dp.get(0).add("");

        for (int i = 0; i < s.length() + 1; i++) {
            for (String word : wordDict) {
                if (s.substring(i).indexOf(word) == 0) {
                    for (String phrase : dp.get(i)) {
                        StringBuilder sb = new StringBuilder(phrase);
                        if (phrase.length() > 0) {
                            sb.append(" ");
                        }

                        sb.append(word);
                        dp.get(i + word.length()).add(sb.toString());
                    }
                }
            }
        }

        return dp.get(s.length());
    }
}
