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
    string s, t;

    cin >> s >> t;

    size_t ans = s.find(t);

    if(ans != string::npos){
        cout << "Yes\n";
    }else{
        cout << "No\n";
    }

    return 0;
}