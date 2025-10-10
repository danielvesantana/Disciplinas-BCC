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

ll n, k;

ll test(ll i){
    ll count, aux;
    count = 0;
    aux = i;
    
    while(aux < k){
        aux = i * 2;
        i = aux;
        count++;
    }

    return count;
}

int main(int argc, char* argv[]){
    ios_base :: sync_with_stdio(false);
    cin.tie(NULL);
    cout << fixed << setprecision(12);
    cin >> n >> k;

    double ans = 0;
    for(int i = 1; i <= n; i++){
        ll count = test(i);

        ans += pow(0.5, count);
    }

    cout << (1.0/n)*ans << "\n";

    return 0;
}