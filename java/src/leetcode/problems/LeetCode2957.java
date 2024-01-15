package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/1/15 18:28
 */
public class LeetCode2957 {

    public int removeAlmostEqualCharacters(String s) {
        int ans = 0;
        for (int i = 1; i < s.length(); i++) {
            if (Math.abs(s.charAt(i - 1) - s.charAt(i)) <= 1) {
                ans++;
                i++;
            }
        }
        return ans;
    }
}


