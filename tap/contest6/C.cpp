#include <bits/stdc++.h>
using namespace std;

typedef long long ll;

bool tf(ll m, ll k, ll n){
    ll sum = 0;
    ll aux = m;

    while(aux > 0){
        sum += aux;
        aux = aux / k;
    }

    if(sum >= n) return true;
    else return false;
}

ll bb(ll n, ll k){
    ll l = 1;
    ll r = n;
    ll result = 0;

    while(l <= r){
        ll m = (l+r)/2;

        if(tf(m, k, n)){
            r = m - 1;
            result = m;
        }else{
            l = m + 1;
        }
    }

    return result;
}

int main(){
    ios_base :: sync_with_stdio(false);
    cin.tie(nullptr);

    ll n, k;

    cin >> n >> k;

    cout << bb(n, k) << "\n";

    return 0;
}