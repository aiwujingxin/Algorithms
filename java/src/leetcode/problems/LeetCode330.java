package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/11/17 16:38
 */
public class LeetCode330 {

    public int minPatches(int[] nums, int n) {
        int cunt = 0;
        long miss = 1;
        int length = nums.length, index = 0;
        while (miss <= n) {
            if (index < length && nums[index] <= miss) {
                miss += nums[index];
                index++;
            } else {
                miss *= 2;
                cunt++;
            }
        }
        return cunt;
    }
}
