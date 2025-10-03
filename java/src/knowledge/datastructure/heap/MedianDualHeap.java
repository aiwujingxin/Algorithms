package knowledge.datastructure.heap;

import java.util.*;
import java.util.function.Function;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/5/2 23:18
 * @description DualHeap 泛型双堆容器，支持中位数查询和延迟删除
 * - small（大根堆）：存储窗口中较小的一半元素，堆顶是最大值
 * - large（小根堆）：存储窗口中较大的一半元素，堆顶是最小值
 * <p>
 * 为了支持「删除任意元素」的操作，额外维护了一个 HashMap delayed：
 * - delayed[num] = x 表示数字 num 还需要被延迟删除 x 次
 * （因为堆中不能直接删除任意元素，只能延迟到它出现在堆顶时再移除）
 * <p>
 * 通过平衡两个堆的大小（smallSize 与 largeSize），始终保证：
 * - 当 k 为奇数时，small 堆顶就是中位数
 * - 当 k 为偶数时，中位数 = (small 堆顶 + large 堆顶) / 2
 */
public class MedianDualHeap<T extends Comparable<? super T>> implements DualHeap<T> {

    private final PriorityQueue<T> small;
    private final PriorityQueue<T> large;
    private final Map<T, Integer> delayed;
    private final Comparator<? super T> comparator;
    private final Function<T, Number> valueMapper;
    private final int k;
    private int smallSize, largeSize;

    // 只保留这个构造函数，所有初始化都在这里完成
    public MedianDualHeap(int k) {
        Comparator<? super T> cmp = Comparator.naturalOrder();
        Function<T, Number> mapper = element -> {
            if (element instanceof Number) return (Number) element;
            throw new UnsupportedOperationException(
                    "Default value mapper only works for Number types. " +
                            "For custom types, please provide a valueMapper."
            );
        };
        this.comparator = cmp;
        this.valueMapper = mapper;
        this.small = new PriorityQueue<>(cmp.reversed());
        this.large = new PriorityQueue<>(cmp);
        this.delayed = new HashMap<>();
        this.k = k;
        this.smallSize = 0;
        this.largeSize = 0;
    }

    public double getMedian() {
        if (isEmpty()) {
            throw new NoSuchElementException("Heap is empty");
        }
        if ((k & 1) == 1) {
            return valueMapper.apply(small.peek()).doubleValue();
        } else {
            double smallVal = valueMapper.apply(small.peek()).doubleValue();
            double largeVal = valueMapper.apply(large.peek()).doubleValue();
            return (smallVal + largeVal) / 2.0;
        }
    }


    public void add(T element) {
        if (small.isEmpty() || comparator.compare(element, small.peek()) <= 0) {
            small.offer(element);
            ++smallSize;
        } else {
            large.offer(element);
            ++largeSize;
        }
        makeBalance();
    }

    public void addAll(Collection<T> elements) {
        for (T element : elements) {
            add(element);
        }
    }


    public void remove(T element) {
        delayed.put(element, delayed.getOrDefault(element, 0) + 1);

        if (!small.isEmpty() && comparator.compare(element, small.peek()) <= 0) {
            --smallSize;
            if (!small.isEmpty() && comparator.compare(element, small.peek()) == 0) {
                prune(small);
            }
        } else {
            --largeSize;
            if (!large.isEmpty() && comparator.compare(element, large.peek()) == 0) {
                prune(large);
            }
        }
        makeBalance();
    }

    private void prune(PriorityQueue<T> heap) {
        while (!heap.isEmpty()) {
            T element = heap.peek();
            if (delayed.containsKey(element)) {
                int count = delayed.get(element);
                if (count == 1) {
                    delayed.remove(element);
                } else {
                    delayed.put(element, count - 1);
                }
                heap.poll();
            } else {
                break;
            }
        }
    }

    private void makeBalance() {
        prune(small);
        prune(large);

        if (smallSize > largeSize + 1) {
            T element = small.poll();
            large.offer(element);
            --smallSize;
            ++largeSize;
            prune(small);
        } else if (smallSize < largeSize) {
            T element = large.poll();
            small.offer(element);
            ++smallSize;
            --largeSize;
            prune(large);
        }
    }


    public int size() {
        return smallSize + largeSize;
    }


    public boolean isEmpty() {
        return size() == 0;
    }


    public void clear() {
        small.clear();
        large.clear();
        delayed.clear();
        smallSize = 0;
        largeSize = 0;
    }

    public T getSmallPeek() {
        prune(small);
        return small.peek();
    }

    public T getLargePeek() {
        prune(large);
        return large.peek();
    }

    public int getPendingRemovalCount() {
        return delayed.values().stream().mapToInt(Integer::intValue).sum();
    }

    public int getWindowSize() {
        return k;
    }
}
