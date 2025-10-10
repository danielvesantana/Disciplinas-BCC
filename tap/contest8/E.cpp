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
    vector < pair < ll, ll > > v;
    int dist[N];
    bool vis[N];

    #pragma endregion

    int main(int argc, char* argv[]){
        ios_base :: sync_with_stdio(false);
        cin.tie(NULL);
        //cout << fixed << setprecision(2);
        ll t;

        cin >> n >> m >> t;

        for(int i = 0; i < n-1; i++)
            cin >> vet[i];

        for(int i = 0; i < m; i++){
            ll a, b;

            cin >> a >> b;

            v.push_back(make_pair(a , b));
        }

        bool flag = true;
        int k = 1, j = 0;
        for(int i = 0; i < n - 1; i++){
            t -= vet[i];
            k++;

            if(t <= 0){
                flag = false;
                break;
            }

            if(j < m){
                if(k == v[j].first){
                    t += v[j].second;
                    j++;
                }
            }
        }

        if(flag) cout << "Yes\n";
        else cout << "No\n";

        return 0;
    }