package leetcode.problems;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/10/31 22:36
 * @link <a href="https://leetcode.cn/problems/find-k-closest-elements/solution/pai-chu-fa-shuang-zhi-zhen-er-fen-fa-python-dai-ma/"></a>
 */
public class LeetCode658 {

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int l = 0, r = arr.length - k;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (arr[mid + k] - x < x - arr[mid]) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        List<Integer> result = new ArrayList<>(k);
        for (int i = l; i < l + k; i++) {
            result.add(arr[i]);
        }
        return result;
    }
}
