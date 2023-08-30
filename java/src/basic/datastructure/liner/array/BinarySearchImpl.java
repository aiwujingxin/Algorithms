package basic.datastructure.liner.array;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/5/1 13:02
 * <a href="https://leetcode.cn/problems/find-first-and-last-position-of-element-in-sorted-array/">...</a>
 */
public class BinarySearchImpl implements basic.algorithm.binarysearch.BinarySearch {

    //34. 在排序数组中查找元素的第一个和最后一个位置
    @Override
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

    // 第一个大于等于target的数
    public int bsearch_1(int[] nums, int target) {
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

    // 最后一个小于等于target的数
    public int bsearch_2(int[] nums, int target) {
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

    int binarySearch(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            }
        }
        return -1;
    }
}
