#include <bits/stdc++.h>
using namespace std;

typedef long long ll;

int busca(multiset <int> &tic, ll n, ll x){
    ll l = 0, r = n - 1, m, aux;

        
}

int main(){
    ios_base :: sync_with_stdio(false);
    cin.tie(nullptr);
    ll n, m, i, k;
    cin >> n >> m;
    multiset < int > tic;
    ll pr[m];
    for(i = 0; i < n; i++){
        cin >> k;
        tic.insert(k);
    }
    for(i = 0; i < m; i++){
        cin >> pr[i];
    }
    sort(tic.begin(), tic.end());

    for(i = 0; i < m; i++){
        k = busca(tic, n, pr[i]);
        
    }

    return 0;
}
