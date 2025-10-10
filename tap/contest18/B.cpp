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

#pragma endregion

int main(int argc, char* argv[]){
    ios_base :: sync_with_stdio(false);
    cin.tie(NULL);
    //cout << fixed << setprecision(2);
    double v1, v2;

    cin >> v1 >> v2;

    ll ans, andar, aux, count;
    ans = 0;
    andar = count = 1;
    aux = 2;
    while(v2 - (count * v1) >= 0){
        andar += aux;
        count += andar;
        aux += 1;
        ans++;
    }

    cout << ans << "\n";

    return 0;
}