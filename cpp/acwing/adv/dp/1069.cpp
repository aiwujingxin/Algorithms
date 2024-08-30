#include <iostream>
using namespace std;
typedef __int128 LL;
const int N = 60;
int n;
int a[N];
LL f[N][N];
ostream &operator << (ostream &out,LL x) {
    if (!x) {
        out << 0;
        return out;
    }
    int stk[110],top = 0;
    while (x) stk[++top] = x % 10,x /= 10;
    for (int i = top;i >= 1;i--) out << stk[i];
    return out;
}
int main () {
    cin >> n;
    for (int i = 1;i <= n;i++) cin >> a[i];
    for (int len = 3;len <= n;len++) {
        for (int i = 1;i + len - 1 <= n;i++) {
            int j = i + len - 1;
            f[i][j] = 1e126;
            for (int k = i + 1;k <= j - 1;k++) f[i][j] = min (f[i][j],f[i][k] + f[k][j] + (LL)a[i] * a[k] * a[j]);
        }
    }
    cout << f[1][n] << endl;
    return 0;
}
