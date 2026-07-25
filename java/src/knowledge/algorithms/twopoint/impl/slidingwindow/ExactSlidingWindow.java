package knowledge.algorithms.twopoint.impl.slidingwindow;

/**
 * @author wujingxinit@outlook.com
 * @date 2026/07/26
 * @description 精确条件滑动窗口模板 (Exact Sliding Window)
 * <p>
 * 核心思想：
 * 求“恰好满足条件 k”的子数组个数，通常很难直接用滑动窗口求解。
 * 经典转化技巧：恰好 k 个 = 最多 k 个 - 最多 (k - 1) 个。
 * 即：Exact(k) = AtMost(k) - AtMost(k - 1)。
 * <p>
 * 适用场景：
 * - 恰好包含 k 个不同整数的子数组个数
 * - 和为目标值（带负数或条件复杂）时的特殊转换（如二元数组中和为 goal 的子数组）
 */
public class ExactSlidingWindow {

    public int slidingWindowExact(int[] nums, int k) {
        // 转化为求解两次 atMost
        return atMostK(nums, k) - atMostK(nums, k - 1);
    }

    private int atMostK(int[] nums, int k) {
        if (k < 0) {
            return 0;
        }

        int left = 0;
        int right = 0;
        int count = 0; // 记录窗口内满足特定性质的元素个数或种类
        int res = 0;

        while (right < nums.length) {
            // 1. 将右侧元素加入窗口，更新状态
            if (nums[right] % 2 != 0) { // 示例逻辑：假设条件是奇数的个数
                count++;
            }

            // 2. 若窗口状态超出限制（> k），缩小窗口直到重新满足条件（<= k）
            while (count > k) {
                if (nums[left] % 2 != 0) {
                    count--;
                }
                left++;
            }

            // 3. 此时窗口内所有以 right 结尾的子数组都满足条件
            // 数量正好是 right - left + 1
            res += right - left + 1;

            right++;
        }

        return res;
    }
}
