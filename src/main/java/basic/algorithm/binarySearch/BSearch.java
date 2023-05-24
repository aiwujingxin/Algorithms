package basic.algorithm.binarySearch;

import basic.template.Acwing.BinarySearch;

import java.util.Arrays;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/9/14 14:27
 */
public interface BSearch {

    static void main(String[] args) {
        System.out.println(Arrays.toString(new BinarySearch().searchRange(new int[]{1, 3, 3, 3, 3, 5}, 3)));
        System.out.println(Arrays.toString(new BinarySearch().searchRange(new int[]{1, 3, 3, 3, 3, 5}, 6)));
        System.out.println(Arrays.toString(new BinarySearch().searchRange(new int[]{1, 3, 3, 3, 3, 5}, 0)));
    }

    int[] searchRange(int[] nums, int target);

    default int binarySearch(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            }
        }
        return -1;
    }
}
