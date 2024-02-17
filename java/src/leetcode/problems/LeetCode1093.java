package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/1/29 12:55
 */
public class LeetCode1093 {

    public double[] sampleStats(int[] count) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        long sum = 0;
        int cnt = 0;
        int maxCount = 0;
        int mode = 0;
        for (int i = 0; i < count.length; i++) {
            if (count[i] > 0) {
                min = Math.min(min, i);
                max = Math.max(max, i);
                sum += (long) i * count[i];
                cnt += count[i];
                if (count[i] > maxCount) {
                    mode = i;
                    maxCount = count[i];
                }
            }
        }

        int first = -1;
        int second = -1;
        int index0 = (cnt + 1) / 2;
        int index1 = (cnt + 1) / 2 + 1;

        int cur = 0;
        for (int i = 0; i < count.length; i++) {
            if (cur + count[i] >= index0 && first == -1) {
                first = i;
            }
            if (cur + count[i] >= index1 && second == -1) {
                second = i;
            }
            cur += count[i];
        }
        if (cnt % 2 == 1) {
            return new double[]{min, max, (double) sum / cnt, first, mode};
        }
        return new double[]{min, max, (double) sum / cnt, (double) (first + second) / 2, mode};
    }
}
