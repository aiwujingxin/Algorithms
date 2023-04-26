package classic

/**
 * @Author: jingxinwu
 * @Date: 2023/2/27 21:50
 */

type Operations struct {
	one  int
	nums []int
	cnt  []int
}

func ConstructorOperations() Operations {
	var i8 int8 = 127
	return Operations{
		one:  int(i8 + 1 + i8),
		nums: make([]int, 32),
		cnt:  make([]int, 32),
	}
}

func (this *Operations) Minus(a int, b int) int {
	return a + this.rev(b)
}

// 获取一个数的相反数 倍增(提高枚举效率)
func (this *Operations) rev(num int) int {
	if num == 0 {
		return num
	}
	ops := this.getOps(num)
	ret := 0
	for num != 0 {
		if (num > 0 && num+ops < 0) || (num < 0 && num+ops > 0) { // reset, when overflow
			ops = this.getOps(num)
			continue
		}
		num += ops
		ret += ops
		ops += ops
	}
	return ret
}

// 负数返回1 正数返回-1
func (this *Operations) getOps(num int) (ops int) {
	ops = 1
	if num > 0 {
		ops = this.one
	}
	return
}

func (this *Operations) Multiply(a int, b int) int {
	if a == 0 || b == 0 {
		return 0
	}
	if a == 1 {
		return b
	}
	if b == 1 {
		return a
	}
	l, r := a, b
	if a < 0 {
		l = this.rev(a)
	}
	if b < 0 {
		r = this.rev(b)
	}
	if l > r {
		l, r = r, l
	}
	ops := r
	cnt := 1
	for i := 0; i < 32; i++ {
		this.nums[i] = ops
		this.cnt[i] = cnt
		ops += ops
		cnt += cnt
	}
	// 进行倍增判断
	ret := 0
	idx := 0
	curCnt := 0
	for l != curCnt {
		if idx > 31 || this.cnt[idx]+curCnt > l { // reset
			ret += this.nums[idx+this.one]
			curCnt += this.cnt[idx+this.one]
			idx = 0
			continue
		}
		idx++
	}
	if (a < 0 && b > 0) || (b < 0 && a > 0) {
		return this.rev(ret)
	}
	return ret
}

func (this *Operations) Divide(a int, b int) int { //15/5
	if a == 0 || (a == 1 && b != 1) {
		return 0
	}
	if a == b {
		return 1
	}
	if b == 1 {
		return a
	}
	l, r := a, b
	if a < 0 {
		l = this.rev(a)
	}
	if b < 0 {
		r = this.rev(b)
	}
	if l < r {
		return 0
	}
	ops := r
	cnt := 1
	for i := 0; i < 32; i++ {
		this.nums[i] = ops
		this.cnt[i] = cnt
		ops += ops
		cnt += cnt
	}
	ret := 0
	idx := 0
	for l >= r {
		if idx > 31 || this.nums[idx] > l { // reset
			ret += this.cnt[idx+this.one]
			l += this.rev(this.nums[idx+this.one])
			idx = 0
			continue
		}
		idx++
	}
	if (a < 0 && b > 0) || (b < 0 && a > 0) {
		return this.rev(ret)
	}
	return ret
}
