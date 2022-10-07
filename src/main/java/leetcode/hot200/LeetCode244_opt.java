package leetcode.hot200;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author jingxinwu
 * @date 2022-01-26 8:51 PM
 */
public class LeetCode244_opt {

    /**
     * 最短单词距离 II
     * <p>
     * 请设计一个类，使该类的构造函数能够接收一个单词列表。然后再实现一个方法，
     * 该方法能够分别接收两个单词 word1和word2，并返回列表中这两个单词之间的最短距离。
     * 您的方法将被以不同的参数调用多次。
     * <p>
     * 示例:
     * 假设 words = ["practice", "makes", "perfect", "coding", "makes"]
     * <p>
     * 输入: word1 = “coding”, word2 = “practice”
     * 输出: 3
     * 输入: word1 = "makes", word2 = "coding"
     * 输出: 1
     * 注意:
     * 你可以假设 word1 不等于 word2, 并且 word1 和 word2 都在列表里。
     **/

    public static void main(String[] args) {
        System.out.println(
                new LeetCode244_opt(new String[]{"practice", "makes", "perfect", "coding", "makes"}).shortest("coding",
                        "practice"));
    }

    HashMap<String, ArrayList<Integer>> locations;

    public LeetCode244_opt(String[] words) {
        this.locations = new HashMap<>();

        // Prepare a mapping from a word to all it's locations (indices).
        for (int i = 0; i < words.length; i++) {
            ArrayList<Integer> loc = this.locations.getOrDefault(words[i], new ArrayList<>());
            loc.add(i);
            this.locations.put(words[i], loc);
        }
    }

    public int shortest(String word1, String word2) {
        ArrayList<Integer> loc1, loc2;

        // Location lists for both the words
        // the indices will be in SORTED order by default
        loc1 = this.locations.get(word1);
        loc2 = this.locations.get(word2);

        int l1 = 0, l2 = 0, minDiff = Integer.MAX_VALUE;
        while (l1 < loc1.size() && l2 < loc2.size()) {
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

