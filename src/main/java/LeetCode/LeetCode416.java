package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jingxinwu
 * @date 2021-12-13 1:07 AM
 */
public class LeetCode416 {

    public static void main(String[] args) {
        System.out.println(new LeetCode416().canPartitionV2(new int[]{1, 5, 11, 5}));
    }


    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum = sum + num;
        }
        if ((sum & 1) == 1) {
            return false;
        }
        int target = sum / 2;
        int len = nums.length;
        boolean[][] dp = new boolean[len][target + 1];

        dp[0][0] = true;
        if (nums[0] <= target) {
            dp[0][nums[0]] = true;
        }
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j <= target; j++) {
                //考虑当前数
                if (nums[i] <= j) {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i]];
                } else {
                    //不考虑当前值
                    dp[i][j] = dp[i - 1][j];
                }
            }

            if (dp[i][target]) {
                return true;
            }
        }
        return dp[len - 1][target];
    }

    public boolean canPartitionV2(int[] nums) {
        int n = nums.length;
        if (n < 2) {
            return false;
        }
        int sum = 0, maxNum = 0;
        for (int num : nums) {
            sum += num;
            maxNum = Math.max(maxNum, num);
        }
        if (sum % 2 != 0) {
            return false;
        }
        int target = sum / 2;
        if (maxNum > target) {
            return false;
        }
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;
        for (int num : nums) {
            for (int j = target; j >= num; --j) {
                dp[j] |= dp[j - num];
            }
        }
        return dp[target];
    }

    //超时
    public boolean canPartitionV3(int[] nums) {

        if (nums == null || nums.length == 0) {
            return false;
        }
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        List<List<Integer>> list = new ArrayList<>();
        helper(nums, list, 0, new ArrayList<>(), sum);

        for (int i = 0; i < list.size(); i++) {
            List<Integer> temp = list.get(i);

            int tSum = temp.stream().mapToInt(Integer::intValue).sum();

            if (tSum == sum - tSum) {
                return true;
            }
        }

        return false;
    }

    private void helper(int[] nums, List<List<Integer>> res, int index, ArrayList<Integer> temp, int sum) {
        res.add(new ArrayList<>(temp));

        int s = 0;
        for (int num : temp) {
            s += num;
        }
        if (s * 2 > sum) {
            return;
        }

        for (int i = index; i < nums.length; i++) {
            temp.add(nums[i]);
            helper(nums, res, i + 1, temp, sum);
            temp.remove(temp.size() - 1);
        }
    }
}
