#include <bits/stdc++.h>
using namespace std;
#define N 310
int f[N][N];
vector<int> son[N];
int w[N];
int n, m;
void dfs(int x)
{
    f[x][0] = 0;
    // f[x][1] = w[x];
    // 上面这一句根本就不可以写（因为之前做的是假设在不选x的情况下的f[x][j]），最初本来应该是0；
    for (int i = 0; i < son[x].size(); i++)
    {
        int y = son[x][i];
        dfs(y); // 先把下面的处理掉
        for (int t = m; t >= 0; t--)
            for (int j = t; j >= 0; j--)
                if (t - j >= 0)
                    f[x][t] = max(f[x][t], f[x][t - j] + f[y][j]);
    }
    if (x != 0)
        for (int t = m; t > 0; t--)
            f[x][t] = f[x][t - 1] + w[x]; // 如果x不是0，那么一定要把x选上
}
int main()
{
    scanf("%d%d", &n, &m);
    for (int i = 1; i <= n; i++)
    {
        int x, y;
        scanf("%d%d", &x, &y);
        son[x].push_back(i);
        w[i] = y;
    }
    dfs(0);
    printf("%d", f[0][m]);
    return 0;
}