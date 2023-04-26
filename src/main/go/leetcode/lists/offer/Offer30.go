package offer

import "math"

/**
 * @author wujingxinit@outlook.com
 * @date 2023/1/4 02:46
 */

type MinStack struct {
	stack    []int
	minStack []int
}

func ConstructorMinStack() MinStack {
	return MinStack{
		stack:    []int{},
		minStack: []int{math.MaxInt64},
	}
}

/*func (this *MinStack) Push(x int)  {
	this.stack = append(this.stack, x)
	this.minStack = append(this.minStack, Min(x, this.minStack[len(this.minStack)-1]))
}
*/

func (this *MinStack) Push(val int) {
	if len(this.minStack) > 0 {
		if val <= this.minStack[len(this.minStack)-1] {
			this.minStack = append(this.minStack, val)
		} else {
			this.minStack = append(this.minStack, this.minStack[len(this.minStack)-1])
		}
	} else {
		this.minStack = append(this.minStack, val)
	}
	this.stack = append(this.stack, val)
}

func (this *MinStack) Pop() {
	this.stack = this.stack[:len(this.stack)-1]
	this.minStack = this.minStack[:len(this.minStack)-1]
}

func (this *MinStack) Top() int {
	return this.stack[len(this.stack)-1]
}

func (this *MinStack) Min() int {
	return this.minStack[len(this.minStack)-1]
}

/**
 * Your MinStack object will be instantiated and called as such:
 * obj := Constructor();
 * obj.Push(x);
 * obj.Pop();
 * param_3 := obj.Top();
 * param_4 := obj.Min();
 */
