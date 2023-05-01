package basic.template.Acwing;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/5/1 13:02
 * <a href="https://leetcode.cn/problems/find-first-and-last-position-of-element-in-sorted-array/">...</a>
 */
public class BinarySearch {

    //34. 在排序数组中查找元素的第一个和最后一个位置
    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[]{-1, -1};
        }
        int left = bsearch_1(nums, target);
        int right = bsearch_2(nums, target);
        if (nums[left] != target) {
            left = -1;
        }
        if (nums[right] != target) {
            right = -1;
        }
        return new int[]{left, right};
    }

    int bsearch_1(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            int mid = l + r >> 1;
            if (nums[mid] >= target) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    int bsearch_2(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            int mid = l + r + 1 >> 1;
            if (nums[mid] <= target) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }

    double bsearch_3(double l, double r) {
        double eps = 1e-6;  // eps 表示精度，取决于题目对精度的要求
        while (r - l > eps) {
            double mid = (l + r) / 2;
            if (check(mid)) {
                r = mid;
            } else {
                l = mid;
            }
        }
        return l;
    }

    private boolean check(double mid) {
        return false;
    }
}
