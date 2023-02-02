package leetcode.plan.algorithm.level1;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/10/8 22:14
 */
public class LeetCode557 {

    public String reverseWords(String s) {
        char[] cs = s.toCharArray();
        int n = cs.length;
        for (int i = 0, j = 0; i < n; ++i) {
            if (cs[i] == ' ') {
                swap(cs, j, i - 1);
                j = i + 1;
            }
            if (i == n - 1) {
                swap(cs, j, i);
            }

        }
        return new String(cs);
    }

    void swap(char[] cs, int left, int right) {
        while (left < right) {
            char tmp = cs[left];
            cs[left] = cs[right];
            cs[right] = tmp;
            left++;
            right--;
        }
    }
}
