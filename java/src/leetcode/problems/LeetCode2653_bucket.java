package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 7/26/26 18:57
 */
public class LeetCode2653_bucket {

    int offset = 50;

    public int[] getSubarrayBeauty(int[] nums, int k, int x) {
        int n = nums.length;
        int[] counts = new int[101];
        int[] ans = new int[n - k + 1];
        for (int i = 0; i < n; i++) {
            counts[nums[i] + offset]++;
            if (i >= k - 1) {
                ans[i - k + 1] = Math.min(get(counts, x), 0);
            }
            if (i - k + 1 >= 0) {
                counts[nums[i - k + 1] + offset]--;
            }
        }
        return ans;
    }

    public int get(int[] counts, int x) {
        int cnt = 0;
        int index = 0;
        while (cnt < x) {
            cnt += counts[index];
            index++;
        }
        return index - offset - 1;
    }
}
