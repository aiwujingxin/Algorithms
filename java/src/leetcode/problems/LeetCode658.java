package leetcode.problems;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/10/31 22:36
 * @link <a href="https://leetcode.cn/problems/find-k-closest-elements/solution/pai-chu-fa-shuang-zhi-zhen-er-fen-fa-python-dai-ma/"></a>
 */
public class LeetCode658 {

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int n = arr.length;
        int l = 0;
        int r = n - 1;
        while (l < r) {
            int mid = l + r >> 1;
            if (check(arr, mid, k, x)) l = mid + 1;
            else r = mid;
        }
        List<Integer> list = new ArrayList<>();
        for (int i = l; i < l + k; i++) {
            list.add(arr[i]);
        }
        return list;
    }

    public boolean check(int[] arr, int mid, int k, int x) {
        if (mid + k >= arr.length) {
            return false;
        }
        if (x - arr[mid] <= arr[mid + k] - x) {
            return false;
        }
        return true;
    }
}
