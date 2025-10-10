#include <bits/stdc++.h>
using namespace std;

typedef long long ll;

ll stalls[100000];

bool cabe_ou_nao(ll c, ll k, ll n){
    ll i, j = 0;
    c--;
    for(i = 1; i < n; i++){
        if((stalls[i] - k) >= stalls[j]){
            j = i;
            c--;
        }
    }
    if(c <= 0) return true;
    else return false;
}

ll vaco(ll l, ll r, ll c, ll n){
    ll k, m;
    while(l <= r){
        k = l + (r - l) / 2;
        if(cabe_ou_nao(c, k, n) == 1){
            l = k + 1;
            m = k;
        }else{
            r = k - 1;
        }
    }

    return m;
}

int main(){
    ios_base :: sync_with_stdio(false);
    cin.tie(nullptr);
    ll test, n, c, i, l = 0, r = 1000000000;
    cin >> test;

    while(test--){
        cin >> n >> c;
        for(i = 0; i < n; i++){ 
            cin >> stalls[i];
        }
        sort(stalls, stalls + n);
        cout << vaco(l, r, c, n) << "\n";  
    }

    return 0;
}