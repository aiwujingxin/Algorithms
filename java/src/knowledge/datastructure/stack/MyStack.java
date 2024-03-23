package knowledge.datastructure.stack;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/3/23 15:23
 */
public class MyStack<E> {

    int head, tail, size;
    Node<E>[] nums;

    public MyStack(int c) {
        nums = new Node[c];
    }

    public void push(E value) {
        nums[tail++] = new Node<>(value);
        size++;
    }

    public E pop() {
        if (isEmpty()) {
            return null;
        }
        size--;
        return nums[tail--].item;
    }

    public E peek() {
        return isEmpty() ? null : nums[head].item;
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
