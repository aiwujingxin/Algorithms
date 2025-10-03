package leetcode.problems;

import java.util.Arrays;

/**
 * @author wujingxinit@outlook.com
 * @date 7/29/25 13:02
 * @description 限定搜索范围 结合作图
 */
public class LeetCode3132 {
    public int minimumAddedInteger(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        for (int i = 2; i > 0; i--) {
            int x = nums2[0] - nums1[i];
            int j = 0;
            for (int k = i; k < nums1.length; k++) {
                if (nums2[j] == nums1[k] + x) {
                    j++;
                    if (j == nums2.length) {
                        return x;
                    }
                }
            }
        }
        return nums2[0] - nums1[0];
    }
}
