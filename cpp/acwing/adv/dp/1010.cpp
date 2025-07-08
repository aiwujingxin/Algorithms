#include <iostream>
#include <algorithm>
using namespace std;
const int N = 1010;
int n = 0;
int a[N],f[N];
int main () {
    while (cin >> a[n + 1]) n++;
    int ans = 0;
    for (int i = 1;i <= n;i++) {
        f[i] = 1;
        for (int j = 1;j < i;j++) {
            if (a[j] >= a[i]) f[i] = max (f[i],f[j]+1);
        }
        ans = max (ans,f[i]);
    }
    cout << ans << endl;
    ans = 0;
    for (int i = 1;i <= n;i++) {
        f[i] = 1;
        for (int j = 1;j < i;j++) {
            if (a[j] < a[i]) f[i] = max (f[i],f[j]+1);
        }
        ans = max (ans,f[i]);
    }
    cout << ans << endl;
    return 0;
}
