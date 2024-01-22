package leetcode.problems;

/**
 * @author jingxinwu
 * @date 2021-08-20 12:13 上午
 */
public class LeetCode1529 {

    public int minFlips(String target) {
        int flips = 0;
        char prev = '0';
        for (int i = 0; i < target.length(); i++) {
            char curr = target.charAt(i);
            if (curr != prev) {
                flips++;
                prev = curr;
            }
        }
        return flips;
    }
}
