package leetbook.recursive;

/**
 * @author jingxinwu
 * @date 2022-01-31 2:14 PM
 */
public class MergeSort {

    public class Solution {

        public int[] sortArray(int[] nums) {
            int len = nums.length;
            int[] temp = new int[len];
            mergeSort(nums, 0, len - 1, temp);
            return nums;
        }

        /**
         * 递归函数语义：对数组 nums 的子区间 [left.. right] 进行归并排序
         *
         * @param nums
         * @param left
         * @param right
         * @param temp 用于合并两个有序数组的辅助数组，全局使用一份，避免多次创建和销毁
         */
        private void mergeSort(int[] nums, int left, int right, int[] temp) {
            // 1. 递归终止条件
            if (left == right) {
                return;
            }

            // 2. 拆分，对应「分而治之」算法的「分」
            int mid = (left + right) / 2;

            mergeSort(nums, left, mid, temp);
            mergeSort(nums, mid + 1, right, temp);

            // 3. 在递归函数调用完成以后还可以做点事情

            // 合并两个有序数组，对应「分而治之」的「合」
            mergeOfTwoSortedArray(nums, left, mid, right, temp);
        }


        /**
         * 合并两个有序数组：先把值复制到临时数组，再合并回去
         *
         * @param nums
         * @param left
         * @param mid mid 是第一个有序数组的最后一个元素的下标，即：[left..mid] 有序，[mid + 1..right] 有序
         * @param right
         * @param temp 全局使用的临时数组
         */
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
    }

}
