# include <iostream>
using namespace std;
const int N = 1000010;
int a[N], q[N], hh, tt = -1;

int main()
{
    int n, k;
    cin >> n >> k;
    for (int i = 0; i < n; ++ i)
    {
        scanf("%d", &a[i]);
        if (i - k + 1 > q[hh]) ++ hh;                  // 若队首出窗口，hh加1
        while (hh <= tt && a[i] <= a[q[tt]]) -- tt;    // 若队尾不单调，tt减1
        q[++ tt] = i;                                  // 下标加到队尾
        if (i + 1 >= k) printf("%d ", a[q[hh]]);       // 输出结果
    }
    cout << endl;
    hh = 0; tt = -1;                                   // 重置！
    for (int i = 0; i < n; ++ i)
    {
        while (hh <= tt && a[i] >= a[q[tt]]) -- tt;
        q[++ tt] = i;
        if (i - q[hh] >= k) ++ hh;
        if (i + 1 >= k) printf("%d ", a[q[hh]]);
    }
    return 0;
}
