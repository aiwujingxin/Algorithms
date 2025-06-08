package leetcode.problems;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/2/15 12:32
 * @description 经过两次翻转，将最大值放入正确位置
 */
public class LeetCode969 {

    public List<Integer> pancakeSort(int[] arr) {
        List<Integer> list = new ArrayList<>();
        for (int n = arr.length - 1; n >= 0; n--) {
            int index = 0;
            int max = 0;
            for (int i = 0; i <= n; i++) {
                if (arr[i] > max) {
                    max = arr[i];
                    index = i;
                }
            }
            if (index == n) {
                continue;
            }
            reverse(arr, 0, index);
            reverse(arr, 0, n);
            list.add(index + 1);
            list.add(n + 1);
        }
        return list;
    }

    private void reverse(int[] arr, int i, int j) {
        while (i < j) {
            int t = arr[i];
            arr[i] = arr[j];
            arr[j] = t;
            i++;
            j--;
        }
    }
}
