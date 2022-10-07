package leetcode.topinterview;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/9/28 02:05
 */
public class LeetCode146 {


    //copy
    class LRUCache {
        HashMap<Integer, CacheNode> map;
        LinkedList<CacheNode> list;

        int capacity;

        public LRUCache(int capacity) {
            this.map = new HashMap<>();
            this.list = new LinkedList<>();
            this.capacity = capacity;
        }

        public int get(int key) {
            if (!map.containsKey(key)) {
                return -1;
            }
            CacheNode entry = map.get(key);
            list.remove(entry);
            list.addFirst(entry);
            return entry.value;
        }

        public void put(int key, int value) {
            CacheNode entry = new CacheNode(key, value);
            // exited
            if (map.containsKey(key)) {
                list.remove(map.get(key));
            } else {
                //2如果小于容量，则直接放入
                if (map.size() >= capacity) {
                    //3 如果大于容量，则删掉最不长用的元素,同时删掉map，再放入元素
                    map.remove(list.pollLast().key);
                }
            }
            list.addFirst(entry);
            map.put(key, entry);
        }
    }

    class CacheNode {
        Integer key;
        Integer value;

        public CacheNode(Integer key, Integer value) {
            this.key = key;
            this.value = value;
        }
    }

}
