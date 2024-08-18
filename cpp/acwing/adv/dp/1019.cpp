#include <iostream>

using namespace std;

const int N = 510, M = 6010;

int n, m;
int v[N], w[N], s[N];
int f[N][M];

int main()
{
    cin >> n >> m;
    for (int i = 1; i <= n; ++ i) cin >> v[i] >> w[i] >> s[i];
    for (int i = 1; i <= n; ++ i)
    {
        for (int j = 0; j <= m; ++ j)
        {
            for (int k = 0; k <= s[i]; ++ k)
            {
                if (j - k * v[i] >= 0)
                {
                    f[i][j] = max(f[i][j], f[i - 1][j - k * v[i]] + k * w[i]);
                }
            }
        }
    }
    cout << f[n][m] << endl;
    return 0;
}
