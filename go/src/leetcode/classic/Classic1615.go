package classic

/**
 * @Author: jingxinwu
 * @Date: 2023/2/21 22:04
 */
func masterMind(leetcode.solution string, guess string) []int {
	total, hit := 0, 0
	intMap := make([]int, 26)
	for i := 0; i < 4; i++ {
		intMap[guess[i]-'A']++
	}

	for i := 0; i < 4; i++ {
		if leetcode.solution[i] == guess[i] {
			hit++
		}
		if intMap[leetcode.solution[i]-'A'] > 0 {
			total++
			intMap[leetcode.solution[i]-'A']--
		}
	}
	return []int{hit, total - hit}
}
