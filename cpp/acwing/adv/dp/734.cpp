#include <cstdio>
#include <iostream>
#include <cstring>
#include <algorithm>
using namespace std;
const int N = 105, S = 10005;
int n;
int f[S];
struct Node{
 int s, e, l;
 bool operator < (const Node &x) const{
     return s * x.l < x.s * l;
 }
}a[N];
int main() {
 int T, cnt = 0; scanf("%d", &T);
 while(T--) {
     memset(f, 0xcf, sizeof f);
     scanf("%d", &n);
     int t = 0;
     for(int i = 1, s, e, l; i <= n; i++) {
         scanf("%d%d%d", &s, &e, &l);
         t += s; a[i] = (Node) { s, e, l };
     }
     sort(a + 1, a + 1 + n);
     f[0] = 0;
     for(int i = 1; i <= n; i++) {
         for(int j = t; j >= a[i].s; j--)
             f[j] = max(f[j], f[j - a[i].s] + a[i].e - (j - a[i].s) * a[i].l);
     }
     int res = 0;
     for(int i = 1; i <= t; i++) res = max(res, f[i]);
     printf("Case #%d: %d\n", ++cnt, res);
 }
 return 0;
}
