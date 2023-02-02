package leetcode.plan.binarysearch.level1;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/10/6 12:51
 */
public class LeetCode35 {

    public static void main(String[] args) {
        System.out.println(new LeetCode35().searchInsert(new int[]{1, 3}, 2));
    }

    //1  3
    //r
    //   l
    //因为最后l在r的右边，而且根据循环不变式，l左边严格小于target，
    // r的右边严格大于等于target，所以l就是你说的a
    public int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }
}
