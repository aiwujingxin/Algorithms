package leetcode.problems;

import java.util.*;

/**
 * @author jingxinwu
 * @date 2021-08-03 11:56 下午
 */
public class LeetCode146 {
    public static void main(String[] args) {
        LeetCode146 leetCode146 = new LeetCode146(2);
        leetCode146.put(1, 1);
        leetCode146.put(2, 2);
        leetCode146.get(1);
        leetCode146.put(3, 3);
        leetCode146.get(2);
        leetCode146.put(4, 4);
        leetCode146.get(1);
        leetCode146.get(3);
        leetCode146.get(4);
    }

    private final int capacity;
    private final LinkedList<CacheEntry> list;
    private final HashMap<Integer, CacheEntry> map;

    public LeetCode146(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        list = new LinkedList<>();
    }


    public int get(int key) {
        //如果没有，则返回
        if (!map.containsKey(key)) {
            return -1;
        }
        //如果存在，则返回, 并且放在头部
        CacheEntry entry = map.get(key);
        int value = entry.value;
        list.remove(entry);
        list.addFirst(entry);
        return value;
    }

    public void put(int key, int value) {
        CacheEntry entry = new CacheEntry(key, value);
        if (map.containsKey(key)) {//1如果存在
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

    class CacheEntry {

        int key;
        int value;

        public CacheEntry(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}

