package offerII

/**
 * @author wujingxinit@outlook.com
 * @date 2023/1/16 14:06
 */

type RecentCounter struct {
	nums []int
}

func ConstructorRecentCounter() RecentCounter {
	return RecentCounter{
		nums: make([]int, 0),
	}
}

func (this *RecentCounter) Ping(t int) int {
	this.nums = append(this.nums, t)
	for (this.nums)[0] < t-3000 {
		this.nums = this.nums[1:]
	}
	return len(this.nums)
}
