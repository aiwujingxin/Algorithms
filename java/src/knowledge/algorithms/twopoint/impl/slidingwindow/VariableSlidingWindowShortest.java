package knowledge.algorithms.twopoint.impl.slidingwindow;

/**
 * @author wujingxinit@outlook.com
 * @date 2026/07/26
 * @description 可变长度滑动窗口模板 - 求最短 (Variable Sliding Window - Shortest)
 * <p>
 * 核心思想：
 * 右指针主动扩张，一旦窗口状态满足条件，就尝试更新最短长度，并持续收缩左指针，
 * 寻找可能更短的满足条件的窗口。
 * <p>
 * 适用场景：
 * - 长度最小的子数组（其和 >= target）
 * - 最小覆盖子串
 */
public class VariableSlidingWindowShortest {

    public int slidingWindowShortest(int[] nums, int target) {
        int left = 0;
        int right = 0;
        int sum = 0; // 维护窗口内的状态
        int minLength = Integer.MAX_VALUE;

        while (right < nums.length) {
            // 1. 将右侧元素加入窗口，更新状态
            sum += nums[right];

            // 2. 当窗口状态满足条件时，尝试更新最短长度，并缩小窗口寻找更短的解
            while (sum >= target) { // 替换为具体的满足条件逻辑
                minLength = Math.min(minLength, right - left + 1);

                sum -= nums[left]; // 移出左侧元素
                left++;
            }

            right++;
        }

        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }
}
