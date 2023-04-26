package offerII

import "math"

/**
 * @author wujingxinit@outlook.com
 * @date 2023/1/17 18:50
 */

//https://leetcode.com/problems/contains-duplicate-iii/solutions/1928511/golang-sliding-window/
//time is O(n*k) + O(k^2), space is O(1)
func containsNearbyAlmostDuplicate(nums []int, k int, t int) bool {
	meetCondition := func(i, j int) bool {
		if math.Abs(float64(nums[i]-nums[j])) <= float64(t) && math.Abs(float64(i-j)) <= float64(k) {
			return true
		}
		return false
	}

	checkInRange := func(start, end int) bool {
		for i := start; i < end; i++ {
			for j := i + 1; j <= end; j++ {
				if meetCondition(i, j) {
					return true
				}
			}
		}
		return false
	}

	if len(nums) <= k {
		return checkInRange(0, len(nums)-1)
	}

	if res := checkInRange(0, k); res {
		return res
	}

	windowStart := 1
	for windowEnd := windowStart + k; windowEnd < len(nums); windowEnd++ {
		for i := windowStart; i < windowEnd; i++ {
			if meetCondition(i, windowEnd) {
				return true
			}
		}
		windowStart++
	}
	return false
}

//https://leetcode.com/problems/contains-duplicate-iii/solutions/946511/golang-4ms-buckets-and-slide-window/
func containsNearbyAlmostDuplicateBucket(nums []int, k int, t int) bool {
	if len(nums) < 2 || k == 0 {
		return false
	}
	var min = math.MinInt32
	buckets := make(map[int]int, len(nums))
	for i, n := range nums {
		if len(buckets) > k {
			delete(buckets, (nums[i-k-1]-min)/(t+1))
		}
		idx := (n - min) / (t + 1)
		if _, ok := buckets[idx]; ok {
			return true
		}
		if t > 0 {
			if v, ok := buckets[idx-1]; ok && n-v <= t {
				return true
			}
			if v, ok := buckets[idx+1]; ok && v-n <= t {
				return true
			}
		}
		buckets[idx] = n
	}
	return false
}
