package leetcode.problems;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/11/17 22:42
 */
public class LeetCode350 {

    public int[] intersect(int[] nums1, int[] nums2) {
        int[] arr1 = new int[1001];
        for (int j : nums1) {
            arr1[j]++;
        }
        int[] arr2 = new int[1001];
        for (int j : nums2) {
            arr2[j]++;
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < Math.min(arr1[i], arr2[i]); j++) {
                list.add(i);
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}
