/*
 * @Author: aiwujingxin@gmail.com
 * @Date: 2023-04-20 21:46:19
 * @LastEditTime: 2023-04-20 21:52:28
 * @LastEditors: aiwujingxin@gmail.com
 */
#include <cstdio>
#include <iostream>
using namespace std;
const int N = 1e5 + 10;
int a[N], sum[N];
// 区间
int main() {
    int n, m, x;
    cin >> n >> m;
    for (int i = 1; i <= n; i++) {
        cin >> x;
        sum[i] = x + sum[i - 1];
    }
    while (m--) {
        int l, r;
        cin >> l >> r;
        cout << sum[r] - sum[l - 1] << endl;
    }
    return 0;
}
