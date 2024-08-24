#include <iostream>
#include <cstring>
#include <algorithm>

using namespace std;

const int N = 110, M = 25010;
int n;
int v[N];
bool f[M];

int main()
{
    int T = 1;
    cin >> T;
    while (T -- )
    {
        cin >> n;
        for (int i = 1; i <= n; ++ i) cin >> v[i];
        sort(v + 1, v + n + 1);
        int m = v[n], res = 0;
        memset(f, 0, sizeof f);
        f[0] = true;
        for (int i = 1; i <= n; ++ i)
        {
            if (f[v[i]]) continue;
            res ++ ;
            for (int j = v[i]; j <= m; ++ j)
            {
                f[j] |= f[j - v[i]];
            }
        }
        cout << res << endl;
    }
    return 0;
}

