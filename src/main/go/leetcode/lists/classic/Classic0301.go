package classic

/**
 * @author wujingxinit@outlook.com
 * @date 2023/2/2 17:52
 */

type TripleInOne struct {
	size   int
	lens   [3]int
	stacks []int
}

func ConstructorTripleInOne(stackSize int) TripleInOne {
	return TripleInOne{size: stackSize, stacks: make([]int, stackSize*3)}
}

func (this *TripleInOne) Push(stackNum int, value int) {
	if this.lens[stackNum] == this.size {
		return
	}
	this.stacks[this.size*stackNum+this.lens[stackNum]] = value
	this.lens[stackNum]++
}

func (this *TripleInOne) Pop(stackNum int) int {
	if this.lens[stackNum] == 0 {
		return -1
	}
	val := this.stacks[this.size*stackNum+this.lens[stackNum]-1]
	this.lens[stackNum]--
	return val
}

func (this *TripleInOne) Peek(stackNum int) int {
	if this.lens[stackNum] == 0 {
		return -1
	}
	val := this.stacks[this.size*stackNum+this.lens[stackNum]-1]
	return val
}

func (this *TripleInOne) IsEmpty(stackNum int) bool {
	return this.lens[stackNum] == 0
}
