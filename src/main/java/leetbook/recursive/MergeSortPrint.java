package leetbook.recursive;

import java.util.Arrays;

/**
 * @author jingxinwu
 * @date 2022-01-31 2:15 PM
 */
public class MergeSortPrint {


    public int[] sortArray(int[] nums) {
        int len = nums.length;
        int[] temp = new int[len];
        mergeSort(nums, 0, len - 1, temp, 0);
        return nums;
    }

    private void mergeSort(int[] nums, int left, int right, int[] temp, int recursionLevel) {
        log("拆分子问题", left, right, recursionLevel);
        if (left == right) {
            log("解决子问题", left, right, recursionLevel);
            return;
        }

        int mid = (left + right) / 2;
        mergeSort(nums, left, mid, temp, recursionLevel + 1);
        mergeSort(nums, mid + 1, right, temp, recursionLevel + 1);
        mergeOfTwoSortedArray(nums, left, mid, right, temp);
        log("解决子问题", left, right, recursionLevel);
    }

    private void mergeOfTwoSortedArray(int[] nums, int left, int mid, int right, int[] temp) {
        for (int i = left; i <= right; i++) {
            temp[i] = nums[i];
        }

        int i = left;
        int j = mid + 1;

        int k = left;
        while (i <= mid && j <= right) {
            if (temp[i] <= temp[j]) {
                // 注意写成 < 就丢失了稳定性（相同元素原来靠前的排序以后依然靠前）
                nums[k] = temp[i];
                k++;
                i++;
            } else {
                nums[k] = temp[j];
                k++;
                j++;
            }
        }

        while (i <= mid) {
            nums[k] = temp[i];
            k++;
            i++;
        }
        while (j <= right) {
            nums[k] = temp[j];
            k++;
            j++;
        }
    }

    private void log(String log, int left, int right, int recursionLevel) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("  ".repeat(Math.max(0, recursionLevel)));
        stringBuilder.append(log);
        stringBuilder.append(" ");
        stringBuilder.append("=>");
        stringBuilder.append(" ");
        stringBuilder.append("[");
        stringBuilder.append(left);
        stringBuilder.append(", ");
        stringBuilder.append(right);
        stringBuilder.append("]");
        System.out.println(stringBuilder.toString());


    }

    public static void main(String[] args) {
        MergeSortPrint solution = new MergeSortPrint();
        int[] nums = new int[]{8, 6, 7, 2, 3, 5, 4, 1};
        int[] res = solution.sortArray(nums);
        System.out.println(Arrays.toString(res));
    }
}
