package classic;

/**
 * @author jingxinwu
 * @date 2021-12-06 12:02 上午
 */
public class Number0301 {
    int stackSize;
    int[] buffer;
    int[] pointer = new int[]{-1, -1, -1};
    public Number0301(int stackSize) {
        this.stackSize = stackSize;
        this.buffer = new int[stackSize * 3];
    }

    public void push(int stackNum, int value) {
        if (pointer[stackNum] + 1 > stackSize) {
            return;
        }
        pointer[stackNum]++;
        buffer[absTopOfStack(stackNum)] = value;
    }

    public int pop(int stackNum) {
        if (pointer[stackNum] == -1) {
            return -1;
        }
        pointer[stackNum]--;
        int value = buffer[absTopOfStack(stackNum)];
        buffer[absTopOfStack(stackNum)] = 0;
        return value;

    }

    public int peek(int stackNum) {
        if (pointer[stackNum] - 1 < 0) {
            return -1;
        }
        return buffer[absTopOfStack(stackNum)];
    }

    public boolean isEmpty(int stackNum) {
        return pointer[stackNum] == -1;

    }


    public int absTopOfStack(int num) {
        return num * stackSize + pointer[num];
    }
}
