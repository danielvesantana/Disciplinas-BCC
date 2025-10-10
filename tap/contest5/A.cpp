#include <bits/stdc++.h>
using namespace std;

typedef long long ll;

vector < ll > p;

void test(){
    ll t, n, aux, sum = 0, a, b;
    vector<ll> v, p;

    cin >> t >> n;

    p.resize(t+1);
    p[0] = 0;

    for(int i = 1; i <= t; i++){
        cin >> p[i];
        p[i] += p[i-1];
    }

    for(int i = 0; i < n; i++){
        cin >> a >> b;
        aux = p[b] - p[a-1];
        cout << aux << "\n";
    }
}

int main(){
    ios_base :: sync_with_stdio(false);
    cin.tie(nullptr);
    int t = 1;

    while(t--){
        test();
    }

    return 0;
}
