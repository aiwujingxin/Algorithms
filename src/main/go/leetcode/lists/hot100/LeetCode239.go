package hot100

//another deque : https://leetcode.com/problems/sliding-window-maximum/solutions/771937/golang-use-container-list-as-deque/

//https://leetcode.com/problems/sliding-window-maximum/solutions/65939/golang-solution-using-slice-as-deque/
func maxSlidingWindow(nums []int, k int) []int {
	length := len(nums)
	if length == 0 {
		return []int{}
	}

	// get initial deque from nums[0:k-1]
	deque := []int{0}
	for i := 1; i < k; i++ {
		if len(deque) == 0 || nums[i] >= nums[deque[0]] { // case A
			deque = []int{i}
		} else if nums[i] < nums[deque[len(deque)-1]] { // case B
			deque = append(deque, i)
		} else {
			insert(&deque, nums, i) // case C
		}
	}

	// proceed and update deque
	res := make([]int, length-k+1)
	res[0] = nums[deque[0]]
	for i := 1; i < length-k+1; i++ {
		idx := i + k - 1

		if deque[0] < i { // discard if out of window range
			deque = deque[1:]
		}

		if len(deque) == 0 || nums[idx] >= nums[deque[0]] { // case A
			deque = []int{idx}
			res[i] = nums[idx]
		} else if nums[idx] < nums[deque[len(deque)-1]] { // case B
			res[i] = nums[deque[0]]
			deque = append(deque, idx)
		} else {
			res[i] = nums[deque[0]]
			insert(&deque, nums, idx) // case C
		}
	}
	return res
}

// insert inserts nums[index] to deque while searching a place to insert
// and discard all smaller values. Looks little messy but we update length of slice, so need to use a pointer.
func insert(pdeque *[]int, nums []int, index int) {
	deque := *pdeque
	j := len(deque) - 1
	for nums[index] >= nums[deque[j]] {
		j--
	}
	deque[j+1] = index
	deque = deque[:j+2]
	*pdeque = deque
}
