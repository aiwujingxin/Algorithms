package leetcode.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/10/7 21:23
 */
public class LeetCode350_bs {

    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> ans = new ArrayList<>();
        for (int i : nums2) {
            binarySearch(nums1, i, ans);
        }
        return ans.stream().mapToInt(i -> i).toArray();
    }

    public int binarySearch(int[] arr, int target, List<Integer> ans) {
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (target < arr[mid]) {
                end = mid - 1;
            } else if (target > arr[mid]) {
                start = mid + 1;
            } else {
                ans.add(arr[mid]);
                arr[mid] = -1;
                Arrays.sort(arr);
                break;
            }
        }
        return -1;
    }
}
