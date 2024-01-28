package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/1/28 15:24
 */
public class LeetCode945 {

    public int minIncrementForUnique(int[] nums) {
        int maxNum = 0;
        for (int num : nums) {
            maxNum = Math.max(maxNum, num);
        }
        int[] counts = new int[maxNum + 1];
        for (int num : nums) {
            counts[num]++;
        }
        int res = 0;
        for (int i = 0; i < maxNum; i++) {
            if (counts[i] > 1) {
                int cnt = counts[i] - 1;
                // 向后搬运
                counts[i] -= cnt;
                counts[i + 1] += cnt;
                res += cnt;
            }
        }
        if (counts[maxNum] > 1) {
            res += counts[maxNum] * (counts[maxNum] - 1) / 2;
        }
        return res;
    }
}
