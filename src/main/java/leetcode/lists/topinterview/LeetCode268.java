package leetcode.lists.topinterview;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/9/29 15:00
 */
public class LeetCode268 {

    public static void main(String[] args) {
        System.out.println(new LeetCode268().missingNumber(new int[]{3, 0, 1}));
        System.out.println(new LeetCode268().missingNumber(new int[]{9, 6, 4, 2, 3, 5, 7, 0, 1}));
    }

    //https://leetcode.com/problems/missing-number/discuss/70011/Java-two-solutions
    public int missingNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            int cnt = 0;
            for (int n : nums) {
                if (n <= mid) {
                    cnt++;
                }
            }
            //fix
            // question: 为什么能保证mid的左边都是安全的?  确实能保证, 同时向左移，不影响结果
            if (cnt == mid + 1) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }
}
