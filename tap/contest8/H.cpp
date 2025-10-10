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
const int N = 100010;
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
    string str;
    cin >> n >> str;

    vector < pair < ll, char > > v;

    int ans = 0;
    for(int i = 0; i < n; i++){
        ll a;

        cin >> a;

        v.push_back(make_pair(a, str[i]));
        if(str[i] == '1') ans++;
    }
    
    sort(v.begin(), v.end());

    int aux;
    aux = ans;

    for(int i = 0; i < n; i++){
        if(v[i].second == '1') aux--;
        else aux++;

        if(i < (n - 1)){
            if(v[i].first != v[i + 1].first)
                ans = max(ans, aux);  
        }
        else 
            ans = max(ans, aux);
    }

    cout << ans << "\n";

    return 0;
}