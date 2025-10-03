package leetcode.interview;

import knowledge.datastructure.tree.bst.IntervalTree;

import java.util.*;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.nio.ByteBuffer;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.function.Consumer;

/**
 * @author wujingxinit@outlook.com
 * @date 9/18/25 01:46
 */

public class FileSystemCache {

    private final IntervalTree intervalTree = new IntervalTree();
    // 需要一个 Map 来从区间起始点快速找到包含数据的 CacheEntry
    private final Map<Long, CacheEntry> entryMap = new HashMap<>();
    private final LRUEvictionPolicy evictionPolicy;
    private final ReadWriteLock lock = new ReentrantReadWriteLock();

    public FileSystemCache(long capacity) {
        // 当 LRU 策略决定淘汰一个 entry 时，会调用 this::evict 方法
        this.evictionPolicy = new LRUEvictionPolicy(capacity, this::evict);
    }

    /**
     * 公共 API：获取文件区间数据。
     */
    public byte[] get(long reqStart, long reqEnd) {
        if (reqStart > reqEnd) {
            return new byte[0];
        }
        System.out.printf("\n>>> 新请求: [%d, %d]\n", reqStart, reqEnd);

        ByteBuffer resultBuffer = ByteBuffer.allocate((int) (reqEnd - reqStart + 1));
        long currentPos = reqStart;

        // 1. 在读锁保护下，查询所有重叠的缓存区间
        lock.readLock().lock();
        List<IntervalTree.Node> overlappingNodes;
        try {
            overlappingNodes = intervalTree.findOverlapping(reqStart, reqEnd);
            // 按起始点排序，便于我们按顺序处理空洞和命中
            Collections.sort(overlappingNodes);
        } finally {
            lock.readLock().unlock();
        }

        // 2. 遍历重叠区间，处理空洞和命中
        for (IntervalTree.Node node : overlappingNodes) {
            // 2.1 处理空洞 (Gap)
            if (currentPos < node.start) {
                byte[] remoteData = readAndCache(currentPos, node.start - 1);
                resultBuffer.put(remoteData);
            }

            // 2.2 处理缓存命中部分
            long hitStart = Math.max(currentPos, node.start);
            long hitEnd = Math.min(reqEnd, node.end);

            if (hitStart <= hitEnd) {
                System.out.printf("--- 缓存命中: [%d, %d] ---\n", hitStart, hitEnd);

                // 需要获取写锁来更新 LRU 策略和访问 entryMap
                lock.writeLock().lock();
                CacheEntry entry;
                try {
                    entry = entryMap.get(node.start);
                    if (entry != null) {
                        evictionPolicy.access(entry); // 标记为最近访问
                        int offsetInCache = (int) (hitStart - entry.start);
                        int lengthToCopy = (int) (hitEnd - hitStart + 1);
                        resultBuffer.put(entry.data, offsetInCache, lengthToCopy);
                    }
                } finally {
                    lock.writeLock().unlock();
                }
            }
            currentPos = Math.max(currentPos, hitEnd + 1);
        }

        // 3. 处理请求末尾可能存在的空洞
        if (currentPos <= reqEnd) {
            byte[] remoteData = readAndCache(currentPos, reqEnd);
            resultBuffer.put(remoteData);
        }

        return resultBuffer.array();
    }

    /**
     * 辅助方法：从远程读取数据并将其加入缓存。
     * 这个过程需要获取写锁，因为它会修改所有共享数据结构。
     */
    private byte[] readAndCache(long start, long end) {
        byte[] data = readFromRemote(start, end);
        CacheEntry newEntry = new CacheEntry(start, end, data);

        lock.writeLock().lock();
        try {
            // 1. 放入 LRU 策略管理器，这可能会触发淘汰
            evictionPolicy.put(newEntry);
            // 2. 放入区间树
            intervalTree.insert(start, end);
            // 3. 放入我们的查找 Map
            entryMap.put(start, newEntry);
            System.out.println("缓存更新后，区间树大小: " + intervalTree.size());
        } finally {
            lock.writeLock().unlock();
        }
        return data;
    }

    /**
     * 淘汰回调方法：当 LRU 策略决定淘汰一个条目时被调用。
     * 注意：此方法应在持有写锁的上下文中被调用。
     */
    private void evict(CacheEntry entry) {
        System.out.printf("--- 缓存淘汰: [%d, %d] ---\n", entry.start, entry.end);
        // 1. 从区间树中删除
        intervalTree.delete(entry.start, entry.end);
        // 2. 从我们的查找 Map 中删除
        entryMap.remove(entry.start);
    }

    /**
     * 模拟从远程文件系统读取数据。
     */
    private byte[] readFromRemote(long start, long end) {
        System.out.printf("--- 远程读取: [%d, %d] ---\n", start, end);
        int length = (int) (end - start + 1);
        byte[] data = new byte[length];
        // 伪造一些数据用于演示
        for (int i = 0; i < length; i++) {
            data[i] = (byte) ((start + i) % 128);
        }
        return data;
    }

    public static void main(String[] args) {
        // 创建一个容量为 20 字节的缓存系统
        FileSystemCache cache = new FileSystemCache(20);
        // 第一次请求，全部未命中
        System.out.println(">>> 第一次请求 [2, 8] (7 bytes)");
        byte[] data1 = cache.get(2, 8);
        System.out.println("获取到数据: " + Arrays.toString(data1));
        // 此时缓存: [2, 8] (7 bytes)
        // 第二次请求，部分命中，部分未命中
        System.out.println("\n>>> 第二次请求 [5, 12] (8 bytes)");
        byte[] data2 = cache.get(5, 12);
        System.out.println("获取到数据: " + Arrays.toString(data2));
        // 此时缓存: [2, 8] 和 [9, 12] (总大小 7 + 4 = 11 bytes)
        // 第三次请求，触发淘汰
        System.out.println("\n>>> 第三次请求 [15, 25] (11 bytes)");
        byte[] data3 = cache.get(15, 25);
        System.out.println("获取到数据: " + Arrays.toString(data3));
        // 此时缓存: [2, 8], [9, 12], [15, 25] (总大小 7 + 4 + 11 = 22 bytes > 20)
        // 会触发淘汰，最旧的 [2, 8] 会被移除。
        // 第四次请求，验证淘汰结果
        System.out.println("\n>>> 第四次请求 [0, 5]");
        byte[] data4 = cache.get(0, 5);
        // 预期行为: 远程读取 [0, 1]，缓存命中 [2, 5] (因为 [2,8] 已被淘汰，但 [9,12] 访问过，所以 [2,8] 是最旧的)
        // 哦，等一下，第二次请求访问了 [5,8]，所以 [2,8] 被 access 了。
        // 正确的淘汰顺序应该是：[9,12] 是最新的，[2,8] 是次新的，[15,25] 是最新的。
        // 淘汰应该是最旧的，但这里逻辑有点绕，我们看实际运行结果。
        // 实际运行：put [2,8] -> put [9,12] -> access [5,8] (即[2,8]) -> put [15,25]。
        // LRU 顺序 (新->旧): [15,25], [2,8], [9,12]。
        // 淘汰 [9,12]。
        // 所以第四次请求会远程读取 [0,1], 命中 [2,5]。
        System.out.println("获取到数据: " + Arrays.toString(data4));
    }

    /**
     * @author wujingxinit@outlook.com
     * @date 9/18/25 02:23
     */

    public static class LRUEvictionPolicy {
        private final long capacity;
        private long currentSize = 0;
        private final Map<Long, CacheEntry> cacheMap = new HashMap<>(); // Key: start of interval
        private final CacheEntry head, tail; // Dummy head and tail for the doubly linked list
        private final Consumer<CacheEntry> evictionListener; // Callback to notify when an entry is evicted

        public LRUEvictionPolicy(long capacity, Consumer<CacheEntry> evictionListener) {
            this.capacity = capacity;
            this.evictionListener = evictionListener;
            // Initialize dummy head and tail
            head = new CacheEntry(-1, -1, null);
            tail = new CacheEntry(-1, -1, null);
            head.next = tail;
            tail.prev = head;
        }

        // Add a new entry to the cache. May trigger eviction.
        public void put(CacheEntry entry) {
            if (cacheMap.containsKey(entry.start)) {
                return; // Should not happen in our flow, but good practice
            }
            cacheMap.put(entry.start, entry);
            addNodeToFront(entry);
            currentSize += entry.getSize();
            evictIfNeeded();
        }

        // Mark an entry as recently accessed.
        public void access(CacheEntry entry) {
            removeNode(entry);
            addNodeToFront(entry);
        }

        private void evictIfNeeded() {
            while (currentSize > capacity) {
                CacheEntry tailEntry = removeTailNode();
                if (tailEntry != null) {
                    cacheMap.remove(tailEntry.start);
                    currentSize -= tailEntry.getSize();
                    evictionListener.accept(tailEntry); // Notify the main class to remove from IntervalTree
                } else {
                    break; // No more entries to evict
                }
            }
        }

        private void addNodeToFront(CacheEntry node) {
            node.next = head.next;
            node.prev = head;
            head.next.prev = node;
            head.next = node;
        }

        private void removeNode(CacheEntry node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }

        private CacheEntry removeTailNode() {
            if (tail.prev == head) return null;
            CacheEntry res = tail.prev;
            removeNode(res);
            return res;
        }
    }

    /**
     * @author wujingxinit@outlook.com
     * @date 9/18/25 02:25
     */
    public static class CacheEntry {

        public long start;
        public long end;
        public byte[] data;
        public CacheEntry prev, next; // 用于双向链表

        public CacheEntry(long start, long end, byte[] data) {
            this.start = start;
            this.end = end;
            this.data = data;
        }

        public long getSize() {
            return this.data.length;
        }
    }
}
