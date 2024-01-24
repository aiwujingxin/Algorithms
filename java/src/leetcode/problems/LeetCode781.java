package leetcode.problems;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/1/24 11:10
 */
public class LeetCode781 {

    public int numRabbits(int[] answers) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int answer : answers) {
            map.put(answer, map.getOrDefault(answer, 0) + 1);
        }
        int sum = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int group = entry.getValue() / (entry.getKey() + 1) + (entry.getValue() % (entry.getKey() + 1) == 0 ? 0 : 1);
            sum += group * (entry.getKey() + 1);
        }
        return sum;
    }
}
