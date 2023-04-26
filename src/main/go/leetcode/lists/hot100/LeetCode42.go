package hot100

func trap(height []int) int {
	if len(height) == 0 {
		return 0
	}
	left, right := make([]int, len(height)), make([]int, len(height))
	res, lmax, rmax := 0, -1, -1
	for i := 0; i < len(height); i++ {
		if height[i] > lmax {
			lmax = height[i]
		}
		left[i] = lmax
	}
	for i := len(height) - 1; i >= 0; i-- {
		if height[i] > rmax {
			rmax = height[i]
		}
		right[i] = rmax
	}
	for i := 0; i < len(height); i++ {
		res += Min(left[i], right[i]) - height[i]
	}
	return res
}
