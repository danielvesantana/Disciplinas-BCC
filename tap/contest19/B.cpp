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

#pragma endregion

const int N = 100;
int vet[N];
ll n, m;

int main(int argc, char* argv[]){
    ios_base :: sync_with_stdio(false);
    cin.tie(NULL);
    //cout << fixed << setprecision(2);
    cin >> n;

    for(int i = 0; i < n; i++){
        cin >> m;

        for(int j = 0; j < m; j++){
            vet[j] = j+1;
        }

        int aux;
        for(int j = 0; j < m-1; j++){
            aux = vet[j+1];
            vet[j+1] = vet[j];
            vet[j] = aux;
        }

        for(int j = 0; j < m; j++){
            cout << vet[j] << " ";
        }
        cout << "\n";
    }

    return 0;
}