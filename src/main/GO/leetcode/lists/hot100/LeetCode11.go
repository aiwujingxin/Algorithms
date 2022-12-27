package hot100

func maxArea(height []int) int {

	if len(height) == 0 {
		return 0
	}
	res, l, r := 0, 0, len(height)-1
	for l < r {
		res = Max(res, Min(height[l], height[r])*(r-l))
		if height[l] < height[r] {
			l++
		} else {
			r--
		}
	}
	return res
}
