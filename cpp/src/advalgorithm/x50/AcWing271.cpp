#include <cstring>
#include <iostream>
#include <algorithm>

using namespace std;

typedef long long LL;

const int N = 31;

int n;
LL f[N][N][N][N][N];

int main()
{
    while (cin >> n, n)
    {
        int s[5] = {0};
        for (int i = 0; i < n; i++)
            cin >> s[i];
        memset(f, 0, sizeof f);
        f[0][0][0][0][0] = 1;

        for (int a = 0; a <= s[0]; a++)
            for (int b = 0; b <= min(a, s[1]); b++)
                for (int c = 0; c <= min(b, s[2]); c++)
                    for (int d = 0; d <= min(c, s[3]); d++)
                        for (int e = 0; e <= min(d, s[4]); e++)
                        {
                            LL &x = f[a][b][c][d][e];
                            if (a && a > b)
                                x += f[a - 1][b][c][d][e];
                            if (b && b > c)
                                x += f[a][b - 1][c][d][e];
                            if (c && c > d)
                                x += f[a][b][c - 1][d][e];
                            if (d && d > e)
                                x += f[a][b][c][d - 1][e];
                            if (e)
                                x += f[a][b][c][d][e - 1];
                        }
        cout << f[s[0]][s[1]][s[2]][s[3]][s[4]] << endl;
    }

    return 0;
}