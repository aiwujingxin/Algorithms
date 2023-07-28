package leetcode.plan.binarysearch.level2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/11/1 02:19
 */
public class LeetCode658_bs_v1 {

    //https://leetcode.cn/problems/find-k-closest-elements/solution/pai-chu-fa-shuang-zhi-zhen-er-fen-fa-python-dai-ma/

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> list = new ArrayList<>();
        int n = arr.length;
        int left = 0;
        int right = n - k;
        while (left <= right) {
            int mid = (left + right) >>> 1;
            //mid + k < n , 例如长度为1，mid和k都为1，已经越界了，所以判断一下是否越界
            if (mid + k < n && x - arr[mid] > arr[mid + k] - x) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        for (int i = left; i < left + k; i++) {
            list.add(arr[i]);
        }
        return list;
    }
}
