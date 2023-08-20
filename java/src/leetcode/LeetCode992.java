package leetcode;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/6/6 23:33
 */
public class LeetCode992 {

    //https://mp.weixin.qq.com/s/y52x_rTSOpyte6c9G5pO5g;

    public int subarraysWithKDistinct(int[] nums, int k) {
        int n = nums.length;
        int[] lower = new int[n], upper = new int[n];
        find(lower, nums, k);
        find(upper, nums, k - 1);
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans += upper[i] - lower[i];
        }
        return ans;
    }

    void find(int[] arr, int[] nums, int k) {
        int n = nums.length;
        int[] cnt = new int[n + 1];
        int count = 0;
        for (int i = 0, j = 0; i < n; i++) {
            int right = nums[i];
            if (cnt[right] == 0) {
                count++;
            }
            cnt[right]++;
            while (count > k) {
                int left = nums[j++];
                cnt[left]--;
                if (cnt[left] == 0) {
                    count--;
                }
            }
            arr[i] = j;
        }
    }
}
