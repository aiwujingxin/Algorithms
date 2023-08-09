package basic.advstructure;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/5/23 11:47
 */
public class SkipList {

    private static final int MAX_LEVEL = 16; // 最大层数
    private final SkipListNode head; // 头节点
    private final Random random; // 用于生成随机数
    private int level; // 当前跳表的层数

    public SkipList() {
        this.level = 0;
        this.head = new SkipListNode(Integer.MIN_VALUE, MAX_LEVEL);
        this.random = new Random();
    }

    public static void main(String[] args) {
        SkipList skipList = new SkipList();
        skipList.insert(3);
        skipList.insert(1);
        skipList.insert(5);

        System.out.println(skipList.search(0)); // 输出 false
        System.out.println(skipList.search(3)); // 输出 true

        skipList.delete(1);
        System.out.println(skipList.search(1)); // 输出 false
    }

    public void insert(int val) {
        // 生成一个随机的层数
        int newLevel = randomLevel();
        // 如果新生成的层数大于当前跳表的层数，更新当前层数
        if (newLevel > level) {
            level = newLevel;
        }

        // 创建新的节点
        SkipListNode newNode = new SkipListNode(val, newLevel);

        // 更新每层的指针
        SkipListNode current = head;
        for (int i = level; i >= 0; i--) {
            while (current.forwards[i] != null && current.forwards[i].val < val) {
                current = current.forwards[i];
            }
            newNode.forwards[i] = current.forwards[i];
            current.forwards[i] = newNode;
        }
    }

    public void delete(int val) {
        SkipListNode current = head;
        for (int i = level; i >= 0; i--) {
            while (current.forwards[i] != null && current.forwards[i].val < val) {
                current = current.forwards[i];
            }
            if (current.forwards[i] != null && current.forwards[i].val == val) {
                current.forwards[i] = current.forwards[i].forwards[i];
            }
        }
    }

    public boolean search(int val) {
        SkipListNode current = head;
        for (int i = level; i >= 0; i--) {
            while (current.forwards[i] != null && current.forwards[i].val < val) {
                current = current.forwards[i];
            }
            if (current.forwards[i] != null && current.forwards[i].val == val) {
                return true;
            }
        }
        return false;
    }

    private int randomLevel() {
        int level = 0;
        while (random.nextDouble() < 0.5 && level < MAX_LEVEL) {
            level++;
        }
        return level;
    }

    static class SkipListNode {
        int val;
        SkipListNode[] forwards;

        public SkipListNode(int val, int level) {
            this.val = val;
            this.forwards = new SkipListNode[level + 1];
        }
    }
}
