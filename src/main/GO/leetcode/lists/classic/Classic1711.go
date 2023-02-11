package classic

/**
 * @author wujingxinit@outlook.com
 * @date 2023/2/10 17:23
 */

//LeetCode243、244、245

func findClosest(words []string, word1 string, word2 string) int {
	arr1 := make([]int, 0)
	arr2 := make([]int, 0)

	for i := 0; i < len(words); i++ {
		if words[i] == word1 {
			arr1 = append(arr1, i)
		}
		if words[i] == word2 {
			arr2 = append(arr2, i)
		}
	}
	return smallestDifference(arr1, arr2)
}
