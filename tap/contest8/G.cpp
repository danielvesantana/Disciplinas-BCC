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
const int N = 360;
int vet[N];
int n, m;
vector < int > adj[N];
int dist[N];
bool vis[N];

#pragma endregion

int main(int argc, char* argv[]){
    ios_base :: sync_with_stdio(false);
    cin.tie(NULL);
    //cout << fixed << setprecision(2);
    cin >> n;

    vet[0] = 1;
    int grau = 0;
    for(int i = 0; i < n; i++){
        int a;

        cin >> a;

        grau += a;
        grau %= 360;

        vet[grau] = 1;
    }

    int count = 0, ans = 0;
    for(int i = 0; i <= 360*2; i++){
        count++;
        if(vet[i%360]){
            ans = max(ans, count);

            count = 0;
        }
    }

    cout << ans << "\n";

    return 0;
}