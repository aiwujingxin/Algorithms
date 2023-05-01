package basic.algorithm.sort;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/12/18 17:14
 */
public class QuickSelect implements basic.problems.array.QuickSelect {
    @Override
    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int low = 0;
        int hi = nums.length - 1;
        while (low <= hi) {
            int pos = partition(nums, low, hi);
            if (pos + 1 == k) {
                return nums[pos];
            } else if (pos + 1 > k) {
                hi = pos - 1;
            } else {
                low = pos + 1;
            }
        }
        return -1;
    }

    private int partition(int[] nums, int low, int hi) {
        int pi = nums[low];
        while (low < hi) {
            while (low < hi && nums[hi] <= pi) {
                hi--;
            }
            nums[low] = nums[hi];
            while (low < hi && nums[low] >= pi) {
                low++;
            }
            nums[hi] = nums[low];
        }
        nums[low] = pi;
        return low;
    }

    @Override
    public int findKthSmallest(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int low = 0;
        int hi = nums.length - 1;
        while (low <= hi) {
            int pos = spart(nums, low, hi);
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

    private int spart(int[] nums, int low, int hi) {
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
