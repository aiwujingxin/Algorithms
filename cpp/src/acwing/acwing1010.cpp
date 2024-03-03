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
            if(a[j] >= a[i])                // 不高于, 可以等于， 最长下降子序列
                f[i] = max(f[i], f[j] + 1);
        res = max(res, f[i]);
    }

    // same as A1010.cpp
    int len = 0;
    for(int i = 0; i < n; i ++){
        int k = 0;
        while(k < len && g[k] < a[i]) k ++; // 从左往右开始找, 找到第一个最大的比a[i]小的值
        g[k] = a[i];
        if(k >= len) len ++;
    }

    cout << res << endl;
    cout << len << endl;
    return 0;
}
