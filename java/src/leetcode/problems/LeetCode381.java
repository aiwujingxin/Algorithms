package leetcode.problems;


import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/11/21 22:20
 */
public class LeetCode381 {

    class RandomizedCollection {
        Map<Integer, Set<Integer>> map;
        List<Integer> nums;

        public RandomizedCollection() {
            map = new HashMap<>();
            nums = new ArrayList<>();
        }

        public boolean insert(int val) {
            nums.add(val);
            Set<Integer> set = map.getOrDefault(val, new HashSet<>());
            set.add(nums.size() - 1);
            map.put(val, set);
            return set.size() == 1;
        }

        //交换删除法
        public boolean remove(int val) {
            if (!map.containsKey(val)) {
                return false;
            }
            int index = map.get(val).iterator().next();
            int lastNum = nums.get(nums.size() - 1);
            nums.set(index, lastNum);

            map.get(val).remove(index);

            map.get(lastNum).remove(nums.size() - 1);
            if (index < nums.size() - 1) {
                map.get(lastNum).add(index);
            }

            // 最后
            if (map.get(val).isEmpty()) {
                map.remove(val);
            }
            nums.remove(nums.size() - 1);
            return true;
        }

        public int getRandom() {
            if (nums.isEmpty()) {
                return -1;
            }
            return nums.get((int) (Math.random() * nums.size()));
        }
    }
}
