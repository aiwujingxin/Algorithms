package leetCode.problems;

/**
 * @author jingxinwu
 * @date 2021-06-23 9:53 下午
 */
public class LeetCode45 {

    public static void main(String[] args) {
        LeetCode45 leetCode45 = new LeetCode45();
        System.out.println(leetCode45.jump(new int[]{2, 3, 1, 1, 4}));
    }


    public int jump(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }
        int res = 0;
        int max = 0;
        int curMax = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            max = Math.max(max, i + nums[i]);
            if (curMax == i) {
                res++;
                curMax = max;
            }
        }
        return res;
    }

}
