package hot100

func decodeString(s string) string {
	if len(s) == 0 {
		return ""
	}
	res, _ := decodeStringHelper(s, 0)
	return res
}

func decodeStringHelper(s string, i int) (string, int) {
	sum := 0
	var str string
	for i < len(s) {
		if IsNumber(s[i]) {
			//go study
			sum = sum*10 + int(s[i]-'0')
		} else if s[i] == '[' {
			substr, index := decodeStringHelper(s, i+1)
			i = index
			for sum > 0 {
				str += substr
				sum--
			}
		} else if s[i] == ']' {
			return str, i
		} else {
			str += string(s[i])
		}
		i++
	}
	return str, i
}
