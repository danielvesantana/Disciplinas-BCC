#include<bits/stdc++.h>
using namespace std;
typedef long long ll;
const int N = 200100;
ll a[N], tree[4*N];
ll lazy[4*N];
const int valor_nulo = 0;
ll merg(ll x, ll y)
{
    return x+y;
}
void propaga(int p, int tl, int tr)
{
    if(tl == tr)
        return;
    // x diferente de 0
    if(lazy[p] == 0)
        return;
    int fl = 2*p, fr = 2*p+1;
    int tmid = (tl + tr)/2;
    tree[fl] = (tmid-tl+1)*lazy[p];
    tree[fr] = (tr-tmid)*lazy[p];
    lazy[fl] = lazy[fr] = lazy[p];
    lazy[p] = 0;
}
void build(int p, int tl, int tr)
{
    if(tl==tr)
    {
        tree[p] = a[tl];
    }else
    {
        int tmid = (tl+tr)/2;
        build(2*p,tl,tmid);
        build(2*p+1,tmid+1,tr);
        tree[p] = merg(tree[2*p],tree[2*p+1]);
    }
}

ll query(int p, int tl, int tr, int l, int r)
{
    if( l > r)
        return valor_nulo;
    if(tl == l && tr == r)
        return tree[p];
    propaga(p,tl,tr);
    int tmid = (tl+tr)/2;
    return query(2*p,tl,tmid,l,min(tmid,r))+
            query(2*p+1,tmid+1,tr,max(l,tmid+1),r);
}

void updt(int p, int tl, int tr, int l, int r, ll x)
{
    if(l > r)
        return;
    if(tl == l && tr == r){
        tree[p] = (tr-tl+1)*x;
        lazy[p] = x;
        return;
    }
    propaga(p,tl,tr);
    int tmid = (tl+tr)/2;
    updt(2*p,tl,tmid,l,min(tmid,r),x);
    updt(2*p+1,tmid+1,tr,max(l,tmid+1),r,x);
    tree[p] = merg(tree[2*p],tree[2*p+1]);
}

int main()
{
    int n;
    cin >> n;
    for(int i = 1; i <= n; i++)
        cin >> a[i];
    build(1, 1, n);

    int q;
    cin >> q;
    // tipo 1 retorna soma de l a r
    // tipo 2 atualiza a[i] = x para i de l a r
    while(q--)
    {
        int tipo;
        cin >> tipo;
        if(tipo == 1)
        {
            int l, r;
            cin >> l >> r;
            cout << query(1, 1, n, l, r) << '\n';
        }else
        {
            int l, r, x;
            cin >> l >> r >> x;
            updt(1, 1, n, l, r, x);
        }
    }

    return 0;
}