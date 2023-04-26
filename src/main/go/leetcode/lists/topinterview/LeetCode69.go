package topinterview

func mySqrt(x int) int {
	left, right := 0, x
	for left <= right {
		mid := (left + right) / 2
		t := mid * mid
		if t == x {
			return mid
		}
		if t < x {
			left = mid + 1
		} else if t > x {
			right = mid - 1
		}
	}
	return right
}
