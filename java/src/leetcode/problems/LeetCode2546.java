package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/3/5 12:11
 * @description 利用 XOR 的性质
 */
public class LeetCode2546 {

    public boolean makeStringsEqual(String s, String target) {
        return s.contains("1") == target.contains("1");
    }
}
