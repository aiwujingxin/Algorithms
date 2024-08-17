#include <iostream>

using namespace std;

const int N = 1010;

int n;
int w[N], f[N];

int main() {
    cin >> n;
    for (int i = 0; i < n; i++) cin >> w[i];

    int mx = 1;    // 找出所计算的f[i]之中的最大值，边算边找
    for (int i = 0; i < n; i++) {
        f[i] = 1;    // 设f[i]默认为1，找不到前面数字小于自己的时候就为1
        for (int j = 0; j < i; j++) {
            if (w[i] > w[j]) f[i] = max(f[i], f[j] + 1);    // 前一个小于自己的数结尾的最大上升子序列加上自己，即+1
        }
        mx = max(mx, f[i]);
    }

    cout << mx << endl;
    return 0;
}
