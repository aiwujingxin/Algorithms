package leetcode.problems;

import java.util.LinkedList;
import java.util.List;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/9/28 21:00
 */
public class LeetCode163 {

    /*
     * 给定一个排序的整数数组nums ，其中元素的范围在 闭区间 [lower, upper] 当中，
     * 返回不包含在数组中的缺失区间。
     *
     * 输入: nums = [0, 1, 3, 50, 75], lower = 0 和 upper = 99,
     * 输出: ["2", "4->49", "51->74", "76->99"]
     * */

    public static void main(String[] args) {
        System.out.println(new LeetCode163().findMissingRanges(new int[]{0, 1, 3, 50, 75}, 0, 99));
    }

    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> res = new LinkedList<>();
        int prev = lower - 1;
        int curr;
        for (int i = 0; i <= nums.length; i++) {
            if (i == nums.length) {
                curr = upper + 1;
            } else {
                curr = nums[i];
            }

            if (curr - prev > 1) {
                res.add(getRanges(prev + 1, curr - 1));
            }
            prev = curr;
        }
        return res;
    }

    private String getRanges(int from, int to) {
        return from == to ? String.valueOf(from) : from + "->" + to;
    }
}
