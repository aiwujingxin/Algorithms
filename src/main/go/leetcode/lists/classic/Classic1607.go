package classic

/**
 * @author wujingxinit@outlook.com
 * @date 2023/2/3 17:13
 */

//https://leetcode.cn/problems/maximum-lcci/solution/ji-jian-you-fu-hao-zheng-shu-wei-yi-fa-by-taichira/
func maximum(a int, b int) int {
	//整数右移高位补0,负数右移高位补1
	//a>b,ret>0,temp&1=0
	//a<b,ret<0,temp&1=1
	ret := int64(a - b)
	ret = int64(a) - ret&(ret>>63)
	return int(ret)
}
