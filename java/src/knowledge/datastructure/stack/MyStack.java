package knowledge.datastructure.stack;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/3/23 15:23
 */
@SuppressWarnings("unchecked")
public class MyStack<E> {

    private final E[] data;
    private int size = 0;        // 指向下一个要插入的位置
    private final int capacity;

    public MyStack(int capacity) {
        this.capacity = capacity;
        this.data = (E[]) new Object[capacity];
    }

    public void push(E value) {
        if (isFull()) throw new RuntimeException("Stack is full");
        data[size++] = value;
    }

    public E pop() {
        if (isEmpty()) {
            return null;
        }
        E value = data[size - 1];
        data[size - 1] = null;  // 帮助垃圾回收
        size--;
        return value;
    }

    public E peek() {
        return isEmpty() ? null : data[size - 1];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
    }

    public int size() {
        return size;
    }

    public int capacity() {
        return capacity;
    }
}
