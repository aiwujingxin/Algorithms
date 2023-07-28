package leetcode.lists.topinterview;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/12/18 16:53
 */
public class LeetCode324_quicksort_wrong {

    //https://leetcode.com/problems/wiggle-sort-ii/solutions/77680/clear-java-o-n-avg-time-o-n-space-solution-using-3-way-partition/
    public static void main(String[] args) {
//        int[] arr = new int[]{2, 1, 1, 2, 1, 3, 3, 3, 1, 3, 1, 3, 2};
        int[] arr = new int[]{5, 3, 1, 2, 6, 7, 8, 5, 5};
        new LeetCode324_quicksort_wrong().wiggleSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public void wiggleSort(int[] nums) {
        int median = findKthSmallest(nums, nums.length % 2 == 0 ? nums.length / 2 : nums.length / 2 + 1);
        List<Integer> leftArr = new ArrayList<>();
        for (int i = 0; i <= median; i++) {
            leftArr.add(nums[i]);
        }
        List<Integer> rightArr = new ArrayList<>();
        for (int i = median + 1; i < nums.length; i++) {
            rightArr.add(nums[i]);
        }
        System.out.println(median);
        System.out.println(leftArr);
        System.out.println(rightArr);
        for (int li = leftArr.size() - 1, ri = rightArr.size() - 1, i = 0; ri >= 0; li--, ri--, i += 2) { // right is same or shorter than left
            nums[i] = leftArr.get(li);
            nums[i + 1] = rightArr.get(ri);
        }
        if (nums.length % 2 != 0) {
            nums[nums.length - 1] = leftArr.get(0);
        }
    }

    public int findKthSmallest(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int low = 0;
        int hi = nums.length - 1;
        while (low <= hi) {
            int pos = part(nums, low, hi);
            if (pos + 1 == k) {
                return pos;
            } else if (pos + 1 > k) {
                hi = pos - 1;
            } else {
                low = pos + 1;
            }
        }
        return -1;
    }

    private int part(int[] nums, int low, int hi) {
        int pi = nums[low];
        while (low < hi) {
            while (low < hi && nums[hi] >= pi) {
                hi--;
            }
            nums[low] = nums[hi];
            while (low < hi && nums[low] <= pi) {
                low++;
            }
            nums[hi] = nums[low];
        }
        nums[low] = pi;
        return low;
    }
}
