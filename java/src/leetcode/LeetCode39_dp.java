package leetcode;

/**
 * @author jingxinwu
 * @date 2022-02-13 6:04 PM
 * @see LeetCode139
 */
public class LeetCode39_dp {

    public boolean combinationSum(int[] array, int target) {
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
