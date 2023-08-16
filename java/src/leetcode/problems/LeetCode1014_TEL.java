package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/10/11 20:40
 */
public class LeetCode1014_TEL {

    public int maxScoreSightseeingPair(int[] values) {
        if (values == null || values.length == 0) {
            return 0;
        }
        int max = 0;
        for (int i = 0; i < values.length; i++) {
            for (int j = i + 1; j < values.length; j++) {
                int temp = values[j] + values[i] + i - j;
                max = Math.max(max, temp);
            }
        }
        return max;
    }
}
