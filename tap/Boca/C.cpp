#include <bits/stdc++.h>
using namespace std;

typedef long long ll;

const int N = (2e5+1);
vector<ll> vet(N);
map<ll , ll> tetriminos;

void prefix_sum(int n){
    int i = 1;

    do{
        vet[i] += vet[i-1];
        i++;
    }while(vet[i] <= n);
}

void solve(int n){
    ll aux = -1;
    for(int i = 0; i < n; i++){
        int x;
        cin >> x;

        vet.push_back(x);

        aux = max(aux, vet[i]);
        tetriminos[vet[i]]++;
    }

    prefix_sum(aux);

    for(int i = vet.size()-1; i >= 0; i--){
        if(tetriminos[vet[i-1]] > 0){
            tetriminos[vet[i-1]]--;
            tetriminos[vet[i]]--;
        }
    }

    for(int i = 0; i < vet.size(); i++){
        if(tetriminos[vet[i-1]] > 0){
            cout << "Aninha eh perdedora\n";

            return;
        }
    }

    cout << "Aninha eh vencedora\n";
}

int main(){
    ios_base :: sync_with_stdio(0);
    cin.tie(nullptr);
    int t = 1;
    int n;
    cin >> n;

    while(t--){
        solve(n);
    }
    
    return 0;
}