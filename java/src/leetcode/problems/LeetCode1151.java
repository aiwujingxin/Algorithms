package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/6/1 16:46
 */
public class LeetCode1151 {

    /**
     * 给出一个二进制数组 data，你需要通过交换位置，将数组中 任何位置 上的 1 组合到一起，并返回所有可能中所需 最少的交换次数。
     */
    int minSwaps(int[] data) {
        int k = 0;
        int n = data.length;
        for (int num : data) {
            if (num == 1) {
                k++;
            }
        }
        int left = 0;
        int right = 0;

        int cnt = 0;
        int max = 0;

        while (right < n) {
            if (data[right] == 1) {
                cnt++;
            }
            while (right - left + 1 > k) {
                if (data[left] == 1) {
                    cnt--;
                }
                left++;
            }
            max = Math.max(cnt, max);
            right++;
        }
        return k - max;
    }
}
