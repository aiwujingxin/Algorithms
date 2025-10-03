package leetcode.problems;

import java.util.Arrays;

/**
 * @author wujingxinit@outlook.com
 * @date 9/9/25 16:42
 */
public class LeetCode1402 {
    public int maxSatisfaction(int[] satisfaction) {
        int n = satisfaction.length;
        Arrays.sort(satisfaction);
        int max = 0;
        for (int cnt = 1; cnt < n; cnt++) {
            int score = cal(satisfaction, cnt);
            if(score <=0) break;
            max = Math.max(score, max);
        }
        return Math.max(max, 0);
    }

    public int cal(int[] satisfaction, int cnt) {
        int time = 1;
        int score = 0;
        for (int i = satisfaction.length - 1 - cnt; i < satisfaction.length; i++) {
            score += satisfaction[i] * time;
            time++;
        }
        return score;
    }
}
