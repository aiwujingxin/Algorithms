/*
 * @Author: aiwujingxin@gmail.com
 * @Date: 2023-04-17 23:08:15
 * @LastEditTime: 2023-05-23 09:29:10
 * @LastEditors: Jingxin Wu jingxin.wu@shopee.com
 */
bool check(int x) { /* ... */
}  // 检查x是否满足某种性质

// 区间[l, r]被划分成[l, mid]和[mid + 1, r]时使用：
int bsearch_1(int l, int r) {
    while (l < r) {
        int mid = l + r >> 1;
        if (check(mid)) {
            r = mid;  // check()判断mid是否满足性质
        } else {
            l = mid + 1;
        }
    }
    return l;
}
// 区间[l, r]被划分成[l, mid - 1]和[mid, r]时使用：
int bsearch_2(int l, int r) {
    while (l < r) {
        int mid = l + r + 1 >> 1;
        if (check(mid)) {
            l = mid;
        } else {
            r = mid - 1;
        }
    }
    return l;
}

double bsearch_3(double l, double r) {
    const double eps = 1e-6;  // eps 表示精度，取决于题目对精度的要求
    while (r - l > eps) {
        double mid = (l + r) / 2;
        if (check(mid))
            r = mid;
        else
            l = mid;
    }
    return l;
}

#include <iostream>
using namespace std;
const int N = 100010;
int n, m, q[N];
int main() {
    scanf("%d%d", &n, &m);
    for (int i = 0; i < n; i++)
        scanf("%d", &q[i]);
    while (m--) {
        int x;
        scanf("%d", &x);
        int l = 0, r = n - 1;
        while (l < r) {
            int mid = l + r >> 1;
            if (q[mid] >= x) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        if (q[l] != x) {
            cout << "-1 -1" << endl;
        } else {
            cout << l << ' ';
            int l = 0, r = n - 1;
            while (l < r) {
                int mid = l + r + 1 >> 1;
                if (q[mid] <= x) {
                    l = mid;
                } else {
                    r = mid - 1;
                }
            }
            cout << l << endl;
        }
    }
    return 0;
}