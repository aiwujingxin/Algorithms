#include <cstring>
#include <iostream>
#include <algorithm>

using namespace std;

const int N = 1010;

int m, n;
int f[N];

int main()
{
    cin >> m >> n;
    for (int i = 0; i < n; i ++ )
    {
        int v, w;
        cin >> v >> w;
        for (int j = m; j >= v; j -- )
            f[j] = max(f[j], f[j - v] + w);
    }
    cout << f[m] << endl;
    return 0;
}
