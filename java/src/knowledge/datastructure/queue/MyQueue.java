package knowledge.datastructure.queue;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/3/23 14:39
 */
public class MyQueue<E> {

    int head, tail, size;
    Node<E>[] nums;

    public MyQueue(int c) {
        nums = new Node[c];
    }

    public void add(E value) {
        nums[tail++] = new Node<>(value);
        size++;
    }

    public E poll() {
        if (isEmpty()) {
            return null;
        }
        size--;
        return nums[head++].item;
    }

    public E peek() {
        return isEmpty() ? null : nums[head].item;
    }

    public E Last() {
        return isEmpty() ? null : nums[tail--].item;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    static class Node<E> {
        E item;

        public Node(E item) {
            this.item = item;
        }
    }
}
