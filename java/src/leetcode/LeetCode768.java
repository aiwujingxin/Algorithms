package leetcode;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/3/17 18:17
 */
public class LeetCode768 {
    public int maxChunksToSorted(int[] arr) {
        int[] premax = new int[arr.length];

        int tmp = 0;
        for (int i = 0; i < arr.length; i++) {
            premax[i] = Math.max(arr[i], tmp);
            tmp = premax[i];
        }

        int result = 1;

        tmp = arr[arr.length - 1];
        for (int i = arr.length - 1; i > 0; i--) {
            tmp = Math.min(arr[i], tmp);
            if (premax[i - 1] <= tmp) {
                result++;
            }
        }
        return result;
    }
}
