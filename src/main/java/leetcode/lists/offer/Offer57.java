package leetcode.lists.offer;

import java.util.*;

/**
 * @author jingxinwu
 * @date 2021-11-25 12:54 上午
 */
public class Offer57 {

    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[]{};
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        int[] res = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(target - nums[i])) {
                map.put(nums[i], i);
            } else {
                res[0] = i;
                res[1] = map.get(target - nums[i]);
                break;
            }
        }
        return res;
    }

    public int[] twoSumV2(int[] nums, int target) {
        int i = 0, j = nums.length - 1;
        while (i < j) {
            int s = nums[i] + nums[j];
            if (s < target) {
                i++;
            } else if (s > target) {
                j--;
            } else {
                return new int[]{nums[i], nums[j]};
            }
        }
        return new int[0];
    }
}
