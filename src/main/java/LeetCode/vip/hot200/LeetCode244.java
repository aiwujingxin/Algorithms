package LeetCode.vip.hot200;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author jingxinwu
 * @date 2022-01-26 8:51 PM
 */
public class LeetCode244 {

    /**
     * 最短单词距离 II
     *
     * 请设计一个类，使该类的构造函数能够接收一个单词列表。然后再实现一个方法，
     * 该方法能够分别接收两个单词 word1和word2，并返回列表中这两个单词之间的最短距离。
     * 您的方法将被以不同的参数调用多次。
     *
     * 示例:
     * 假设 words = ["practice", "makes", "perfect", "coding", "makes"]
     *
     * 输入: word1 = “coding”, word2 = “practice”
     * 输出: 3
     * 输入: word1 = "makes", word2 = "coding"
     * 输出: 1
     * 注意:
     * 你可以假设 word1 不等于 word2, 并且 word1 和 word2 都在列表里。
     **/

    public static void main(String[] args) {
        System.out.println(new LeetCode244(new String[]{"practice", "makes", "perfect", "coding", "makes" }).shortest("coding","practice"));
    }


    HashMap<String, List<Integer>> map;

    public LeetCode244(String[] wordsDict) {
        map = new HashMap<>();
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
    }

    public int shortest(String word1, String word2) {
        List<Integer> list1 = map.get(word1);
        List<Integer> list2 = map.get(word2);
        int res = Integer.MAX_VALUE;
        for (int i : list1) {
            for (int j : list2) {
                res = Math.min(res, Math.abs(i - j));
            }
        }
        return res;
    }
}

