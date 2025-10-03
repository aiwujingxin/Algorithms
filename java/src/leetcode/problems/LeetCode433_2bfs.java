package leetcode.problems;

import knowledge.algorithms.search.dfsAndBfs.bfs.BiBFS;

import java.util.*;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Function;

/**
 * @author wujingxinit@outlook.com
 * @date 9/18/25 14:44
 */
public class LeetCode433_2bfs {

    public int minMutation(String startGene, String endGene, String[] bank) {
        Set<String> bankSet = new HashSet<>(Arrays.asList(bank));
        if (!bankSet.contains(endGene)) {
            return -1;
        }
        char[] geneChars = {'A', 'C', 'G', 'T'};
        Function<String, List<String>> getNeighbors = (currentGene) -> {
            List<String> neighbors = new ArrayList<>();
            char[] chars = currentGene.toCharArray();
            // 遍历基因序列的每个位置
            for (int i = 0; i < chars.length; i++) {
                char oldChar = chars[i];
                // 尝试替换为 'A', 'C', 'G', 'T'
                for (char c : geneChars) {
                    if (c == oldChar) {
                        continue;
                    }
                    chars[i] = c;
                    String newGene = new String(chars);
                    // 检查新基因是否在基因库中
                    if (bankSet.contains(newGene)) {
                        neighbors.add(newGene);
                    }
                }
                // 恢复字符，以便处理下一个位置
                chars[i] = oldChar;
            }
            return neighbors;
        };
        BiBFS<String> bfs = new BiBFS<>();
        return bfs.search(startGene, endGene, getNeighbors);
    }
}
