package basicKnowledge.algorithm.binarySearch;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/9/14 14:28
 */
public class BinarySearch_re implements BinarySearch {

    @Override
    public int search(int[] nums, int target) {
        return binarySearch(nums, 0, nums.length - 1, target);
    }

    int binarySearch(int[] arr, int l, int r, int x) {
        if (r >= l) {
            int mid = l + (r - l) / 2;
            if (arr[mid] == x) {
                return mid;
            }
            if (arr[mid] > x) {
                return binarySearch(arr, l, mid - 1, x);
            }
            return binarySearch(arr, mid + 1, r, x);
        }
        return -1;
    }
}
