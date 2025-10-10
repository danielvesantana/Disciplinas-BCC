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
const int N = 200010;
ll n, m;

#pragma endregion

ll ub;
bitset <10000010 > prime; 
vector <ll > primelist ;

void sieve( ll n ) {
    prime.set (); 
    prime [0] = prime [1] = 0; 

    for (ll i = 4; i <= n; i += 2) 
    prime[i] = 0;

    for (ll i = 3; (i * i) <= n; i += 2) { 
        if (prime[i]) { 
            for (ll j = i * i; j < n; j += i)
                prime[j] = 0; 
        }
    }

    for (ll i = 2; i <= n; i++) { 
        if (prime[i]) {
            primelist . push_back ( i );
        }
    }
}

int nbDiv( ll n ){
    int i = 0, p = primelist [i], ans = 1;

    while (p * p <= n) {
        int e = 0;
        while (n % p == 0) {
            n /= p;
            e++;
        }

        ans *= (e + 1);
        p = primelist [++i];
    }
    if (n != 1) ans *= 2;

    return ans;
}

int main(int argc, char* argv[]){
    ios_base :: sync_with_stdio(false);
    cin.tie(NULL);
    //cout << fixed << setprecision(2);
    sieve(200);
    cin >> m;

    int ans = 0;
    for(int i = 1; i <= m; i += 2){
        if(nbDiv(i) == 8)
            ans++;
    }

    cout << ans << "\n";

    return 0;
}