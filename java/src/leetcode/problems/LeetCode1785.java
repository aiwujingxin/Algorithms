package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/1/16 19:41
 */
public class LeetCode1785 {

    public int minElements(int[] nums, int limit, int goal) {
        long sum = 0;
        for (int x : nums) {
            sum += x;
        }
        long diff = Math.abs(sum - goal);
        return (int) ((diff + limit - 1) / limit);
    }
}
