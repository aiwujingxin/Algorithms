package leetcode.problems;

/**
 * @author jingxinwu
 * @date 2021-12-26 9:29 PM
 */
public class LeetCode377_dfs_TEL {

    public static void main(String[] args) {
        System.out.println(new LeetCode377_dfs_TEL().combinationSum4(new int[]{1, 2, 3}, 4));
    }

    private static int dfs(int[] arr, int target) {
        // target为0，有1种组合：一个数都不要
        if (target == 0) {
            return 1;
        }

        int count = 0;
        // 从arr[0 ... n-1]，从左往右，依次尝试选1个数作为组合的第1个位置
        // 每种方案得到的组合数累加，就是搞定i的组合总数
        for (int j : arr) {
            if (j <= target) { // 如果这个数不大于i，说明可以要这个数
                // 要了这个数后，目标和还剩：i - arr[firstNum]，让后续递归去搞定
                // 当前这个尝试方案的组合方法数就是后续递归返回的方法数：
                // 意思是：对于后续递归的每个有效组合，我当前选择的这个[firstNum]，都可以拼在它们的前面，形成一个可以搞定i的组合
                // 例如：nums = [1, 2, 3]，target = 4，当前尝试的[firstNum]=2，后续递归搞定target-2 = 2
                // 后续递归得到的有效组合为(1, 1)，(2)
                // 当前的这个2，可以拼在(1, 1)，(2)前面，形成(2, 1, 1)和(2, 2)两个有效组合可以搞定target = 4
                count += dfs(arr, target - j);
            }
        }

        return count;
    }

    public int combinationSum4(int[] nums, int target) {
        if (nums == null || nums.length == 0 || target <= 0) {
            return 0;
        }
        return dfs(nums, target);
    }
}
