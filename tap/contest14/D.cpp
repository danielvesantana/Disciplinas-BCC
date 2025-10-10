#include <bits/stdc++.h>
using namespace std;
 
#pragma region
typedef long long ll; 
typedef pair<ll, ll> pll;
typedef pair<int, int> pii;
typedef vector<int> vi;
typedef vector<ll> vl;
 
#define F first
#define S second
#define PB push_back
#define MP make_pair
const int N = 1000;
int vet[N];
int dp[N][N];
char m[N][N];
int n;
ll mod = (1e9)+7;
 
#pragma endregion
 
int solve(int i, int j) {
    if (i < 0 || j < 0 || i >= n || j >= n || m[i][j] == '*') {
        return 0; 
    }
 
    if (dp[i][j] != -1) {
        return dp[i][j];
    }
 
    if (i == n - 1 && j == n - 1) {
        return 1;
    }
 
    int ans1, ans2;
    ans1 = ans2 = 0;
    
    ans1 += solve(i, j + 1) % mod;
    ans2 += solve(i + 1, j) % mod;
 
    return dp[i][j] = (ans1 + ans2) % mod;
}
 
int main(int argc, char* argv[]) {
    ios_base :: sync_with_stdio(false);
    cin.tie(NULL);
    //cout << fixed << setprecision(2);
    memset(dp, -1, sizeof(dp));
 
    cin >> n;
 
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            cin >> m[i][j];
        }
    }
 
    int ans = solve(0, 0);
    cout << ans << "\n";
 
    return 0;
}