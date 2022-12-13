package leetplan.datastructure.level2;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/10/23 15:59
 */
public class LeetCode136 {

    public int singleNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int res = 0;
        for (int num : nums) {
            res = res ^ num;
        }
        return res;
    }
}
