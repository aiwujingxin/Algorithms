package knowledge.datastructure.queue;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/3/23 14:39
 * @description 队列
 */
@SuppressWarnings("unchecked")
public class MyQueue<E> {

    private final E[] q;
    private int h = 0;
    private int t = 0;  // 从0开始
    private int size = 0;  // 元素计数
    private final int n;

    @SuppressWarnings("unchecked")
    public MyQueue(int n) {
        this.n = n;
        this.q = (E[]) new Object[n];
    }

    public void add(E value) {
        if (isFull()) {
            throw new RuntimeException("Queue is full");
        }
        q[t] = value;
        t = (t + 1) % n;
        size++;
    }

    public E poll() {
        if (isEmpty()) {
            return null;
        }
        E value = q[h];
        h = (h + 1) % n;
        size--;
        return value;
    }

    public E peek() {
        return isEmpty() ? null : q[h];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == n;
    }

    public int size() {
        return size;
    }
}
