#include <iostream>
#include <algorithm>

using namespace std;
const int N = 1010;
int n;
int a[N], g[N], f[N];

int main(){
    while(cin >> a[n]) n ++;

    int res = 0;
    for(int i = 0; i < n; i ++) {
        f[i] = 1;
        for(int j = 0; j < i; j ++)
            if(a[j] >= a[i])
                f[i] = max(f[i], f[j] + 1);
        res = max(res, f[i]);
    }

    int cnt = 0;
    for(int i = 0; i < n; i ++){
        int k = 0;
        while(k < cnt && g[k] < a[i]) k ++; // 从左往右开始找, 找到第一个最大的比a[i]小的值
        g[k] = a[i];
        if(k >= cnt) cnt ++;
    }

    cout << res << endl;
    cout << cnt << endl;
    return 0;
}
