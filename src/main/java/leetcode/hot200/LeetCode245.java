package leetcode.hot200;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author jingxinwu
 * @date 2022-01-26 8:52 PM
 */
public class LeetCode245 {

    /**
     * 最短单词距离 III
     * <p>
     * 给定一个字符串数组wordsDict 和两个字符串 word1 和 word2 ，返回列表中这两个单词之间的最短距离。
     * <p>
     * 注意：word1 和 word2是有可能相同的，并且它们将分别表示为列表中 两个独立的单词 。
     * <p>
     * 示例 1：
     * <p>
     * 输入：wordsDict = ["practice", "makes", "perfect", "coding", "makes"], word1 = "makes", word2 = "coding"
     * 输出：1
     * 示例 2：
     * <p>
     * 输入：wordsDict = ["practice", "makes", "perfect", "coding", "makes"], word1 = "makes", word2 = "makes"
     * 输出：3
     * <p>
     * <p>
     * 提示：
     * <p>
     * 1 <= wordsDict.length <= 105
     * 1 <= wordsDict[i].length <= 10
     * wordsDict[i] 由小写英文字母组成
     * word1 和 word2 都在 wordsDict 中
     **/


    public static void main(String[] args) {
        System.out.println(
                new LeetCode245().shortestWordDistance(new String[]{"practice", "makes", "perfect", "coding", "makes"},
                        "makes", "makes"));
    }

    public int shortestWordDistance(String[] wordsDict, String word1, String word2) {
        int idx = -1;
        int minDist = Integer.MAX_VALUE;
        for (int i = 0; i < wordsDict.length; i++) {
            if (wordsDict[i].equals(word1) || wordsDict[i].equals(word2)) {
                if (idx != -1 && (!wordsDict[i].equals(wordsDict[idx]) || word1.equals(word2))) {
                    minDist = Math.min(minDist, Math.abs(i - idx));
                }
                idx = i;
            }
        }

        return minDist;
    }

    //超时
    public int shortestWordDistance_v2(String[] wordsDict, String word1, String word2) {

        HashMap<String, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < wordsDict.length; i++) {

            if (map.containsKey(wordsDict[i])) {
                List<Integer> list = map.get(wordsDict[i]);
                list.add(i);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(wordsDict[i], list);
            }
        }
        int res = Integer.MAX_VALUE;

        if (word1.equals(word2)) {
            List<Integer> list1 = map.get(word1);
            List<Integer> list2 = map.get(word1);
            for (int i : list1) {
                for (int j : list2) {
                    if (i == j) {
                        continue;
                    }
                    res = Math.min(res, Math.abs(i - j));
                }
            }
        } else {
            List<Integer> list1 = map.get(word1);
            List<Integer> list2 = map.get(word2);

            for (int i : list1) {
                for (int j : list2) {
                    res = Math.min(res, Math.abs(i - j));
                }
            }
            return res;
        }

        return res;

    }

}
