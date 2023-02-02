package leetcode.lists.topinterview;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/9/26 00:09
 */
public class LeetCode162 {

    public static void main(String[] args) {
        System.out.println(new LeetCode162().findPeakElement(new int[]{1, 2, 3, 1}));
        System.out.println(new LeetCode162().findPeakElement(new int[]{1, 2, 1, 3, 5, 6, 4}));
    }

    //在有序的，有可能的那一部分进行二分查找
    //二分法的精髓是，不断排除错误答案，最后剩下的就是正确答案
    public int findPeakElement(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        if (nums.length == 1) {
            return 0;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] > nums[mid + 1]) {
                right = mid;
            } else if (nums[mid] < nums[mid + 1]) {
                left = mid + 1;
            }
        }
        return left;
    }
}
