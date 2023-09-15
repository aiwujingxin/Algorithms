package leetcode.offer;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/9/13 22:02
 */
public class Offer57 {

    public int[] twoSum(int[] nums, int target) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(target - num)) {
                return new int[]{num, target - num};
            }
            set.add(num);
        }
        return new int[]{};
    }

    public int[] twoSum_fast(int[] nums, int target) {
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            int l = i, r = len - 1, tar = target - nums[i];
            while (l <= r) {
                int mid = (l + r) >>> 1;
                if (nums[mid] < tar) {
                    l = mid + 1;
                } else if (nums[mid] == tar) {
                    return new int[]{nums[mid], nums[i]};
                } else {
                    r = mid - 1;
                }
            }
        }
        return new int[]{};
    }
}
