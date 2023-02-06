package leetcode.plan.binarysearch.level1;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/10/16 12:59
 */
public class LeetCode153 {

    public static void main(String[] args) {
        System.out.println(new LeetCode153().findMin(new int[]{3, 4, 5, 1, 2}));
        System.out.println(new LeetCode153().findMin(new int[]{4, 5, 6, 7, 0, 1, 2}));
        System.out.println(new LeetCode153().findMin(new int[]{11, 13, 15, 17}));
        System.out.println(new LeetCode153().findMin(new int[]{2, 3, 4, 5, 1}));
        System.out.println(new LeetCode153().findMin(new int[]{3, 1, 2}));
    }

    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int l = 0;
        int r = nums.length - 1;
        while (l + 1 < r) {
            int mid = l + (r - l) / 2;
            if (nums[l] > nums[r]) {
                if (nums[mid] > nums[mid - 1] && nums[mid] > nums[l]) {
                    l = mid + 1;
                } else {
                    r = mid;
                }
            } else {
                if (nums[mid] > nums[mid - 1]) {
                    r = mid;
                } else {
                    l = mid + 1;
                }
            }
        }
        return Math.min(nums[l], nums[r]);
    }
}
