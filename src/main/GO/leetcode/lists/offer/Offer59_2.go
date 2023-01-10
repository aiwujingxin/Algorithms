package offer

/**
 * @author wujingxinit@outlook.com
 * @date 2023/1/9 23:11
 */

type MaxQueue struct {
	q []int
	d []int
}

func ConstructorMaxQueue() MaxQueue {
	return MaxQueue{
		q: make([]int, 0),
		d: make([]int, 0),
	}
}

func (this *MaxQueue) Max_value() int {
	if len(this.d) == 0 {
		return -1
	}
	return this.d[0]
}

func (this *MaxQueue) Push_back(value int) {
	for len(this.d) > 0 && this.d[len(this.d)-1] < value {
		this.d = this.d[:len(this.d)-1]
	}
	this.d = append(this.d, value)
	this.q = append(this.q, value)
}

func (this *MaxQueue) Pop_front() int {
	if len(this.q) == 0 {
		return -1
	}
	ans := this.q[0]
	this.q = this.q[1:]
	if ans == this.d[0] {
		this.d = this.d[1:]
	}
	return ans
}
