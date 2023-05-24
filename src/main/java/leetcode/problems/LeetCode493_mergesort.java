package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/5/24 21:49
 */
public class LeetCode493_mergesort {

    /**
     * 归并排序
     * 在归排的合并过程中计算翻转对的数量
     * 注意:
     * 如果在合并两个有序数组的过程中进行翻转对的计算时间复杂度较高，因为不管是左边还是右边有元素进入tmp数组，
     * 都要有一次另一个半区的循环比较
     * 要在合并两个有序数组前，进行翻转对的计算，这样时间复杂度会比较低，只需要用左半区比较右半区
     */
    public int reversePairs(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        return mergeSort(nums, new int[nums.length], 0, nums.length - 1);
    }

    private int mergeSort(int[] org, int[] tmp, int left, int right) {
        if (left >= right) {
            return 0;
        }
        int mid = left + ((right - left) >>> 1);
        int lRes = mergeSort(org, tmp, left, mid), rRes = mergeSort(org, tmp, mid + 1, right);
        return merge(org, tmp, left, right, mid) + lRes + rRes;
    }

    private int merge(int[] org, int[] tmp, int left, int right, int mid) {
        int l = left, r = mid + 1, tmpIndex = left, pairCount = 0;
        /*
         * 先计算翻转对的数量
         * 现在左半区和右半区都是有序的
         * 那org[l] > 2 * org[r]  则 org[l] > 2*[mid + 1 ~ r]所有元素
         */
        while (l <= mid) {
            while (r <= right && org[l] > 2L * (long) org[r]) {
                r++;
            }
            pairCount += r - mid - 1;
            l++;
        }
        l = left;
        r = mid + 1;
        while (l <= mid || r <= right) {
            if (l > mid) {
                tmp[tmpIndex++] = org[r++];
            } else if (r > right) {
                tmp[tmpIndex++] = org[l++];
            } else if (org[l] <= org[r]) {//如果左半区当前元素 小于等于 右半区当前元素，那就不可能存在num[i] > 2 * nums[r]
                tmp[tmpIndex++] = org[l++];
            } else {
                tmp[tmpIndex++] = org[r++];
            }
        }

        for (int i = left; i <= right; i++) {
            org[i] = tmp[i];
        }

        return pairCount;
    }
}
