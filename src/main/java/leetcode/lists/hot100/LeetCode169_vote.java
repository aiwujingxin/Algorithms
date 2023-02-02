package leetcode.lists.hot100;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/9/14 21:15
 */
public class LeetCode169_vote {

    public int majorityElement(int[] nums) {
        int count = 0;
        int candidate = Integer.MIN_VALUE;
        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }
        return candidate;
    }
}
