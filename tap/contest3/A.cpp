#include <bits/stdc++.h>
using namespace std;

typedef long long ll;
const ll MAXN = 2e5+100;
const ll INF = 1e19;
ll v[MAXN];

bool machine(ll t, ll k, ll n){
    ll i, sum = 0;
    for(i = 0; i < n; i++){
        sum += (k / v[i]);
        if(sum >= t) return true;
    }
    return false;
}

ll tempo(ll l, ll r, ll t, ll n){
    ll k, m;
    while(l <= r){
        k = l + (r - l) / 2;
        if(machine(t, k, n) == 1){
            r = k - 1;
            m = k;
        }else{
            l = k + 1;
        }
    }

    return m;
}

int main(){
    ios_base :: sync_with_stdio(false);
    cin.tie(nullptr);
    ll n, t, i, l = 0, r = 1e19;
    cin >> n >> t;

    for(i = 0; i < n; i++) cin >> v[i];
    
    cout << tempo(l, r, t, n) << "\n";    

    return 0;
}