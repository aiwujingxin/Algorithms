package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/6/18 12:45
 */
public class LeetCode1248_sd {

    public int numberOfSubarrays(int[] nums, int k) {
        int left = 0, right = 0, oddCnt = 0, res = 0;
        while (right < nums.length) {
            if ((nums[right++] & 1) == 1) {
                oddCnt++;
            }
            if (oddCnt ==
                    k) {
                int tmp = right;
                while (right < nums.length && (nums[right] & 1) == 0) {
                    right++;
                }
                int rightEvenCnt = right - tmp;
                int leftEvenCnt = 0;
                while ((nums[left] & 1) == 0) {
                    leftEvenCnt++;
                    left++;
                }
                res += (leftEvenCnt + 1) * (rightEvenCnt + 1);
                left++;
                oddCnt--;
            }
        }
        return res;
    }
}
