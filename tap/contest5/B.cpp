#include <bits/stdc++.h>
using namespace std;

typedef long long ll;
const int MAXN = 1000;
int mapa[MAXN][MAXN];

void test(){
    int n, m, s, x, y, r;

    cin >> n >> m;
    cin >> s;

    for(int i = 0; i < s; i++){
        cin >> x >> y >> r;

        for(int l = min(1, x-r); l <= max(x+r, n); l++){
            mapa[x][max(1, y-r)]++;
            mapa[x][min(y+r+1, m)]--;
        }
    }

    for(int l = 1; l <= n; l++){
        for(int c = 1; c <= m; c++){
            mapa[l][c] += mapa[l][c-1];
        }
    }

    ll tot = 0;
    for(int l = 1; l <= n; l++){
        for(int c = 1; c <= m; c++){
            tot += mapa[l][c];
        }
    }

    cout << tot / (n*m) << "\n";
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
