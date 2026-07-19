package leetcode.problems;


import java.util.Arrays;

/**
 * @author wujingxinit@outlook.com
 * @date 6/13/26 20:37
 */
public class LeetCode948 {

    public int bagOfTokensScore(int[] tokens, int power) {
        int n = tokens.length;
        Arrays.sort(tokens);
        int ans = 0;
        int i = 0;
        int j = n - 1;
        // 尽可能 拿 1分换取最大的能量， 用能量换大的分数
        while (i <= j) {
            if (power >= tokens[i]) {
                ans++;
                power -= tokens[i];
                i++;
            } else {
                if (ans >= 1 && i != j) {
                    ans--;
                    power += tokens[j];
                    j--;
                } else {
                    if (power >= tokens[i]) {
                        ans++;
                        power -= tokens[i];
                        i++;
                    } else {
                        break;
                    }
                }
            }
        }
        return ans;
    }
}
