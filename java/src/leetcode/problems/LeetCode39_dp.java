package leetcode.problems;

/**
 * @author jingxinwu
 * @date 2022-02-13 6:04 PM
 * {@link LeetCode139}
 */
public class LeetCode39_dp {

    /**
     * CombinationNum_NonRepeat(dynamic)
     * 给你一个 只包含正整数 的 非空 数组 nums 和一个给定值 Target 。求出数组中是否存在某些值相加等于 Target。
     */
    //  同139 https://leetcode-cn.com/problems/word-break/
    public boolean GetTargetValue(int[] array, int target) {
        if (array == null || array.length == 0) {
            return false;
        }
        // 因为存在负数情况，所以需要进行判断
        int size = target >= 0 ? target : -target;
        boolean[] answer = new boolean[size + 1];
        answer[0] = true;

        for (int i = 1; i <= size; i++) {
            for (int coin : array) {
                if (i - coin >= 0) {
                    answer[i] = answer[i - coin];
                }
                // 已满足条件
                if (answer[i]) {
                    break;
                }
            }
        }
        return answer[size];
    }
}
