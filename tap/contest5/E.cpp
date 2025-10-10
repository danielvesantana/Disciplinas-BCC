#include <bits/stdc++.h>
using namespace std;

const int MAX = 1010;
typedef long long ll;

ll p[MAX][MAX];

void test(){
    ll n, q;

    cin >> n >> q;

    for(int i = 1; i <= n; i++){
        for(int j = 1; j <= n; j++){
            char c;

            cin >> c;

            if(c == '*')
                p[i][j] = p[i][j] + p[i][j-1] + 1;
            else    
                p[i][j] = p[i][j] + p[i][j-1];
        }
    }
    for(int i = 0; i < q; i++){
        ll x1, x2, y1, y2, sum = 0;

        cin >> y1 >> x1 >> y2 >> x2;

        for(int j = y1; j <= y2; j++){
            sum += p[j][x2] - p[j][x1 - 1];
        }

        cout << sum << "\n";
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