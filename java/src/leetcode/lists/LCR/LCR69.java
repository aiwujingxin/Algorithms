package leetcode.lists.LCR;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/9/25 01:24
 */
public class LCR69 {

    public int peakIndexInMountainArray(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            int mid = (left + right + 1) >> 1;
            if (arr[mid - 1] < arr[mid]) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
}
