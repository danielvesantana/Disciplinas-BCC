#include <bits/stdc++.h>
using namespace std;
typedef long long ll;

map<ll,ll> c;
        
int main(){
    ios_base :: sync_with_stdio(false);
    cin.tie(NULL);
    ll n, s, r = 0, j = 0;

    cin >> n >> s;

    ll v[n];    
    ll P[n+1] = {0}, i;

    for(i = 1; i <= n; i++){
        cin >> v[i];
        P[i] = P[i-1] + v[i];
        c[P[i-1] + s]++;
        r += c[P[i]];
    }
    cout << r << "\n";
    
    return 0;
}
