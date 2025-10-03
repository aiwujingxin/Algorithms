package leetcode.problems;

import java.util.Arrays;

/**
 * @author wujingxinit@outlook.com
 * @date 7/29/25 13:12
 */
public class LeetCode1366 {
    public String rankTeams(String[] votes) {
        int n = votes[0].length();
        int[][] count = new int[26][n]; // count[team][position] = votes
        for (String vote : votes) {
            for (int i = 0; i < vote.length(); i++) {
                count[vote.charAt(i) - 'A'][i]++;
            }
        }

        Character[] teams = new Character[n];
        for (int i = 0; i < n; i++) {
            teams[i] = votes[0].charAt(i); // 所有投票字符串中都包含相同队伍
        }

        Arrays.sort(teams, (a, b) -> {
            for (int i = 0; i < n; i++) {
                if (count[a - 'A'][i] != count[b - 'A'][i]) {
                    return count[b - 'A'][i] - count[a - 'A'][i]; // 票数多的排前
                }
            }
            return a - b; // 字母序
        });

        StringBuilder sb = new StringBuilder();
        for (char c : teams)
            sb.append(c);
        return sb.toString();
    }
}
