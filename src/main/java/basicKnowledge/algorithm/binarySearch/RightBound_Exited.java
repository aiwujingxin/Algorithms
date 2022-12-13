package basicKnowledge.algorithm.binarySearch;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/10/24 00:32
 */
public class RightBound_Exited implements BinarySearch {

    public static void main(String[] args) {
        System.out.println(new RightBound_Exited().search(new int[]{1, 2, 3, 4, 5, 7, 7, 8, 8, 10}, 6));
        System.out.println(new RightBound_Exited().search(new int[]{1, 2, 3, 4, 6, 6, 6, 7, 7, 8, 8, 10}, 6));
    }

    public int search(int[] nums, int target) {
        int idx = -1;
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (nums[mid] == target) {
                idx = mid;
            }
            if (nums[mid] <= target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return idx;
    }
}
