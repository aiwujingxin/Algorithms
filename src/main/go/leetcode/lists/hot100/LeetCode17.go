package hot100

var mp = map[byte]string{
	'2': "abc",
	'3': "def",
	'4': "ghi",
	'5': "jkl",
	'6': "mno",
	'7': "pqrs",
	'8': "tuv",
	'9': "wxyz",
}

func letterCombinations(digits string) []string {
	if len(digits) == 0 {
		return []string{}
	}
	res := make([]string, 0)
	letterCombinationsHelper(digits, 0, &res, "")
	return res
}

func letterCombinationsHelper(digits string, index int, res *[]string, s string) {
	if index == len(digits) {
		*res = append(*res, s)
		return
	}
	str := mp[digits[index]]

	for i := 0; i < len(str); i++ {
		letterCombinationsHelper(digits, index+1, res, s+string(str[i]))
	}
}
