/*
 * @Author: aiwujingxin@gmail.com
 * @Date: 2023-04-20 21:59:36
 * @LastEditTime: 2023-04-20 22:04:39
 * @LastEditors: aiwujingxin@gmail.com
 */
#include <iostream>
using namespace std;
const int N = 1010;
int a[N][N], s[N][N];
int main() {
    int n, m, q;
    cin >> n >> m >> q;
    for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= m; j++) {
            scanf("%d", &a[i][j]);
            // 求前缀和
            s[i][j] = s[i][j - 1] + s[i - 1][j] - s[i - 1][j - 1] + a[i][j];
        }
    }
    while (q--) {
        int x1, y1, x2, y2;
        scanf("%d%d%d%d", &x1, &y1, &x2, &y2);
        // 算子矩阵的和
        printf("%d\n",s[x2][y2] - s[x2][y1 - 1] - s[x1 - 1][y2] + s[x1 - 1][y1 - 1]);
    }
    return 0;
}
