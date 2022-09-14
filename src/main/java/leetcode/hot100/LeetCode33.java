package leetcode.hot100;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/9/13 22:05
 */
public class LeetCode33 {
    //fix case
    //[1,3,5]
    //1

    //fix case
    //[3,5,1]
    //3

    //fix case
    //[4,5,6,7,0,1,2]
    //5

    //fix case
    //[4,5,6,7,8,1,2,3]
    //8

    public static void main(String[] args) {
        System.out.println(new LeetCode33().search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0));
        System.out.println(new LeetCode33().search(new int[]{4, 5, 6, 7, 8, 9, 0, 1, 2, 3}, 2));
        System.out.println(new LeetCode33().search(new int[]{1, 3, 5}, 1));
        System.out.println(new LeetCode33().search(new int[]{3, 5, 1}, 3));
        System.out.println(new LeetCode33().search(new int[]{4, 5, 6, 7, 0, 1, 2}, 5));
        System.out.println(new LeetCode33().search(new int[]{4, 5, 6, 7, 8, 1, 2, 3}, 8));
    }

    public int search(int[] nums, int target) {

        if (nums == null || nums.length == 0) {
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left + 1 < right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] > nums[left]) {
                if (nums[mid] > target && target >= nums[left]) {
                    right = mid;
                } else {
                    left = mid;
                }
            } else {
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid;
                } else {
                    right = mid;
                }
            }
        }
        if (nums[left] == target) {
            return left;
        }
        if (nums[right] == target) {
            return right;
        }
        return -1;
    }
}
