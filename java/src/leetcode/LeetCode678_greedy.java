package leetcode;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/3/13 22:44
 */

//https://www.youtube.com/watch?v=9rbp7UrLyaE
public class LeetCode678_greedy {
    public boolean checkValidString(String s) {
        int minCnt = 0; //最少需要 ） 个数
        int maxCnt = 0; //最多需要 ） 个数
        for (char ch : s.toCharArray()) {
            switch (ch) {
                case '(' -> {
                    minCnt++;
                    maxCnt++;
                }
                case ')' -> {
                    if (minCnt > 0) {
                        minCnt--;
                    }
                    maxCnt--;
                }
                case '*' -> {
                    if (minCnt > 0) {
                        minCnt--; //看作 ）
                    }
                    maxCnt++;//看作 （
                }
            }
            if (maxCnt < 0) { // **)))
                return false;
            }
        }
        return minCnt == 0;
    }
}
