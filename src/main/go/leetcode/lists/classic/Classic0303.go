package classic

/**
 * @author wujingxinit@outlook.com
 * @date 2023/2/6 17:36
 */

type StackOfPlates struct {
	data [][]int
	cap  int
}

func ConstructorStackOfPlates(cap int) StackOfPlates {
	return StackOfPlates{
		data: make([][]int, 0),
		cap:  cap,
	}
}

func (this *StackOfPlates) Push(val int) {
	if len(this.data) == 0 || len(this.data[len(this.data)-1]) == this.cap {
		row := make([]int, 0)
		row = append(row, val)
		this.data = append(this.data, row)
	} else {
		this.data[len(this.data)-1] = append(this.data[len(this.data)-1], val)
	}
}

func (this *StackOfPlates) Pop() int {
	return this.PopAt(len(this.data) - 1)
}

func (this *StackOfPlates) PopAt(index int) int {
	if this.cap == 0 || len(this.data) == 0 || len(this.data[index]) == 0 {
		return -1
	}
	n := len(this.data)
	if index < 0 || index > n-1 {
		return -1
	}
	stack := this.data[index]
	res := this.data[index][len(stack)-1]
	if len(stack) == 1 {
		if n-1 == index {
			this.data = this.data[:index]
		} else {
			this.data = append(this.data[:index], this.data[index+1:]...)
		}
	} else {
		this.data[index] = this.data[index][:len(stack)-1]
	}
	return res
}
