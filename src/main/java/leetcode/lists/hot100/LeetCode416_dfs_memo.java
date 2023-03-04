package leetcode.lists.hot100;
/**
 * @author wujingxinit@outlook.com
 * @date 2022/9/13 12:19
 */
public class LeetCode416_dfs_memo {

    Boolean[][] cache;

    public boolean canPartition(int[] nums) {
        int sum = 0;
        int max = 0;
        for (int i : nums) {
            sum += i;
            max = Math.max(max, i);
        }
        if (sum % 2 != 0 || max > sum / 2) {
            return false;
        }

        cache = new Boolean[nums.length][sum / 2 + 1];
        return canPartition(nums, 0, sum / 2);
    }

    private boolean canPartition(int[] nums, int idx, int tgt) {
        if (tgt == 0) {
            return true;
        }
        if (idx == nums.length || tgt < nums[idx]) {
            return false;
        }
        if (cache[idx][tgt] == null) {
            cache[idx][tgt] = canPartition(nums, idx + 1, tgt - nums[idx]) || canPartition(nums, idx + 1, tgt);
        }

        return cache[idx][tgt];
    }
}
