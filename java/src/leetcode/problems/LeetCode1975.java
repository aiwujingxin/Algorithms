package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 9/17/25 14:37
 */
public class LeetCode1975 {
    public long maxMatrixSum(int[][] matrix) {
        long sum = 0;
        int negativeCount = 0;
        int minAbs = Integer.MAX_VALUE;
        int n = matrix.length;
        for (int[] ints : matrix) {
            for (int j = 0; j < n; j++) {
                if (ints[j] < 0) {
                    negativeCount++;
                }
                int num = Math.abs(ints[j]);
                sum += num;
                minAbs = Math.min(minAbs, num);
            }
        }
        if (negativeCount % 2 == 0 || minAbs == 0) {
            return sum;
        }
        return sum - minAbs * 2L;
    }
}
