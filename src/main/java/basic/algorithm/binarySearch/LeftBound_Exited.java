package basic.algorithm.binarySearch;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/10/24 00:32
 */
public class LeftBound_Exited {

    public static void main(String[] args) {
        System.out.println(new LeftBound_Exited().search(new int[]{5, 7, 7, 8, 8, 10}, 6));
        System.out.println(new LeftBound_Exited().search(new int[]{5, 6, 7, 8, 8, 10}, 6));
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
            if (nums[mid] >= target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return idx;
    }
}
