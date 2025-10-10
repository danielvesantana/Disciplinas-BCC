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
ll dp[N];
ll vet1[N], vet2[N];
vector < pair < ll, ll > > v;
ll n, m, ans = 0;

#pragma endregion

ll solve(ll begin, ll aux){
    if(begin == n)
        return 1;
    
    if(dp[begin] != -1)
        return dp[begin];

    if(abs(v[begin].first - aux) <= m){
        aux = v[begin].first;
        ans += solve(begin + 1, aux);
    }
    if(abs(v[begin].second - aux) <= m){
        aux = v[begin].second;
        ans += solve(begin + 1, aux);
    }

    return dp[begin] = ans;
}

int main(int argc, char* argv[]){
    ios_base :: sync_with_stdio(false);
    cin.tie(NULL);
    //cout << fixed << setprecision(2);
    memset(dp, -1, sizeof(dp));
    cin >> n >> m;

    for(int i = 0; i < n; i++){
        cin >> vet1[i];
    }

    for(int i = 0; i < n; i++){
        cin >> vet2[i];
    }

    for(int i = 0; i < n; i++){
        v.push_back(make_pair(vet1[i], vet2[i]));
    }

    solve(1, vet1[0]);
    solve(1, vet2[0]);

    if(ans > 0) cout << "Yes\n";
    else cout << "No\n";

    return 0;
}