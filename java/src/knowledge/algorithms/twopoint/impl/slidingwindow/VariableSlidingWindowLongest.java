package knowledge.algorithms.twopoint.impl.slidingwindow;

/**
 * @author wujingxinit@outlook.com
 * @date 2026/07/26
 * @description 可变长度滑动窗口模板 - 求最长 (Variable Sliding Window - Longest)
 * <p>
 * 核心思想：
 * 右指针主动扩张寻找解，当窗口状态不满足条件时，左指针持续收缩直到窗口重新满足条件。
 * <p>
 * 适用场景：
 * - 无重复字符的最长子串
 * - 最多包含 k 个不同字符的最长子串
 * - 满足某条件（如和 <= target）的最长子数组
 */
public class VariableSlidingWindowLongest {

    public int slidingWindowLongest(int[] nums, int target) {
        int left = 0;
        int right = 0;
        int sum = 0; // 维护窗口内的状态
        int maxLength = 0;

        while (right < nums.length) {
            // 1. 将右侧元素加入窗口，更新状态
            sum += nums[right];

            // 2. 若窗口状态不满足条件，持续缩小窗口，直到重新满足条件
            while (sum > target) { // 替换为具体的不满足条件逻辑
                sum -= nums[left]; // 移出左侧元素
                left++;
            }

            // 3. 此时窗口必定满足条件，更新最大长度
            maxLength = Math.max(maxLength, right - left + 1);

            right++;
        }

        return maxLength;
    }
}
