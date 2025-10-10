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
const int N = 10000;
int vet[N];
int n, m;

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

bool isPrime ( ll n ){
    if (n <= ub) return prime[n];

    for (int i = 0; i < (int) primelist .size (); i++)
        if (n % primelist[i] == 0) return false;

    return true;
}

int main(int argc, char* argv[]){
    ios_base :: sync_with_stdio(false);
    cin.tie(NULL);
    //cout << fixed << setprecision(2);
    ub = 100010;
    sieve(ub);
    cin >> m;

    for(int i = 0; i < m; i++){
        ll a;

        cin >> a;
        if(isPrime(a)) cout << "yes\n";
        else cout << "no\n";
    }

    return 0;
}