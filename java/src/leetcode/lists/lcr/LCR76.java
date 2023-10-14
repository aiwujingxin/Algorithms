package leetcode.lists.lcr;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/9/25 17:44
 */
public class LCR76 {

    public static void main(String[] args) {
        System.out.println(new LCR76().findKthLargest(new int[]{3, 2, 1, 5, 6, 4, 7, 8, 9}, 2));
    }

    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        return findKthLargest(nums, 0, nums.length - 1, k);
    }

    public int findKthLargest(int[] nums, int start, int end, int k) {
        if (start > end) {
            return -1;
        }
        int index = partition(nums, start, end);
        if (index + 1 == k) {
            return nums[index];
        } else if (index + 1 < k) {
            return findKthLargest(nums, index + 1, end, k);
        } else {
            return findKthLargest(nums, start, index - 1, k);
        }
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
