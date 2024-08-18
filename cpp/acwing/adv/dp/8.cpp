#include <bits/stdc++.h>

using namespace std;

int n, V, M;
const int N = 1e3 + 5;
int v[N], m[N], w[N], f[N][N];

signed main () {
    cin >> n >> V >> M;
    for (int i = 1; i <= n; i ++) {
        cin >> v[i] >> m[i] >> w[i];//体积，重量，价值
    }
    for (int i = 1; i <= n; i ++)
        for (int j = V; j >= v[i]; j --)
            for (int k = M; k >= m[i]; k --)
                f[j][k] = max (f[j - v[i]][k - m[i]] + w[i], f[j][k]);//动态转移方程，01 背包的思路
    cout << f[V][M];
}
