package leetcode.problems;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/1/29 10:44
 */
public class LeetCode2900 {

    public List<String> getWordsInLongestSubsequence(int n, String[] words, int[] groups) {
        List<String> s1 = new ArrayList<>();
        List<String> s0 = new ArrayList<>();
        int[] dp0 = new int[n];
        dp0[0] = groups[0] == 0 ? 1 : 0;
        if (groups[0] == 0) {
            s0.add(words[0]);
        }
        int[] dp1 = new int[n];
        dp1[0] = groups[0] == 1 ? 1 : 0;
        if (groups[0] == 1) {
            s1.add(words[0]);
        }
        for (int i = 1; i < groups.length; i++) {
            if (groups[i] == 1) {
                dp1[i] = dp0[i - 1] + 1;
                s1 = new ArrayList<>(s0);
                s1.add(words[i]);
                dp0[i] = dp0[i - 1];
            } else {
                dp0[i] = dp1[i - 1] + 1;
                s0 = new ArrayList<>(s1);
                s0.add(words[i]);
                dp1[i] = dp1[i - 1];
            }
        }
        if (dp0[n - 1] > dp1[n - 1]) {
            return s0;
        }
        return s1;
    }
}
