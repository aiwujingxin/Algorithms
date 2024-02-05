package leetcode.problems;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/2/4 20:25
 */
public class LeetCode2671 {

    class FrequencyTracker {
        HashMap<Integer, Integer> map;
        HashMap<Integer, HashSet<Integer>> freqMap;

        public FrequencyTracker() {
            map = new HashMap<>();
            freqMap = new HashMap<>();
        }

        public void add(int number) {
            map.put(number, map.getOrDefault(number, 0) + 1);
            int freq = map.get(number);
            HashSet<Integer> oldSet = freqMap.getOrDefault(freq - 1, new HashSet<>());
            oldSet.remove(number);
            freqMap.put(freq - 1, oldSet);
            HashSet<Integer> newSet = freqMap.getOrDefault(freq, new HashSet<>());
            newSet.add(number);
            freqMap.put(freq, newSet);
        }

        public void deleteOne(int number) {
            if (!map.containsKey(number)) {
                return;
            }
            map.put(number, map.getOrDefault(number, 0) - 1);
            int freq = map.get(number);
            if (freq == 0) {
                map.remove(number);
            }
            HashSet<Integer> oldSet = freqMap.getOrDefault(freq + 1, new HashSet<>());
            oldSet.remove(number);
            freqMap.put(freq + 1, oldSet);
            HashSet<Integer> newSet = freqMap.getOrDefault(freq, new HashSet<>());
            newSet.add(number);
            freqMap.put(freq, newSet);
        }

        public boolean hasFrequency(int frequency) {
            return !freqMap.getOrDefault(frequency, new HashSet<>()).isEmpty();
        }
    }

}
