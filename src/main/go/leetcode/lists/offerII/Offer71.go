package offerII

import (
	"math/rand"
)

/**
 * @author wujingxinit@outlook.com
 * @date 2023/2/1 16:34
 */

//[1, 2, 3, 5]
//[1, 3, 6, 11]

type Solution struct {
	pre []int
	w   []int
}

func ConstructorSolution(w []int) Solution {
	preSum := make([]int, len(w))
	preSum[0] = w[0]
	for i := 1; i < len(w); i++ {
		preSum[i] = preSum[i-1] + w[i]
	}
	return Solution{
		pre: preSum,
		w:   w,
	}
}

// PickIndex 选取的是下标  在前缀和数组中找到第一个严格大于它的数，那个数的下标就是我们要找的下标
func (this *Solution) PickIndex() int {
	x := rand.Intn(this.pre[len(this.pre)-1]) + 1 // 生成[1,sum]范围的随机数。nextInt(n)生成[0,n)的随机数
	left, right := 0, len(this.pre)-1
	for left <= right {
		mid := (left + right) / 2
		if this.pre[mid] < x {
			left = mid + 1
		} else {
			right = mid - 1
		}
	}
	return left
}
