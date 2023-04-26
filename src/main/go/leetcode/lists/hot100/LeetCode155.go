package hot100

type MinStack struct {
	stack    []int
	minStack []int
}

func ConstructorMinStack() MinStack {
	return MinStack{
		stack:    make([]int, 0),
		minStack: make([]int, 0),
	}
}

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
	this.minStack = this.minStack[0 : len(this.minStack)-1]
	this.stack = this.stack[0 : len(this.stack)-1]
}

func (this *MinStack) Top() int {
	return this.stack[len(this.stack)-1]
}

func (this *MinStack) GetMin() int {
	return this.minStack[len(this.minStack)-1]
}
