package leetcode.plan.binarysearch.level2;

import java.util.Arrays;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/10/24 01:37
 */
public class LeetCode611_bs {

    //https://leetcode.com/problems/valid-triangle-number/discuss/2183634/JAVA-oror-TWO-POINTERS-oror-BINARY-SEARCH
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int pos = binarySearch(nums, j + 1, nums.length - 1, nums[i] + nums[j] - 1);
                if (pos != -1) {
                    ans += pos - j;
                }
            }
        }

        return ans;
    }

    public int binarySearch(int[] nums, int start, int end, int target) {
        int ans = -1;
        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] <= target) {
                ans = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return ans;
    }
}
