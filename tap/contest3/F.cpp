#include <bits/stdc++.h>
using namespace std;

typedef long long ll;

void busca(ll k, vector < pair <ll, ll> > v2, ll *v, ll n, int *aux){
    ll l = 0, r = n;
    while(l <= r){
        if((v2[l].first + v2[r].first) > k){
            r--;
        }else if((v2[l].first + v2[r].first) < k){
            l++;
        }else{
            *aux = 1;
            v[1] = v2[l].second;
            v[2] = v2[r].second;
            break;
        }
    }
}

int main(){
    ios_base :: sync_with_stdio(false);
    cin.tie(NULL);
    ll n, x, i, l, r;
    int aux = 0, aux1 = 0;
    cin >> n >> x;

    vector < pair <ll, ll> > v1(n);

    for(i = 0; i < n; i++){
        cin >> v1[i].first;
        v1[i].second = i+1;
    }
    sort(v1.begin(), v1.end());
    
    for(i = 0; i < n; i++){
        vector < pair <ll, ll> > v2;
        for(int j = 0; j < n; j++){
            if(j != i) v2.push_back(v1[j]);
        }
        ll v[3] = {0};
        v[0] = v1[i].second;
        busca(x-v1[i].first, v2, v, n-2, &aux);
     
        sort(v, v+3);
        if(aux == 1){
            cout << v[0] << " " << v[1] << " " << v[2] << "\n"; 
            aux1 = 1;
        }
        aux = 0; 
    }
    if(aux1 == 0) cout << "IMPOSSIBLE";

    return 0;
}