package leetcode.lists.offer;

import java.util.Arrays;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/9/13 01:48
 */
public class Offer40 {

    public int[] getLeastNumbers(int[] arr, int k) {
        if (arr.length == 0) {
            return new int[]{};
        }
        getIndex(arr, 0, arr.length - 1, k);
        return Arrays.copyOf(arr, k);
    }

    public void getIndex(int[] arr, int start, int end, int k) {
        if (start >= end) {
            return;
        }
        int index = partition(arr, start, end);
        if (index - start + 1 == k) {//todo ?
            return;
        }
        if (index > k) {
            getIndex(arr, start, index - 1, k);
        } else {
            getIndex(arr, index + 1, end, k);
        }
    }

    public int partition(int[] arr, int i, int j) {
        int pi = arr[i];
        while (i < j) {
            while (arr[j] >= pi && i < j) {
                j--;
            }
            arr[i] = arr[j];
            while (arr[i] <= pi && i < j) {
                i++;
            }
            arr[j] = arr[i];
        }
        arr[i] = pi;
        return i;
    }
}
