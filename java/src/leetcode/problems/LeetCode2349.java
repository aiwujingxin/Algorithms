package leetcode.problems;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 9/17/25 01:39
 * @description 如果要用优先队的话，需要考虑惰性删除
 */
public class LeetCode2349 {

    class NumberContainers {

        HashMap<Integer, TreeSet<Integer>> map;
        HashMap<Integer, Integer> indexMap;

        public NumberContainers() {
            map = new HashMap<>();
            indexMap = new HashMap<>();
        }

        public void change(int index, int number) {
            if (indexMap.containsKey(index)) {
                map.computeIfAbsent(indexMap.get(index), k -> new TreeSet<>()).remove(index);
            }
            indexMap.put(index, number);
            map.computeIfAbsent(number, k -> new TreeSet<>()).add(index);
        }

        public int find(int number) {
            TreeSet<Integer> set = map.getOrDefault(number, new TreeSet<>());
            if (set.isEmpty()) return -1;
            return set.first();
        }
    }
}
