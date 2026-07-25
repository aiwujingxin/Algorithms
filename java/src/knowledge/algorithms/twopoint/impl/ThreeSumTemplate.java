package knowledge.algorithms.twopoint.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author wujingxinit@outlook.com
 * @date 2026/07/26
 * @description 三数之和模板 (Three Sum Template)
 * 结合排序和相向双指针，用于在数组中寻找三个数，使得其和为特定值。
 */
public class ThreeSumTemplate {

    /**
     * 三数之和标准模板
     *
     * @param nums 输入数组
     * @return 所有和为 0 的不重复三元组
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        // 必须先排序
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            // 避免固定位的重复枚举
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int left = i + 1;
            int right = nums.length - 1;
            int target = -nums[i]; // 将三数之和转化为两数之和

            while (left < right) {
                int sum = nums[left] + nums[right];

                if (sum == target) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    // 跳过重复元素
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    while (left < right && nums[right] == nums[right - 1]) right--;

                    left++;
                    right--;
                } else if (sum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return result;
    }
}
