package leetcode.problems;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/3/26 12:56
 * @description 球盒模型  <a href="https://cloud.tencent.com/developer/article/2407142?policyId=1004">球盒模型</a>
 * <解法一>（桶视角）：
 * 时间复杂度：最坏O(kⁿ)，但剪枝后实际表现较好
 * 空间复杂度：O(k)      - 桶数组 + 递归栈
 * <解法二>（球视角）：
 * 时间复杂度：O(n × 2ⁿ) - 每个状态最多计算一次
 * 空间复杂度：O(2ⁿ)     - 备忘录存储所有状态
 */
public class LeetCode698_bk {

    class Solution_bucket {//以桶为主体，逐个尝试将数字放入不同的桶中。

        public boolean canPartitionKSubsets(int[] nums, int k) {
            if (k > nums.length) return false;
            int sum = 0;
            for (int v : nums) sum += v;
            if (sum % k != 0) return false;
            int[] bucket = new int[k];
            Arrays.sort(nums); // 尽可能提前剪枝
            reverse(nums);
            return backtrack(nums, 0, bucket, sum / k);
        }

        private boolean backtrack(int[] nums, int index, int[] bucket, int target) {
            if (index == nums.length) return true;
            for (int i = 0; i < bucket.length; i++) {
                if (bucket[i] + nums[index] > target) continue; //  桶容量检查
                if (i > 0 && bucket[i - 1] == 0) continue;      //  关键剪枝避免重复组合: 如果前一个桶是空的，当前桶也不应该放这个数字。
                bucket[i] += nums[index];
                if (backtrack(nums, index + 1, bucket, target)) {
                    return true;
                }
                bucket[i] -= nums[index];
            }
            return false;
        }

        public void reverse(int[] nums) {
            int i = 0;
            int j = nums.length - 1;
            while (i < j) {
                int t = nums[i];
                nums[i] = nums[j];
                nums[j] = t;
                i++;
                j--;
            }
        }
    }

    class Solution_ball {// 以数字为主体，用位掩码记录已使用的数字。
        HashMap<Integer, Boolean> memo = new HashMap<>();

        public boolean canPartitionKSubsets(int[] nums, int k) {
            if (k > nums.length) return false;
            int sum = 0;
            for (int v : nums) sum += v;
            if (sum % k != 0) return false;
            int target = sum / k;
            return backtrack(k, 0, nums, 0, 0, target);
        }

        boolean backtrack(int k, int sum, int[] nums, int start, int used, int target) {
            if (k == 0) return true;
            if (sum == target) {
                // 完成一个子集，开始构建下一个
                boolean res = backtrack(k - 1, 0, nums, 0, used, target);
                memo.put(used, res);
            }
            if (memo.containsKey(used)) {
                return memo.get(used);
            }
            for (int i = start; i < nums.length; i++) {
                if (((used >> i) & 1) == 1) continue;  // 数字已经用过
                if (nums[i] + sum > target) continue;  // 剪枝
                used |= 1 << i;
                if (backtrack(k, sum + nums[i], nums, i + 1, used, target)) {
                    return true;
                }
                used ^= 1 << i;
            }
            return false;
        }
    }
}
