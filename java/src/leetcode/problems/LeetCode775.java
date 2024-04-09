package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/2/5 17:27
 */
public class LeetCode775 {

    public boolean isIdealPermutation(int[] nums) {
        int b = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                b++;
            }
        }
        int a = reversePairs(nums);
        return a == b;
    }

    int res = 0;
    int[] temp;

    public int reversePairs(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        this.temp = new int[nums.length];
        mergeSort(nums, 0, nums.length - 1);
        return res;
    }

    public void mergeSort(int[] nums, int i, int j) {
        if (i >= j) {
            return;
        }
        int mid = (i + j) / 2;
        mergeSort(nums, i, mid);
        mergeSort(nums, mid + 1, j);
        merge(nums, i, mid, j);
    }

    private void merge(int[] nums, int left, int mid, int right) {
        int i = left, j = mid + 1;
        int k = left;
        while (i <= mid && j <= right) {
            if (nums[i] <= nums[j]) {
                temp[k] = nums[i];
                i++;
            } else {
                temp[k] = nums[j];
                j++;

                // 统计
                res += mid - i + 1;
            }
            k++;
        }
        while (i <= mid) {
            temp[k] = nums[i];
            i++;
            k++;
        }
        while (j <= right) {
            temp[k] = nums[j];
            j++;
            k++;
        }
        for (int n = left; n <= right; n++) {
            nums[n] = temp[n];
        }
    }
}
