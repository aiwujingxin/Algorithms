package leetcode.problems;

import java.util.*;

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
            for (int j = i + 1; j < nums.length - 1; j++) {
                int pos = binarySearch(nums, j + 1, nums.length - 1, nums[i] + nums[j] - 1);
                if (pos >= nums.length || (pos == j + 1 && nums[i] + nums[j] <= nums[pos])) {
                    continue;
                }
                ans += pos - j;
            }
        }
        return ans;
    }


    public int binarySearch(int[] nums, int start, int end, int target) {
        int l = start;
        int r = end;
        while (l < r) {
            int mid = l + r + 1 >> 1;
            if (nums[mid] <= target) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }
}
