#include <iostream>
#include <cstring>
using namespace std;
const int N = 110, M = N << 1;
int n, w[M], f[M][M];
int main() {
    scanf("%d", &n);
    for (int i = 1; i <= n; ++i) scanf("%d", &w[i]), w[i + n] = w[i];
    memset(f, -0x3f, sizeof f);
    for (int i = 2 * n; i >= 1; --i) {
        for (int j = i + 1; j <= 2 * n; ++j) {
            if (j - i == 1) {
                f[i][j] = 0;
            } else {
                for (int k = i + 1; k < j; ++k) {
                    f[i][j] = max(f[i][j], f[i][k] + f[k][j] + w[i] * w[k] * w[j]);
                }
            }
        }
    }
    int res = 0;
    for (int i = 1; i <= n; ++i) {
        res = max(res, f[i][i + n]);
    }
    printf("%d\n", res);
    return 0;
}
