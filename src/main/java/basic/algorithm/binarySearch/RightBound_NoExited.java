package basic.algorithm.binarySearch;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/10/24 00:02
 */
public class RightBound_NoExited implements BinarySearch {

    // the last index that nums[index] <= target
    public static void main(String[] args) {
        System.out.println(new RightBound_NoExited().search(new int[]{1, 2, 3, 4, 5, 7, 7, 8, 8, 10}, 6));
        System.out.println(new RightBound_NoExited().search(new int[]{1, 2, 3, 4, 6, 6, 6, 7, 7, 8, 8, 10}, 6));
    }

    public int search(int[] nums, int target) {
        int left = 0, right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] <= target) {
                left = mid + 1; // 注意
            } else if (nums[mid] > target) {
                right = mid;
            }
        }
        return left - 1; // 注意
    }
}
