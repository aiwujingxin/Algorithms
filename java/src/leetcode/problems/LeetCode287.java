package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/1/9 00:35
 * @description 利用了 数值范围的单调性（即 <= mid 的数字个数是否超过 mid），从而可以用二分查找逼近答案。
 */
public class LeetCode287 {

    public int findDuplicate(int[] nums) {
        int n = nums.length;
        int l = 1, r = n - 1;
        while (l < r) {
            int mid = (l + r) >> 1;
            if (check(mid, nums)) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l;
    }

    private boolean check(int mid, int[] nums) {
        int cnt = 0;
        for (int num : nums) {
            if (num <= mid) {
                cnt++;
            }
        }
        return cnt <= mid;
    }
}
