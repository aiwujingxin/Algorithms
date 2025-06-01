package knowledge.datastructure.queue;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/3/23 14:39
 * @description 队列
 */
@SuppressWarnings("unchecked")
public class MyQueue<E> {

    private int head = 0, tail = 0, size = 0;
    private final E[] data;

    public MyQueue(int capacity) {
        data = (E[]) new Object[capacity];
    }

    public void add(E value) {
        if (size == data.length) {
            throw new RuntimeException("Queue is full");
        }
        data[tail] = value;
        tail = (tail + 1) % data.length;
        size++;
    }

    public E poll() {
        if (isEmpty()) {
            return null;
        }
        E value = data[head];
        head = (head + 1) % data.length;
        size--;
        return value;
    }

    public E peek() {
        return isEmpty() ? null : data[head];
    }

    public E last() {
        return isEmpty() ? null : data[(tail - 1 + data.length) % data.length];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }
}
