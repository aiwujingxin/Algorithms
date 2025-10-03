package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 8/17/25 23:24
 */
public class LeetCode1899 {

    public boolean mergeTriplets(int[][] triplets, int[] target) {
        int[] cur = new int[] { 0, 0, 0 };
        for (int[] triplet : triplets) {
            if (triplet[0] > target[0] || triplet[1] > target[1] || triplet[2] > target[2])
                continue;
            cur[0] = Math.max(cur[0], triplet[0]);
            cur[1] = Math.max(cur[1], triplet[1]);
            cur[2] = Math.max(cur[2], triplet[2]);
        }
        return cur[0] == target[0] && cur[1] == target[1] && cur[2] == target[2];
    }
}
