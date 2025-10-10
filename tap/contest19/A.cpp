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

const int N = 100010;
ll vet[N];
ll n;

int main(int argc, char* argv[]){
    ios_base :: sync_with_stdio(false);
    cin.tie(NULL);
    //cout << fixed << setprecision(2);
    cin >> n;

    for(int i = 0; i < n; i++){
        cin >> vet[i];
    }

    int ans = 0, count = 0;
    for(int i = 0; i < n-1; i++){
        if(vet[i] >= vet[i+1]){
            count++;
            ans = max(ans, count);
        }else{
            count = 0;
        }
    }

    cout << ans << "\n";

    return 0;
}