package knowledge.algorithms.twopoint.impl.slidingwindow;

/**
 * @author wujingxinit@outlook.com
 * @date 2026/07/26
 * @description 固定长度滑动窗口模板 (Fixed Sliding Window)
 * <p>
 * 核心思想：
 * 窗口大小固定为 k，在滑动过程中，每次右移只需加上新进入窗口的元素，并减去离开窗口的元素。
 * <p>
 * 适用场景：
 * - 寻找长度为 K 的子数组的最大和/平均值等。
 */
public class FixedSlidingWindow {

    public int slidingWindowFixed(int[] nums, int k) {
        if (nums == null || nums.length < k || k <= 0) {
            return 0; // 或抛出异常，视具体题目而定
        }

        int sum = 0;
        int res = 0;

        // 1. 初始化第一个窗口
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        res = sum;

        // 2. 窗口开始滑动
        for (int i = k; i < nums.length; i++) {
            // 加上右侧新元素，减去左侧移出窗口的元素
            sum += nums[i] - nums[i - k];

            // 3. 更新全局答案
            res = Math.max(res, sum);
        }

        return res;
    }
}
