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

int n, m;

int main(int argc, char* argv[]){
    ios_base :: sync_with_stdio(false);
    cin.tie(NULL);
    //cout << fixed << setprecision(2);
    cin >> n >> m;

    ll aux1 = max(n, m);
    ll aux2 = 7 - aux1;
    aux1 = 6;

    if(aux2 % 2 == 0 && aux1 % 2 == 0){
        aux2 /= 2;
        aux1 /= 2;
    }
    if(aux2 % 3 == 0 && aux1 % 3 == 0){
        aux2 /= 3;
        aux1 /= 3;
    }

    cout << aux2 << "/" << aux1 << "\n";

    return 0;
}