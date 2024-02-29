package leetcode.problems;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/2/15 12:32
 */
public class LeetCode969 {

    public List<Integer> pancakeSort(int[] arr) {
        if (arr == null || arr.length == 0) {
            return new ArrayList<>();
        }
        List<Integer> list = new ArrayList<>();
        for (int n = arr.length - 1; n >= 0; n--) {
            int index = 0;
            int max = arr[index];
            for (int i = 0; i <= n; i++) {
                if (max < arr[i]) {
                    max = arr[i];
                    index = i;
                }
            }
            if (index == n) {
                return list;
            }
            reverse(arr, index);
            reverse(arr, n);
            list.add(index + 1);
            list.add(n);
        }
        return list;
    }

    private void reverse(int[] arr, int n) {
        int l = 0;
        int r = n;
        while (l < r) {
            int t = arr[l];
            arr[l] = arr[r];
            arr[r] = t;
            l++;
            r--;
        }
    }
}
