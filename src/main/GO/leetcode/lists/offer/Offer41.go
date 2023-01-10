package offer

/**
 * @author wujingxinit@outlook.com
 * @date 2023/1/10 17:24
 */

type MedianFinder struct {
	s []int
}

func ConstructorMedianFinder() MedianFinder {
	return MedianFinder{
		s: make([]int, 0, 2),
	}
}

func (this *MedianFinder) AddNum(num int) {
	insertI := searchIndex(this.s, num)
	this.insert(insertI, num)
}

func (this *MedianFinder) FindMedian() float64 {
	mid := (len(this.s) - 1) / 2
	if len(this.s)%2 == 0 {
		return float64(this.s[mid]+this.s[mid+1]) / 2
	} else {
		return float64(this.s[mid])
	}
}

//insert sort
func (this *MedianFinder) insert(index, value int) {
	this.s = append(this.s, 0)
	i := len(this.s) - 1
	for ; i > index; i-- {
		this.s[i] = this.s[i-1]
	}
	this.s[i] = value
}

func searchIndex(arr []int, x int) int {
	// Define f(-1) == false and f(n) == true.
	// Invariant: f(left-1) == false, f(right) == true.
	left, right := 0, len(arr)
	for left < right {
		mid := int(uint(left+right) >> 1) // avoid overflow when computing mid
		// left ≤ mid < right
		if arr[mid] < x {
			left = mid + 1 // preserves f(left-1) == false
		} else {
			right = mid // preserves f(right) == true
		}
	}
	// left == right, f(left-1) == false, and f(right) (= f(left)) == true  =>  answer is left.
	return left
}
