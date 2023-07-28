/*
 * @Author: aiwujingxin@gmail.com
 * @Date: 2023-04-14 16:48:34
 * @LastEditTime: 2023-04-19 01:35:07
 * @LastEditors: Jingxin Wu wujingxinit@outlook.com
 */
package leetcode.lists.hot200;

public class LeetCode418 {

    public static void main(String[] args) {
        System.out.println(new LeetCode418().wordsTyping(new String[]{"f", "p", "a"}, 8, 7));
    }

    public int wordsTyping(String[] sentence, int rows, int cols) {
        int sentenceIndex = 0;
        int cnt = 0;
        // corn case
        if (cols < sentence[sentenceIndex].length()) {
            return 0;
        }

        int rowIndex = 0;
        int colIndex = 0;

        // sentenceIndex = 0 col = 0
        while (rowIndex < rows) {

            String str = sentence[sentenceIndex];
            // 放在当前行
            if (colIndex + str.length() <= cols) {
                colIndex += str.length() + 1;
                sentenceIndex++;

                if (sentenceIndex == sentence.length) {
                    cnt++;
                    sentenceIndex = 0;
                }
                if (colIndex >= cols) {
                    colIndex = 0;
                    rowIndex++;
                }

            } else {
                // 放在下行
                rowIndex++;
                colIndex = 0;
            }

            if (sentenceIndex == 0 && colIndex == 0) {
                int cycleCnt = rows / rowIndex;
                cnt = cycleCnt * cnt;
                rowIndex += (cycleCnt - 1) * rowIndex;
            }
        }
        return cnt;
    }
}
