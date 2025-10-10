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
const int N = 100;
int m[N][N];
int n, len;

#pragma endregion

void aux(){
    for(int i = 0; i < len; i++){
        for(int j = 0;j <= i; j++){
            cin >> m[i][j];
        }
    }
}

void solve(){
    for(int i = len-2; i >= 0; i--){
        for(int j = 0; j <= i; j++){
            if((m[i][j] + m[i+1][j]) > (m[i][j] + m[i+1][j+1]))
                m[i][j] = m[i][j] + m[i+1][j];
            else
                m[i][j] = m[i][j] + m[i+1][j+1];
        }
    }
}

int main(int argc, char* argv[]){
    ios_base :: sync_with_stdio(false);
    cin.tie(NULL);
    //cout << fixed << setprecision(2); 
    cin >> n;

    for(int i = 0; i < n; i++){
        cin >> len;

        aux();

        solve();

        cout << m[0][0] << "\n";
    }

    return 0;
}