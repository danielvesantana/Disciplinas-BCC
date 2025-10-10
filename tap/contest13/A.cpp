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
int vet[N];
int n, m;

#pragma endregion

int main(int argc, char* argv[]){
    ios_base :: sync_with_stdio(false);
    cin.tie(NULL);
    //cout << fixed << setprecision(2);
    cin >> n;

    vector < string > str(n + 1);

    str[1] = to_string(1);
    for(int i = 2; i <= n; i++){
        str[i] = str[i-1] + " " + to_string(i) + " " + str[i-1];
    }

    cout << str[n] << "\n";

    return 0;
}