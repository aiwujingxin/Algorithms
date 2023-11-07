package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/6/1 17:11
 */
public class LeetCode727 {

    //https://leetcode.cn/problems/minimum-window-subsequence/solution/java-hua-dong-chuang-kou-jing-dian-kuo-y-nch4/

    public String minWindow(String s, String t) {
        int sPtr = 0, tPtr = 0;
        int minLen = Integer.MAX_VALUE;
        String res = "";
        while (sPtr < s.length()) {
            if (s.charAt(sPtr) == t.charAt(tPtr)) {
                tPtr++;
            }
            if (tPtr == t.length()) {
                int R = sPtr;
                while (tPtr > 0) {
                    if (s.charAt(sPtr) == t.charAt(tPtr - 1)) {
                        tPtr--;
                    }
                    sPtr--;
                }
                sPtr++;
                if (R - sPtr + 1 < minLen) {
                    minLen = R - sPtr + 1;
                    res = s.substring(sPtr, R + 1);
                }
            }
            sPtr++;
        }
        return res;
    }
}
