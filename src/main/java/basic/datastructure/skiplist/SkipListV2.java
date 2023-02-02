package basic.datastructure.skiplist;

import java.util.Arrays;

/**
 * @author aiwujingxin@gmail.com
 * @date 2022/7/26 22:29
 */
public class SkipListV2 {

    static final int MAX_LEVEL = 16;
    static final double P = 0.5;
    static final Node sentinel = new Node(0, Integer.MAX_VALUE);

    static class Node {
        Node[] forward; // 0-indexed level-wise pointer array
        int key;
        int value;

        Node(int level, int key) {
            forward = new Node[level];
            this.key = key;
            this.value = 1;
        }
    }

    Node header;
    int listLevel;

    public SkipListV2() {
        header = new Node(MAX_LEVEL, -1);
        Arrays.fill(header.forward, sentinel);
        listLevel = 1;
    }

    public boolean search(int target) {
        Node cur = header;
        for (int i = listLevel - 1; i >= 0; --i) {
            while (cur.forward[i].key < target) {
                cur = cur.forward[i];
            }
        }
        return cur.forward[0].key == target;
    }

    public void add(int num) {
        Node[] update = getPredecessors(num);
        Node cur = update[0].forward[0];

        if (cur.key == num) {
            ++cur.value;
        } else {
            int level = randomLevel();
            if (level > listLevel) {
                for (int i = listLevel; i < level; ++i) {
                    update[i] = header;
                }
                listLevel = level;
            }
            cur = new Node(level, num);
            for (int i = 0; i < level; ++i) {
                cur.forward[i] = update[i].forward[i];
                update[i].forward[i] = cur;
            }
        }
    }

    public boolean erase(int num) {
        Node[] update = getPredecessors(num);
        Node cur = update[0].forward[0];
        if (cur.key != num) {
            return false;
        } else {
            if (cur.value > 1) {
                --cur.value;
            } else {
                for (int i = 0; i < listLevel; ++i) {
                    if (update[i].forward[i] != cur) {
                        break;
                    }
                    update[i].forward[i] = cur.forward[i];
                }
                while (listLevel > 1 && header.forward[listLevel - 1] == sentinel) {
                    --listLevel;
                }
            }
            return true;
        }
    }

    private Node[] getPredecessors(int target) {
        Node[] update = new Node[MAX_LEVEL];
        Node cur = header;
        for (int i = listLevel - 1; i >= 0; --i) {
            while (cur.forward[i].key < target) {
                cur = cur.forward[i];
            }
            update[i] = cur;
        }
        return update;
    }

    private int randomLevel() {
        int level = 1;
        while (Math.random() < P && level < Math.min(MAX_LEVEL, listLevel + 1)) {
            ++level;
        }
        return level;
    }
}
