package basicKnowledge.algorithm.binarySearch;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/10/24 00:02
 */
public class LeftBound_NoExited implements BinarySearch {

    // the first index that nums[index] >= target
    public static void main(String[] args) {
//        System.out.println(new LeftBound_NoExited().search(new int[]{5, 5, 7, 8, 8, 10}, 6));
//        System.out.println(new LeftBound_NoExited().search(new int[]{5, 6, 7, 8, 8, 10}, 6));
//
//        System.out.println(new LeftBound_NoExited().search(new int[]{1, 2, 3, 4, 5, 7, 7, 8, 8, 10}, 6));
//        System.out.println(new LeftBound_NoExited().search(new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 11}, 11));
//        System.out.println(new LeftBound_NoExited().search(new int[]{12, 12, 12, 12, 12, 12, 12, 12, 12, 12}, 11));
        System.out.println(new LeftBound_NoExited().search(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8}, 11));
        System.out.println(new LeftBound_NoExited().search(new int[]{5, 7, 7, 8, 8, 10}, 6));

    }

    public int search(int[] nums, int target) {
        return binarySearch(target, 0, nums.length, nums);
    }

    public int binarySearch(int target, int beg, int end, int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int left = beg;
        int right = end;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] >= target) {
                right = mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            }
        }
        return left;
    }
}
