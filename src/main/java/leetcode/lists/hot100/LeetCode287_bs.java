package leetcode.lists.hot100;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/9/14 02:00
 */
public class LeetCode287_bs {

    public int findDuplicate(int[] nums) {
        int st = 0;
        int end = nums.length - 1;
        int dup = -1;

        while (st <= end) {
            int mid = st + (end - st) / 2;
            int count = 0;

            for (int num : nums) {
                if (num <= mid) {
                    count++;
                }
            }

            if (count > mid) {
                dup = mid;
                end = mid - 1;
            } else {
                st = mid + 1;
            }
        }

        return dup;
    }
}
