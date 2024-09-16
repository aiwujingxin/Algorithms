#include<iostream>
#include<cstring>
#include<algorithm>
#include<cmath>
#include<vector>
using namespace std;
const int N =11;
int f[N][10][10];
//f[i][j][u]表示一共有i位，并且最高位为j位的所有数字中数字u的个数
int x,y;

void init(){
    //初始化
    for(int i = 0;i <= 9;++i) f[1][i][i] = 1;
    for(int i = 2;i <= N;++i){ //枚举位数
        for(int j = 0;j <= 9;++j){ //枚举最高位
            for(int u = 0;u <= 9;++u){  //计算数字u出现的次数
                if(u == j) f[i][j][u] += pow(10,i - 1);
                for(int k = 0;k <= 9;++k){
                    f[i][j][u] += f[i - 1][k][u];
                }
            }
        }
    }
}

int dp(int n,int u){
    if(!n) return u ? 0 : 1;

    vector<int> nums;

    while(n) nums.push_back(n % 10),n /= 10;

    int res = 0;
    int last = 0;  //前面位数出现的u的个数

    for(int i = nums.size() -1;i >= 0;--i){  //从最高位开始枚举

        int x = nums[i];

        //统计后面u的个数
        //计算最高位填0 ~ x - 1的情况
        //记得最高位特判前导0的情况,需要从1开始（关键）
        for(int j = i == nums.size() - 1 ? 1 : 0;j < x;++j){
            res += f[i + 1][j][u];
        }

        //统计前面u的个数
        res += last * x * pow(10,i);

        //进入右分支
        if(x == u) last++;


        //枚举到最后一个数字了 ，结果再加上最后一个数字含有的u的数量,即为last
        if(!i) res += last;
    }

     //所有0~n-1位数的方案数量,例如000123是不合法的,而123确实合法的
    for(int i=1;i<nums.size();i++){
        for(int j= i!=1;j<=9;j++){
            res += f[i][j][u];
        }
    }

    return res;
}

int main(){

    init();
    while(cin >> x >> y,x || y){

        if(x > y) swap(x,y); //有可能出现x > y的情况

        for(int i = 0;i <= 9;++i){
            cout << dp(y,i) - dp(x- 1,i) << ' ';
        }
        cout << endl;
    }
    return 0;
}
