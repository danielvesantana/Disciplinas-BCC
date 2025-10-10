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
const int N = 1e6+10;

#pragma endregion

ll vet[N];
ll aux[N];

int main(int argc, char* argv[]){
    ios_base :: sync_with_stdio(false);
    cin.tie(NULL);
    //cout << fixed << setprecision(2);
    ll n, m;

    cin >> n >> m;

    for(int i = 0; i < n; i++) cin >> vet[i];

    int l, r;
    ll sum = 0, maior = -1;
    l = r = 0;
    while(l <= r && r <= n){
        if(sum <= m && sum > maior) maior = sum;
        if(sum > m){
            sum -= vet[l];
            l++;
        }else if(sum <= m){
            sum += vet[r];
            r++;
        }
    }

    cout << maior << "\n";

    return 0;
}