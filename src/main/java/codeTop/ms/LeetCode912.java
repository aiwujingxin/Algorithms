package codeTop.ms;

/**
 * @author jingxinwu
 * @date 2022-02-17 10:12 PM
 */
public class LeetCode912 {


    public int[] sortArray(int[] nums) {

        return heapSort(nums);

    }

    private int[] quickSort(int[] nums) {
        if (nums == null || nums.length == 0) {
            return nums;
        }
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    private void quickSort(int[] nums, int i, int j) {
        // 1. 递归终止条件
        if (i >= j) {
            return;
        }
        int index = part(nums, i, j);
        quickSort(nums, i, index - 1);
        quickSort(nums, index + 1, j);
    }

    private int part(int[] nums, int lo, int hi) {
        int pi = nums[lo];
        while (lo < hi) {
            while (lo < hi && nums[hi] >= pi) {
                hi--;
            }
            //fix
            nums[lo] = nums[hi];

            while (lo < hi && nums[lo] <= pi) {
                lo++;
            }
            nums[hi] = nums[lo];

        }
        nums[lo] = pi;
        return lo;
    }


    public int[] heapSort(int[] nums) {

        int n = nums.length;
        //从最后一个非叶子节点开始，依次向下调整
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(nums, n, i);
        }
        for (int i = n - 1; i > 0; i--) {
            int temp = nums[0];
            nums[0] = nums[i];
            nums[i] = temp;
            heapify(nums, i, 0);
        }
        return nums;

    }

    //向下调整
    private static void heapify(int[] nums, int n, int i) {

        int l = 2 * i + 1;
        int r = 2 * i + 2;
        int bigger = i;
        if (l < n && nums[l] > nums[bigger]) {
            bigger = l;
        }
        if (r < n && nums[r] > nums[bigger]) {
            bigger = r;
        }
        if (i != bigger) {
            int temp = nums[i];
            nums[i] = nums[bigger];
            nums[bigger] = temp;
            heapify(nums, n, bigger);
        }
    }
}
