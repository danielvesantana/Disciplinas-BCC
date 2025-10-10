#include <bits/stdc++.h>
using namespace std;

const int MAX = 200010;
typedef long long ll;

ll p[MAX];

void test(){
    int n, q, a, b;

    cin >> n >> q;

    for(int i = 1; i <= n; i++){
        cin >> p[i];
        p[i] = p[i]^p[i-1];
    }

    ll aux;
    while(q--){
        cin >> a >> b;
        aux = (p[b] ^ p[a-1]);
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