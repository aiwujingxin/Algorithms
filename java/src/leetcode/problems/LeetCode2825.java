package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/1/8 11:55
 */
public class LeetCode2825 {

    public boolean canMakeSubsequence(String str1, String str2) {
        if (str1.length() < str2.length()) {
            return false;
        }
        int index1 = 0;
        int index2 = 0;
        while (index1 < str1.length()) {
            if (index2 == str2.length()) {
                return true;
            }
            if (!match(str1.charAt(index1), str2.charAt(index2))) {
                while (index1 < str1.length() && !match(str1.charAt(index1), str2.charAt(index2))) {
                    index1++;
                }
                if (index1 == str1.length()) {
                    return false;
                }
            }
            index1++;
            index2++;
        }
        return index2 == str2.length();
    }

    private boolean match(char a, char b) {
        return a == b || (a - '0' + 1 == b - '0') || (a == 'z' && b == 'a');
    }
}
