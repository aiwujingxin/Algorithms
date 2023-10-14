package leetcode.lists.lcr;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/9/23 21:15
 */
public class LCR30 {

    class RandomizedSet {
        List<Integer> list;
        HashMap<Integer, Integer> map;
        Random rand;

        public RandomizedSet() {
            list = new ArrayList<>();
            map = new HashMap<>();
            rand = new Random();
        }

        public boolean insert(int val) {
            if (map.containsKey(val)) {
                return false;
            }
            map.put(val, list.size());
            list.add(val);
            return true;
        }

        public boolean remove(int val) {
            if (!map.containsKey(val)) {
                return false;
            }
            int last = list.get(list.size() - 1);
            int idx = map.get(val);
            list.set(idx, last);
            map.put(last, idx);

            list.remove(list.size() - 1); // pop the last element, O(1)
            map.remove(val);
            return true;
        }

        public int getRandom() {
            int n = rand.nextInt(list.size());
            return list.get(n);
        }
    }

}
