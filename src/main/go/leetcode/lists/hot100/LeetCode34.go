package hot100

func searchRange(nums []int, target int) []int {
	if len(nums) == 0 {
		return []int{-1, -1}
	}
	return []int{findFirst(nums, target), findLast(nums, target)}
}

//[7,8] 8
func findFirst(nums []int, target int) int {
	left, right := 0, len(nums)-1
	for left <= right {
		mid := (left + right) / 2
		if nums[mid] < target {
			left = mid + 1
		} else {
			right = mid
		}
	}
	if nums[left] != target {
		return -1
	}
	return left
}

//[2,2]  2

func findLast(nums []int, target int) int {
	left, right := 0, len(nums)-1
	for left+1 < right {
		mid := (left + right) / 2
		if nums[mid] <= target {
			left = mid
		} else {
			right = mid - 1
		}
	}
	if nums[right] == target {
		return right
	}
	if nums[left] == target {
		return left
	}
	return -1
}
