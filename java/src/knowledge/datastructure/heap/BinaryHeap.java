package knowledge.datastructure.heap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;

/**
 * @author wujingxinit@outlook.com
 * @description 通用二叉堆模板（0-indexed,自动扩容）。
 * @see MaxHeap           手写 1-indexed 最大堆(教学)
 * @see TopKHeap          定容 Top K 模板
 */
public class BinaryHeap<E> implements Heap<E> {

    private static final int DEFAULT_CAPACITY = 16;

    private final Comparator<? super E> comparator;
    private Object[] elements;
    private int size;

    public BinaryHeap(Comparator<? super E> comparator) {
        this(DEFAULT_CAPACITY, comparator);
    }

    public BinaryHeap(int capacity, Comparator<? super E> comparator) {
        if (capacity < 0) {
            throw new IllegalArgumentException("capacity must be >= 0");
        }
        this.comparator = Objects.requireNonNull(comparator);
        this.elements = new Object[Math.max(1, capacity)];
    }

    /**
     * 复制数组并以 O(n) 建堆，不修改输入数组。
     */
    public static <E> BinaryHeap<E> heapify(E[] values, Comparator<? super E> comparator) {
        Objects.requireNonNull(values);
        BinaryHeap<E> heap = new BinaryHeap<>(values.length, comparator);
        for (E value : values) {
            heap.elements[heap.size++] = Objects.requireNonNull(value);
        }
        for (int i = heap.size / 2 - 1; i >= 0; i--) {
            heap.down(i);
        }
        return heap;
    }

    @Override
    public void push(E element) {
        Objects.requireNonNull(element);
        ensureCapacity();
        elements[size] = element;
        up(size++);
    }

    @Override
    public E peek() {
        return size == 0 ? null : elementAt(0);
    }

    @Override
    public E pop() {
        if (size == 0) return null;
        E top = elementAt(0);
        elements[0] = elements[--size];
        elements[size] = null;
        if (size > 0) down(0);
        return top;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        Arrays.fill(elements, 0, size, null);
        size = 0;
    }

    private void up(int child) {
        while (child > 0) {
            int parent = (child - 1) / 2;
            if (!less(child, parent)) break;
            swap(child, parent);
            child = parent;
        }
    }

    private void down(int parent) {
        while (2 * parent + 1 < size) {
            int child = 2 * parent + 1;
            if (child + 1 < size && less(child + 1, child)) child++;
            if (!less(child, parent)) break;
            swap(parent, child);
            parent = child;
        }
    }

    private boolean less(int i, int j) {
        return comparator.compare(elementAt(i), elementAt(j)) < 0;
    }

    private void swap(int i, int j) {
        Object value = elements[i];
        elements[i] = elements[j];
        elements[j] = value;
    }

    private void ensureCapacity() {
        if (size == elements.length) {
            elements = Arrays.copyOf(elements, elements.length * 2);
        }
    }

    @SuppressWarnings("unchecked")
    private E elementAt(int index) {
        return (E) elements[index];
    }
}
