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

#pragma endregion

const ll MOD = ll(1e9+7);

ll solve(ll n, ll m){
    ll ans = 1;

    for(int i=1; i <= n; i++) ans = ans * i % MOD;
    for(int i=1; i <= m; i++) ans = ans * i % MOD;

    if(n == m) ans = ans * 2 % MOD;

    return ans;
}

int main(int argc, char* argv[]){
    ios_base :: sync_with_stdio(false);
    cin.tie(NULL);
    //cout << fixed << setprecision(2);
    ll n, m;
    cin >> n >> m;

    if(abs(n - m) > 1){
        cout << "0\n";
    }else{
        cout << solve(n, m) << "\n";
    }

    return 0;
}