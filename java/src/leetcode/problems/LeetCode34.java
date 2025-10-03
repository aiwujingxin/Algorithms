package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/4/9 18:07
 */
public class LeetCode34 {

    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) {
            return new int[]{-1, -1};
        }
        return new int[]{findL(nums, target), findR(nums, target)};
    }

    private int findL(int[] a, int x) {
        int l = 0;
        int r = a.length - 1;
        while (l < r) {
            int mid = l + r >> 1;
            if (a[mid] < x) l = mid + 1;
            else r = mid;
        }
        return a[l] == x ? l : -1;
    }

    private int findR(int[] a, int x) {
        int l = 0;
        int r = a.length - 1;
        while (l < r) {
            int mid = l + r + 1 >> 1;
            if (a[mid] > x) r = mid - 1;
            else l = mid;
        }
        return a[l] == x ? l : -1;
    }
}
