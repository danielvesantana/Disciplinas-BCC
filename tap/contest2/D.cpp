#include <bits/stdc++.h>
using namespace std;

typedef long long ll;

int main(){
    ios_base :: sync_with_stdio(false);
    cin.tie(NULL);
    ll n, x, l, m, i;
    int aux = 0;
    cin >> n >> x;
    vector < pair <ll, ll> > v(n);
    for(i = 0; i < n; i++){
        cin >> v[i].first;
        v[i].second = i+1;
    }
    sort(v.begin(), v.end());
    l = 0; 
    m = n-1;
    while(l < m){
        if( (v[l].first + v[m].first) > x) m--;
        else if( (v[l].first + v[m].first) < x) l++;
        else{
            aux = 1;
            if(v[m].second < v[l].second) cout << v[m].second << " " << v[l].second << "\n";
            else cout << v[l].second << " " << v[m].second << "\n";
            m--;
            l++;
        }
    }
    if(aux == 0) cout << "IMPOSSIBLE";

    return 0;
}
