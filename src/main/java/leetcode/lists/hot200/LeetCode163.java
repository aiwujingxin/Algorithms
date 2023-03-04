/*
 * @Author: aiwujingxin@gmail.com
 * @Date: 2023-03-03 18:51:07
 * @LastEditTime: 2023-03-05 01:28:31
 * @LastEditors: aiwujingxin@gmail.com
 */
package leetcode.lists.hot200;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/3/3 18:51
 */
public class LeetCode163 {

    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        int[] arr = new int[nums.length + 2];
        arr[0] = lower - 1;
        arr[arr.length - 1] = upper + 1;
        System.arraycopy(nums, 0, arr, 1, nums.length);
        List<String> list = new ArrayList<>();
        for (int i = 1; i < arr.length; i++) {
            int diff = arr[i] - arr[i - 1];
            if (diff > 2) {
                list.add(arr[i - 1] + 1 + "->" + (arr[i] - 1));
            } else if (diff == 2) {
                list.add(Integer.toString(arr[i - 1] + 1));
            }
        }
        return list;
    }
}
