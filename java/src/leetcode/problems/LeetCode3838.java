package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 6/13/26 21:05
 */
public class LeetCode3838 {

    public String mapWordWeights(String[] words, int[] weights) {
        StringBuilder sb = new StringBuilder();
        for (String word : words) {
            int w = 0;
            for (int j = 0; j < word.length(); j++) {
                w += weights[word.charAt(j) - 'a'];
            }
            int index = 25 - w % 26;
            sb.append((char) (index + 'a'));
        }
        return sb.toString();
    }
}
