#include<bits/stdc++.h>
using namespace std;

const int N = 1'000'10;

int dfs(int u, int mark[], vector<int>adj[])
{
    mark[u] = 1;
    int count = 0;
    for(int i = 0; i < adj[u].size(); i++)
    {
        int v = adj[u][i];
        if(mark[v] == 0){
            count += dfs(v, mark, adj) + 1;
        }
    }

    return count;
}

int main()
{
    int n, m, count, k;

    cin >> k;

    while(k--){
        int maior = -1;
        int mark[N] = {0};
        vector<int> adj[N];
        
        cin >> n >> m;
        while(m--)
        {
            int u, v;
            cin >> u >> v;
            adj[u].push_back(v);
            adj[v].push_back(u);
        }

        for(int i = 1; i <= n; i++)
        {
            int count = 0;
            if(mark[i] == 0){
                count = dfs(i, mark, adj);
                count++;
            }
            if(count > maior) 
                maior = count;
        }

        cout << maior << '\n';
    }
    
    return 0;
}
