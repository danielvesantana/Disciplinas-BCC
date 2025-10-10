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
vector < int > adj[N];
int dist[N];
bool vis[N];

#pragma endregion

int main(int argc, char* argv[]){
    ios_base :: sync_with_stdio(false);
    cin.tie(NULL);
    //cout << fixed << setprecision(2);
    string str;

    cin >> str; 

    int n = str.size();
    vector < int > z(n);

    int l, r;
    l = r = 0;

    for(int i = 1; i < n; i++){
        if(i < r){
            z[i] = min(r - i, z[i-l]);
        }
        while(i + z[i] < n && str[z[i]] == str[i + z[i]]){
            z[i]++;
        }
        if(i + z[i] > r){
            l = i;
            r = i + z[i];
        }

    }

    vector < int > ans;
    for(int i = 0; i < n; i++){
        if(i + z[i] == str.length()){
            ans.push_back(z[i]);
        }
    }
    sort(ans.begin(), ans.end());

    for(int i = 0; i < ans.size(); i++){
        cout << ans[i] << " ";
    }
    cout << "\n";

    return 0;
}