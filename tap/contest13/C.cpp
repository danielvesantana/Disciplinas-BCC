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
const int N = 200010;
int vet[N];
int n, m;
ll dp[N];
ll mod = (1e9)+7;
bool flag = false;

#pragma endregion

bool test(ll aux){
    if(binary_search(vet, vet+m, aux)){
        return false;
    }else{
        return true;
    }
}

ll solve(ll aux){
    if(aux < 0) {
        return 0;
    }if(aux == 0){
        flag = true;
        return 1;
    }

    ll ans = 0;
    if(dp[aux] != -1) return dp[aux];

    if(test(aux-1)){
        ans = (ans + solve(aux-1)) % mod;
    }
    if(test(aux-2)){
        ans = (ans + solve(aux-2)) % mod;
    }

    return dp[aux] = ans; 
}

int main(int argc, char* argv[]){
    ios_base :: sync_with_stdio(false);
    cin.tie(NULL);
    //cout << fixed << setprecision(2);
    memset(dp, -1, sizeof(dp));
    cin >> n >> m;

    for(int i = 0; i < m; i++){
        cin >> vet[i];
    }

    ll aux = n;
    solve(aux);

    if(flag) cout << dp[n] << "\n";
    else cout << "0\n";

    return 0;
}