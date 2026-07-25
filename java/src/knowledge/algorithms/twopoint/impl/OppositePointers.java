package knowledge.algorithms.twopoint.impl;

/**
 * @author wujingxinit@outlook.com
 * @date 2026/07/26
 * @description 相向双指针模板 (Opposite Pointers Template)
 * 常用于有序数组/字符串中的查找、反转等问题，例如两数之和、反转字符串。
 */
public class OppositePointers {

    /**
     * 相向双指针标准模板
     *
     * @param nums   输入数组
     * @param target 目标值
     * @return 结果下标数组，未找到返回空数组
     */
    public int[] oppositePointers(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            // 根据具体问题计算当前状态
            int currentStatus = nums[left] + nums[right];

            if (currentStatus == target) {
                // 找到目标，返回或记录结果
                return new int[]{left, right};
            } else if (currentStatus < target) {
                // 当前值偏小，左指针右移
                left++;
            } else {
                // 当前值偏大，右指针左移
                right--;
            }
        }

        return new int[0];
    }
}
