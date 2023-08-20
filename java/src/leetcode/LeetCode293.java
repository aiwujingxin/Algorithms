package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/3/9 22:29
 */
public class LeetCode293 {

    public List<String> generatePossibleNextMoves(String currentState) {
        List<String> ans = new ArrayList<>();
        for (int i = 0; i < currentState.length() - 1; i++) {
            if (currentState.charAt(i) == '+' && currentState.charAt(i + 1) == '+') {
                String builder = currentState.substring(0, i) + "--" + currentState.substring(i + 2);
                ans.add(builder);
            }
        }
        return ans;
    }

    //==opt==
    public List<String> generatePossibleNextMoves_opt(String currentState) {
        List<String> res = new ArrayList<>();
        if (currentState.length() <= 1) {
            return res;
        }
        char[] chars = currentState.toCharArray();
        for (int i = 1; i < currentState.length(); i++) {
            if (chars[i] == '+' && chars[i - 1] == '+') {
                chars[i] = '-';
                chars[i - 1] = '-';
                res.add(new String(chars));
                chars[i] = '+';
                chars[i - 1] = '+';
            }
        }
        return res;
    }
}
