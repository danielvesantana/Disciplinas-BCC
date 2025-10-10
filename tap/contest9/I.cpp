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
const int N = 2000010;
int vet[N];
int n, m;
vector < int > adj[N];
int dist[N];
bool vis[N];

vector < int > z(N);
string str, substr;

#pragma endregion

void z_function(){
    m = str.size();

    int l, r;
    l = r = 0;

    for(int i = 1; i < m; i++){
        if(i < r){
            z[i] = min(r - i, z[i-l]);
        }
        while(i + z[i] < m && str[z[i]] == str[i + z[i]]){
            z[i]++;
        }
        if(i + z[i] > r){
            l = i;
            r = i + z[i];
        }
    }
}

int main(int argc, char* argv[]){
    ios_base :: sync_with_stdio(false);
    cin.tie(NULL);
    //cout << fixed << setprecision(2);
    cin >> n;

    for(int i = 0; i < n; i++){
        int init;

        cin >> str;
        substr = str;

        reverse(substr.begin(), substr.end());

        init = str.length();
        str = str + substr;

        z_function();

        int len, index;
        len = 0; 
        for(int j = init; j < m; j++){
            len = max(len, z[j]);
        }
        for(int j = init; j < m; j++){
            if(z[j] == len)
                index = j;
        }

        for(int j = (index + len) - 1; j >= index; j--)
            cout << str[j];

        cout << "\n";

        str.clear();
    }

    return 0;
}