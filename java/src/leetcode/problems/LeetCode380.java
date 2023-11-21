package leetcode.problems;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/11/21 23:13
 */
public class LeetCode380 {

    //https://www.youtube.com/watch?v=xWscy3ZyDwA
    class RandomizedSet {
        List<Integer> nums;
        Map<Integer, Integer> map;
        Random random;

        public RandomizedSet() {
            nums = new ArrayList<>();
            map = new HashMap<>();
            random = new Random();
        }

        public boolean insert(int val) {
            if (map.containsKey(val)) {
                return false;
            }
            int index = nums.size();
            nums.add(val);
            map.put(val, index);
            return true;
        }

        public boolean remove(int val) {
            if (!map.containsKey(val)) {
                return false;
            }
            int index = map.get(val);
            int last = nums.get(nums.size() - 1);
            nums.set(index, last);
            map.put(last, index);
            nums.remove(nums.size() - 1);
            map.remove(val);
            return true;
        }

        public int getRandom() {
            return nums.get(random.nextInt(nums.size()));
        }
    }
}
