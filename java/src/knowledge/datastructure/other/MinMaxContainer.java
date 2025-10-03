package knowledge.datastructure.other;

/**
 * @author wujingxinit@outlook.com
 * @date 8/20/25 10:55
 * @description 一个支持插入、删除，并能快速获取最小值和最大值的容器接口。
 * 典型实现方式：
 * - TreeSet / TreeMap（基于平衡二叉树，O(log n)）
 * - 双堆 + Lazy 删除（最大堆 / 最小堆结合 HashMap）
 * - SegmentTreeMinMax（基于线段树 + 离散化，适合大规模数据）
 */
public interface MinMaxContainer {

    /**
     * 向容器中插入一个元素。
     *
     * @param x 要插入的元素
     *          要求：
     *          - 容器允许存在多个相同的元素（多重集语义）。
     */
    void insert(int x);

    /**
     * 从容器中删除一个元素。
     *
     * @param x 要删除的元素
     *          要求：
     *          - 如果容器中有多个相同的元素，只删除其中一个。
     *          - 如果元素不存在，可以选择忽略或抛出异常（具体实现需保证一致性）。
     */
    void remove(int x);

    /**
     * 获取当前容器中的最小值。
     *
     * @return 容器的最小元素
     * 注意：
     * - 如果容器为空，通常应抛出异常或返回特殊值（例如 Integer.MAX_VALUE）。
     * - 建议由具体实现决定异常处理方式。
     */
    int getMin();

    /**
     * 获取当前容器中的最大值。
     *
     * @return 容器的最大元素
     * 注意：
     * - 如果容器为空，通常应抛出异常或返回特殊值（例如 Integer.MIN_VALUE）。
     * - 建议由具体实现决定异常处理方式。
     */
    int getMax();

    /**
     * 判断容器是否为空。
     *
     * @return true 如果容器为空，否则 false
     */
    boolean isEmpty();
}
