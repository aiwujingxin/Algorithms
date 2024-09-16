#include<bits/stdc++.h>
using namespace std;
const int N = 35; //位数

int f[N][N];// f[a][b]表示从a个数中选b个数的方案数，即组合数

int K, B; //K是能用的1的个数，B是B进制

//求组合数：预处理 C(i,j) = C(i-1,j-1) + C(i-1,j)
void init(){
    for(int i=0; i< N ;i ++)
        for(int j =0; j<= i ;j++)
            if(!j) f[i][j] =1;
            else f[i][j] =f[i-1][j] +f[i-1][j-1];
}

 //求区间[0,n]中的 “满足条件的数” 的个数
 //“满足条件的数”是指：一个数的B进制表示，其中有K位是1、其他位全是0
int dp(int n){

    if(n == 0) return 0; //如果上界n是0，直接就是0种

    vector<int> nums; //存放n在B进制下的每一位
    //把n在B进制下的每一位单独拿出来
    while(n) nums.push_back( n% B) , n/= B;

    int res = 0;//答案：[0,n]中共有多少个合法的数

    //last在数位dp中存的是：右边分支往下走的时候保存前面的信息
    //遍历当前位的时候，记录之前那些位已经占用多少个1，那么当前还能用的1的个数就是K-last
    int last = 0;

    //从最高位开始遍历每一位
    for(int i = nums.size()-1; i>= 0; i--){

        int x = nums[i]; //取当前位上的数

        if(x>=1){ //只有x>=1的时候才可以讨论左右分支

            //第i位填0，从剩下的所有位（共有i位）中选K-last个数。
            res += f[i][ K -last];//i个数中选K-last个数的组合数是多少，选出来这些位填1，其他位填0

            if(x > 1){ // 第i位>1时
               //第i位填1，从剩下的所有位（共有i位）中选K-last-1个数。对应于：左分支中填1的情况，合法
               if(K - last -1 >= 0) res += f[i][K -last -1];//i个数中选K-last-1个数填1的组合数是多少
                //第i位放大于1的数, 不符合要求: 只需要考虑当前位为0和1时的方案数,则break
                break;
            } else {
                // 第i位==1时, 不能用组合数计算,因为要确保答案中的数字比原数字小, 所以固定第i位为1, 继续枚举下一位
                last ++;
                //如果已经填的1的个数> K个，不合法break
                if(last > K) break;
            }
        }
        if(i==0 && last == K) res++; // 特判, 走到末位的情况
    }

    return res;
}

int main(){
    init();
    int l,r;
    cin >>  l >> r >> K >>B;
    cout<< dp(r) - dp(l-1) <<endl;
}
