package LeetCode.vip.hot200;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

/**
 * @author jingxinwu
 * @date 2022-01-26 8:52 PM
 */
public class LeetCode245_opt {

    /**
     * 最短单词距离 III
     *
     * 给定一个字符串数组wordsDict 和两个字符串 word1 和 word2 ，返回列表中这两个单词之间的最短距离。
     *
     * 注意：word1 和 word2是有可能相同的，并且它们将分别表示为列表中 两个独立的单词 。
     *
     * 示例 1：
     *
     * 输入：wordsDict = ["practice", "makes", "perfect", "coding", "makes"], word1 = "makes", word2 = "coding"
     * 输出：1
     * 示例 2：
     *
     * 输入：wordsDict = ["practice", "makes", "perfect", "coding", "makes"], word1 = "makes", word2 = "makes"
     * 输出：3
     *
     *
     * 提示：
     *
     * 1 <= wordsDict.length <= 105
     * 1 <= wordsDict[i].length <= 10
     * wordsDict[i] 由小写英文字母组成
     * word1 和 word2 都在 wordsDict 中
     **/


    public static void main(String[] args) {
        System.out.println(
                new LeetCode245_opt().shortestWordDistance(
                        new String[]{"practice", "makes", "perfect", "coding", "makes" },
                        "makes", "makes"));
    }

    public int shortestWordDistance(String[] wordsDict, String word1, String word2) {
        HashMap<String, ArrayList<Integer>> locations = new HashMap<>();

        // Prepare a mapping from a word to all it's locations (indices).
        for (int i = 0; i < wordsDict.length; i++) {
            ArrayList<Integer> loc = locations.getOrDefault(wordsDict[i], new ArrayList<>());
            loc.add(i);
            locations.put(wordsDict[i], loc);
        }

        if (word1.equals(word2)) {
            int min = Integer.MAX_VALUE;
            List<Integer> tmp = locations.get(word1);
            for (int i = 1; i < tmp.size(); i++) {
                min = Math.min(min, tmp.get(i) - tmp.get(i - 1));
            }
            return min;
        }

        ArrayList<Integer> loc1, loc2;
        // Location lists for both the words
        // the indices will be in SORTED order by default
        loc1 = locations.get(word1);
        loc2 = locations.get(word2);
        int l1 = 0, l2 = 0, minDiff = Integer.MAX_VALUE;
        while (l1 < loc1.size() && l2 < loc2.size()) {
            if (Objects.equals(loc1.get(l1), loc2.get(l2))) {
                continue;
            }
            minDiff = Math.min(minDiff, Math.abs(loc1.get(l1) - loc2.get(l2)));
            if (loc1.get(l1) < loc2.get(l2)) {
                l1++;
            } else {
                l2++;
            }
        }
        return minDiff;
    }
}
