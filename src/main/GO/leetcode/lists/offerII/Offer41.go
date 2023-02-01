package offerII

/**
 * @author wujingxinit@outlook.com
 * @date 2023/1/16 13:08
 */

type MovingAverage struct {
	sum  int
	size int
	nums []int
}

/** Initialize your data structure here. */
func ConstructorMovingAverage(size int) MovingAverage {
	return MovingAverage{
		sum:  0,
		size: size,
		nums: make([]int, 0),
	}
}

func (this *MovingAverage) Next(val int) float64 {
	if len(this.nums) == this.size {
		this.sum -= this.nums[0]
		this.nums = this.nums[1:]
	}
	this.sum += val
	this.nums = append(this.nums, val)
	return float64(this.sum) / float64(len(this.nums))
}
