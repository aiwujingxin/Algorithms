package classic

/**
 * @author wujingxinit@outlook.com
 * @date 2023/2/2 18:05
 */

type MyQueue struct {
	stack1 []int
	stack2 []int
}

/** Initialize your data structure here. */
func ConstructorMyQueue() MyQueue {
	return MyQueue{
		stack1: make([]int, 0),
		stack2: make([]int, 0),
	}
}

/** Push element x to the back of queue. */
func (this *MyQueue) Push(x int) {
	this.stack1 = append(this.stack1, x)
}

/** Removes the element from in front of queue and returns that element. */
func (this *MyQueue) Pop() int {
	if len(this.stack2) > 0 {
		val := this.stack2[len(this.stack2)-1]
		this.stack2 = this.stack2[:len(this.stack2)-1]
		return val
	} else {
		for len(this.stack1) > 0 {
			this.stack2 = append(this.stack2, this.stack1[len(this.stack1)-1])
			this.stack1 = this.stack1[:len(this.stack1)-1]
		}
	}
	if len(this.stack2) == 0 {
		return -1
	}
	val := this.stack2[len(this.stack2)-1]
	this.stack2 = this.stack2[:len(this.stack2)-1]
	return val
}

/** Get the front element. */
func (this *MyQueue) Peek() int {
	if len(this.stack2) > 0 {
		return this.stack2[len(this.stack2)-1]
	} else {
		for len(this.stack1) > 0 {
			this.stack2 = append(this.stack2, this.stack1[len(this.stack1)-1])
			this.stack1 = this.stack1[:len(this.stack1)-1]
		}
	}
	if len(this.stack2) == 0 {
		return -1
	}
	return this.stack2[len(this.stack2)-1]
}

/** Returns whether the queue is empty. */
func (this *MyQueue) Empty() bool {
	return len(this.stack1) == 0 && len(this.stack2) == 0
}
