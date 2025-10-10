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
int dist[N];
vector <int> adj[N];
bool vis[N];
int n, m;
int father[N];

#pragma endregion

void bfs(int source, int target){
    queue <int> bfs_q;
    bfs_q.push(source);
    vis[source] = true;

    while(!bfs_q.empty()){
        source = bfs_q.front();
        bfs_q.pop();

        if(source == target) return;

        for(auto v: adj[source]){
            if(!vis[v]){
                vis[v] = true;
                bfs_q.push(v);
                father[v] = source;
            }
        }
    }
}

int main(int argc, char* argv[]){
    ios_base :: sync_with_stdio(false);
    cin.tie(NULL);
    //cout << fixed << setprecision(2);
    int x, y;
    cin >> n >> x >> y;

    int a, b;
    for(int i = 0; i < n-1; i++){
        cin >> a >> b;

        adj[a].push_back(b);
        adj[b].push_back(a);
    }

    bfs(x, y);

    int path = y;
    vector <int> ans;
    ans.push_back(y);

    while(path != x){
        ans.push_back(father[path]);

        path = father[path];
    }

    reverse(ans.begin(), ans.end());
    for(int i = 0; i < ans.size(); i++){
        cout << ans[i] << " ";
    }
    cout << "\n";

    return 0;
}