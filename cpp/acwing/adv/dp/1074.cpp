#include <iostream>
#include <algorithm>
#include <cstring>
using namespace std;
const int N = 6010;
int n;
int happy[N]; //每个职工的高兴度
int f[N][2]; //上面有解释哦~
int e[N],ne[N],h[N],idx; //链表，用来模拟建一个树
bool has_father[N]; //判断当前节点是否有父节点
void add(int a,int b){ //把a插入树中
    e[idx] = b,ne[idx] = h[a],h[a] = idx ++;
}
void dfs(int u){ //开始求解题目
    f[u][1] = happy[u]; //如果选当前节点u，就可以把f[u,1]先怼上他的高兴度
    for(int i = h[u];~i;i = ne[i]){ //遍历树
        int j = e[i];
        dfs(j); //回溯
        //状态转移部分，上面有详细讲解~
        f[u][0] += max(f[j][1],f[j][0]);
        f[u][1] += f[j][0];
    }
}
int main(){
    scanf("%d",&n);
    for(int i = 1;i <= n;i ++) scanf("%d",&happy[i]); //输入每个人的高兴度
    memset(h,-1,sizeof h); //把h都赋值为-1
    for(int i = 1;i < n;i ++){
        int a,b; //对应题目中的L,K,表示b是a的上司
        scanf("%d%d",&a,&b); //输入~
        has_father[a] = true; //说明a他有上司
        add(b,a); //把a加入到b的后面
    }
    int root = 1; //用来找根节点
    while(has_father[root]) root ++; //找根节点
    dfs(root); //从根节点开始搜索
    printf("%d\n",max(f[root][0],f[root][1])); //输出不选根节点与选根节点的最大值
    return 0;
}