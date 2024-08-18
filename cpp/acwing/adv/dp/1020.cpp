#include <iostream>
#include <cstring>

using namespace std;

const int N = 1010, M = 85;

int n, m, t;

int v1[N], v2[N], w[N];
int f[M][M];

int main()
{
    cin >> n >> m >> t;
    for (int i = 1; i <= t; ++ i) cin >> v1[i] >> v2[i] >> w[i];

    memset(f, 0x3f, sizeof f); //求最小值要把除初始状态以外的所有状态初始化为+∞
    f[0][0] = 0; //这里我们把所有j,k小于0的初始状态都合并到f[0][0][0]中来转移,也就是下面的max操作
    for (int i = 1; i <= t; ++ i)
    {
        for (int j = n; j >= 0; -- j)
        {
            for (int k = m; k >= 0; -- k)
            {
                f[j][k] = min(f[j][k], f[max(j - v1[i], 0)][max(k - v2[i], 0)] + w[i]);
            }
        }
    }
    cout << f[n][m] << endl;
    return 0;
}
