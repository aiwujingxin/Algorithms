package leetcode.lists.lcr;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/9/14 02:33
 */
public class LCR186 {

    public boolean isStraight(int[] nums) {
        Arrays.sort(nums);
        int diff = 0;
        int zero = nums[0] == 0 ? 1 : 0;
        HashSet<Integer> set = new HashSet<>();
        set.add(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            if (set.contains(nums[i]) && nums[i] != 0) {
                return false;
            }
            set.add(nums[i]);
            if (nums[i] == 0) {
                zero++;
            } else {
                if (nums[i] - nums[i - 1] > 1 && nums[i - 1] != 0) {
                    diff += nums[i] - nums[i - 1] - 1;
                }
            }
        }
        return diff <= zero;
    }

    public boolean isStraight_opt(int[] nums) {
        Set<Integer> repeat = new HashSet<>();
        int max = 0, min = 14;
        for (int num : nums) {
            if (num == 0) continue; // 跳过大小王
            max = Math.max(max, num); // 最大牌
            min = Math.min(min, num); // 最小牌
            if (repeat.contains(num)) {
                return false; // 若有重复，提前返回 false
            }
            repeat.add(num); // 添加此牌至 Set
        }
        return max - min < 5; // 最大牌 - 最小牌 < 5 则可构成顺子
    }
}
