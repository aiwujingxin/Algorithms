package offerII

import "strconv"

/**
 * @author wujingxinit@outlook.com
 * @date 2023/1/12 14:21
 */

func addBinary(a string, b string) string {
	carry := 0
	res := ""
	i, j := len(a)-1, len(b)-1
	for i >= 0 || j >= 0 {
		var one, two int
		if i < 0 {
			one = 0
		} else {
			one = int(a[i] - '0')
		}
		if j < 0 {
			two = 0
		} else {
			two = int(b[j] - '0')
		}
		t := one ^ two ^ carry
		if one == 1 && two == 1 {
			carry = 1
		} else {
			carry = (one ^ two) & carry
		}
		res = strconv.Itoa(t) + res
		i--
		j--
	}
	if carry == 1 {
		return strconv.Itoa(carry) + res
	}
	return res
}
