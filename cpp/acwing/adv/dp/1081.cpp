#include<bits/stdc++.h>
using namespace std;
const int N = 35; //位数

int f[N][N];// f[a][b]表示从a个数中选b个数的方案数，即组合数

int K, B; //K是能用的1的个数，B是B进制

//求组合数：预处理
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

            //当前位填0，从剩下的所有位（共有i位）中选K-last个数。
            //对应于：左分支中0的情况，合法
            res += f[i][ K -last];//i个数中选K-last个数的组合数是多少，选出来这些位填1，其他位填0

            if(x > 1){
               //当前位填1，从剩下的所有位（共有i位）中选K-last-1个数。对应于：左分支中填1的情况，合法
               if(K - last -1 >= 0) res += f[i][K -last -1];//i个数中选K-last-1个数填1的组合数是多少
                //为什么可以直接break？因为当前位的最大数字大于1，那么只需要考虑当前位为0和1时的方案数
                break;
            } else {
                //上面统计完了**左分支**的所有情况，和右分支大于1的情况，
                //这个else 是x==1，
                //对应于：右分支为1的情况，即限定值为1的情况，也就是左分支只能取0
                //此时的处理是，直接放到下一位来处理
                //只不过下一位可使用的1的个数会少1，体现在代码上是last+1
                last ++;
                //如果已经填的个数last > 需要填的个数K，不合法break
                if(last > K) break;
            }

        }
        //上面处理完了这棵树的**所有**左分支，就剩下最后一种右分支的情况
        // 也就是遍历到最后1位，在vector中就是下标为0的地方：i==0；
        // 并且最后1位取0，才算作一种情况res++。因为最后1位不为0的话，已经被上面的ifelse处理了。
        if(i==0 && last == K) res++;
    }

    return res;
}

int main(){
    init();
    int l,r;
    cin >>  l >> r >> K >>B;
    cout<< dp(r) - dp(l-1) <<endl;
}
