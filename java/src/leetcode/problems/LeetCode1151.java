package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/6/1 16:46
 */
public class LeetCode1151 {

    int minSwaps(int[] data) {
        int k = 0;
        int n = data.length;
        for (int x : data) {
            if (x == 1) {
                k++;
            }
        }
        int cnt = 0;
        int max = 0;
        int left = 0;
        int right = 0;
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
