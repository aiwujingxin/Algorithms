package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/11/17 00:48
 * @see knowledge.algorithm.sort.QuickSelect
 * @see LeetCode75
 */
public class LeetCode324 {

    public void wiggleSort(int[] nums) {
        int n = nums.length;
        int mid = (n + 1) / 2;
        // 中位数
        int target = findKthLargest(nums, mid);
        // 分成「小于 x / 等于 x / 大于 x」三段 荷兰国旗
        split(nums, target);
        int[] arr = nums.clone();
        for (int i = 0, j = mid - 1, k = n - 1; i < n; i += 2, j--, k--) {
            nums[i] = arr[j];
            if (i + 1 < n) {
                nums[i + 1] = arr[k];
            }
        }
    }

    private void split(int[] nums, int target) {
        int p0 = 0;
        int p2 = nums.length - 1;
        int index = 0;
        while (index <= p2) {
            if (nums[index] < target) {
                swap(nums, index, p0);
                index++;
                p0++;
            } else if (nums[index] == target) {
                index++;
            } else {
                swap(nums, index, p2);
                p2--;
            }
        }
    }

    public void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int index = partition(nums, left, right);
            if (index + 1 == k) {
                return nums[index];
            } else if (index + 1 > k) {
                right = index - 1;
            } else {
                left = index + 1;
            }
        }
        return -1;
    }

    private int partition(int[] nums, int i, int j) {
        int pi = nums[i];
        while (i < j) {
            while (i < j && nums[j] <= pi) {
                j--;
            }
            nums[i] = nums[j];
            while (i < j && nums[i] >= pi) {
                i++;
            }
            nums[j] = nums[i];
        }
        nums[i] = pi;
        return i;
    }
}
