package offer

/**
 * @author wujingxinit@outlook.com
 * @date 2022/12/28 21:10
 */

type CQueue struct {
	stack1 []int
	stack2 []int
}

func Constructor() CQueue {
	return CQueue{
		stack1: make([]int, 0),
		stack2: make([]int, 0),
	}
}

func (this *CQueue) AppendTail(value int) {
	this.stack1 = append(this.stack1, value)
}

func (this *CQueue) DeleteHead() int {
	if len(this.stack2) > 0 {
		res := this.stack2[0]
		this.stack2 = this.stack2[1:len(this.stack2)]
		return res
	}
	for len(this.stack1) > 0 {
		this.stack2 = append(this.stack2, this.stack1[0])
		this.stack1 = this.stack1[1:]
	}
	if len(this.stack2) > 0 {
		res := this.stack2[0]
		this.stack2 = this.stack2[1:len(this.stack2)]
		return res
	}
	return -1
}
