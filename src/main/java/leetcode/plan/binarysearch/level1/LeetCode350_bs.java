package leetcode.plan.binarysearch.level1;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/10/15 18:05
 */
public class LeetCode350_bs {

    //https://leetcode.com/problems/intersection-of-two-arrays-ii/discuss/1708436/Java-two-pointers-and-binary-search-O(m-log-n)

    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        ArrayList<Integer> ans = new ArrayList<>();
        for (int n2 : nums2) {
            binarySearch(nums1, n2, ans);
        }
        return ans.stream().mapToInt(i -> i).toArray();
    }

    public int binarySearch(int[] arr, int target, ArrayList<Integer> ans) {
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
