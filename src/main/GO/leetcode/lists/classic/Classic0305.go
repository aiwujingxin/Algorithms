package classic

/**
 * @author wujingxinit@outlook.com
 * @date 2023/2/6 17:52
 */

type SortedStack struct {
	stack     []int
	tempStack []int
}

func ConstructorSortedStack() SortedStack {
	return SortedStack{
		stack:     []int{},
		tempStack: []int{},
	}
}

func (this *SortedStack) Push(val int) {
	for !this.IsEmpty() && this.stack[len(this.stack)-1] < val {
		this.tempStack = append(this.tempStack, this.stack[len(this.stack)-1])
		this.Pop()
	}
	this.stack = append(this.stack, val)
	for len(this.tempStack) > 0 {
		temp := this.tempStack[len(this.tempStack)-1]
		this.tempStack = this.tempStack[:len(this.tempStack)-1]
		this.stack = append(this.stack, temp)
	}
}

func (this *SortedStack) Pop() {
	if len(this.stack) > 0 {
		this.stack = this.stack[:len(this.stack)-1]
	}
}

func (this *SortedStack) Peek() int {
	if this.IsEmpty() {
		return -1
	}
	return this.stack[len(this.stack)-1]
}

func (this *SortedStack) IsEmpty() bool {
	return len(this.stack) == 0
}
