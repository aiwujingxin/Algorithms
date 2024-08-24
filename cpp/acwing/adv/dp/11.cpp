#include<cstdio>

const int N = 1010, mod = 1e9 + 7;

int f[N], cnt[N];
int main() {
    int n, m;
    scanf("%d%d", &n, &m);
    for(int i = 0; i <= m; i ++)  cnt[i] = 1;

    for(int i = 1; i <= n; i ++) {
        int v, w;
        scanf("%d%d", &v, &w);
        for(int j = m; j >= v; j --) {
            int value = f[j - v] + w;
            if(value > f[j]) {
                f[j] = value;
                cnt[j] = cnt[j - v];
            } else if(value == f[j]) {
                cnt[j] = (cnt[j] + cnt[j - v]) % mod;
            }
        }
    }

    printf("%d", cnt[m]);
    return 0;
}
