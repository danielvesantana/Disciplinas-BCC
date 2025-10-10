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

const int N = 200010;
int n, q;
int vet[N];
int tree[4*N];
int lazy[4*N];

void propagation(int u, int tl, int tr){
    int tmid = (tl + tr) /2;

    if(tl == tr){
        return;
    }

    if(lazy[u] == 0){
        return;
    }

    int fl = 2*u, fr = 2*u+1;
    tree[fl] = (tmid-tl+1)*lazy[u];
    tree[fr] = (tr-tmid)*lazy[u];
    lazy[fl] = lazy[fr] = lazy[u];
    lazy[u] = 0;
}

void update(int u, int tl, int tr, int l, int r, int x){
    int tmid = (tl + tr) / 2;

    if(l > r){
        return;
    }

    if(tl == l && tr == r){
        tree[u] = (tr - tl + 1) * x;
        lazy[u] = x;
        return;
    }

    propagation(u, tl, tr);
    update(2*u, tl, tmid, l, min(tmid, r), x);
    update(2*u + 1, tmid + 1, tr, max(l, tmid + 1), r, x);

    tree[u] = tree[2*u] + tree[2*u+1];
}

void build(int u, int tl, int tr){
    int tmid = (tl + tr) / 2;

    if(tl == tr){
        tree[u] = vet[tl];
        return;
    }

    build(2*u, tl, tmid);
    build(2u+1, tmid + 1, tr);

    tree[u] = tree[2*u] + tree[2*u+1];
}

int main(int argc, char* argv[]){
    ios_base :: sync_with_stdio(false);
    cin.tie(NULL);
    //cout << fixed << setprecision(2);
    cin >> n >> q;

    for(int i = 1; i <= n; i++){
        cin >> vet[i];
    }

    build(1, 1, n);
    
    while(q--){
        int op;

        cin >> op;

        if(op == 1){
            int a, b, u;

            cin >> a >> b >> u;

            update(1, 1, n, a, b, u);
        }else if(op == 2){
            int k;

            cin >> k;

            cout << tree[k-1] << "\n";
        }
    }

    return 0;
}