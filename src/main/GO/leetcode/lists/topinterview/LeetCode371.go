package topinterview

//https://www.youtube.com/watch?v=aDO7qhZDv10

//异或: https://www.ruanyifeng.com/blog/2021/01/_xor.html

//https://www.runoob.com/w3cnote/bit-operation.html
func getSum(a int, b int) int {
	if a == 0 {
		return b
	}
	if b == 0 {
		return a
	}
	for b != 0 {
		carry := a & b
		a = a ^ b
		b = carry << 1 //原始b已经利用完了
	}
	return a
}
