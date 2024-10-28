//分层图:对同一个边有不同种操作,我们采用分层图,第一种操作在第一层,第二种操作在第二层,以此类推
#include <iostream>
#include <cstdio>
#include <algorithm>
#include <limits.h>
#include <cstring>
#include <queue>
using namespace std;

typedef long long LL;
typedef pair<int, int> PII;
const int INF = 0x3f3f3f3f, INF_BIT = 0x3f;

const int N = 1.1e5 + 10, M = 2.5e6 + 10;

int n, m, k;
int st, ed;
int u, v, w;

struct Node{
    int from, to, len, next;
};
Node a[M];
int ind;
int pre[N];
void add(int u, int v, int w){
    ind++;
    a[ind].from = u;
    a[ind].to = v;
    a[ind].len = w;
    a[ind].next = pre[u];
    pre[u] = ind;
}

int dis[N];
bool vis[N];
priority_queue<PII, vector<PII>, greater<PII> > q;
void dijk(){
    memset(dis, INF_BIT, sizeof(dis));
    dis[st] = 0;
    memset(vis, false, sizeof(vis));
    q.push({dis[st], st});
    while(!q.empty()){
        int x = q.top().second, d = q.top().first;
        q.pop();
        vis[x] = true;
        for(int i = pre[x];i;i = a[i].next){
            int to = a[i].to;
            if(!vis[to] && dis[to] > d + a[i].len){
                dis[to] = d + a[i].len;
                q.push({dis[to], to});
            }
        }
    }
}

int ans = INF;

int main(){
    scanf("%d%d%d", &n, &m, &k);
    scanf("%d%d", &st, &ed);
    st++, ed++;
    for(int i = 1;i <= m;i++){
        scanf("%d%d%d", &u, &v, &w);
        u++, v++;
        for(int j = 0;j <= k;j++){
            add(u + n * j, v + n * j, w);
            add(v + n * j, u + n * j, w);
        }
        for(int j = 0;j < k;j++){
            add(u + n * j, v + n * (j + 1), 0);
            add(v + n * j, u + n * (j + 1), 0);
        }
    }
    dijk();
    for(int i = 0;i <= k;i++){
        ans = min(ans, dis[ed + i * n]);
    }
    printf("%d\n", ans);
    return 0;
}
