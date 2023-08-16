package leetcode.problems;

/**
 * @author jingxinwu
 * @date 2021-08-20 12:13 上午
 */
public class LeetCode1529 {

    public static void main(String[] args) {
        LeetCode1529 leetCode1529 = new LeetCode1529();
        System.out.println(leetCode1529.minFlips("00001111111111"));
    }


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
