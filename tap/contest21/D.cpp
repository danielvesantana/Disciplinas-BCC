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

#define lef(u) 2*u
#define rig(u) 2*u+1

const int N = 200010;
int n, q;
int v[N];
ll tree[4*N];

void update(int u, int pos, int val, int tl, int tr){
    int tmid = (tl + tr) / 2;

    if(tl > pos || tr < pos){
        return;
    }
    if(tr == tl){
        tree[u] = val;
        return;
    }

    update(lef(u), pos, val, tl, tmid);
    update(rig(u), pos, val, tmid + 1, tr);
    tree[u] = max(tree[lef(u)], tree[rig(u)]);
}

ll query(int u, int l, int r, int tl, int tr){
    int tmid = (l + r) / 2;

    if(l > tr || tl > r){
        return INT_MAX;
    }
    if(tl <= l && tr >= r){
        return tree[u];
    }

    ll ans = INT_MAX;
    ans = min(ans, query(lef(u), l, tmid, tl, tr));
    ans = min(ans, query(rig(u), tmid + 1, r, tl , tr));

    return ans;
}

void build(int u, int tl, int tr){
    int tmid = (tl + tr) / 2;

    if(tl == tr){
        tree[u] = v[tl];
        return;
    }

    build(lef(u), tl, tmid);
    build(rig(u), tmid + 1, tr);
    tree[u] = max(tree[lef(u)], tree[rig(u)]);
}

int main(int argc, char* argv[]){
    ios_base :: sync_with_stdio(false);
    cin.tie(NULL);
    //cout << fixed << setprecision(2);
    cin >> n >> q;

    for(int i = 1; i <= n; i++)
        cin >> v[i];

    sort(v, v + n);
    build(1, 1, n);

    while(q--){
        
    }

    return 0;
}