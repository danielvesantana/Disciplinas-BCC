#include <bits/stdc++.h>
using namespace std;

typedef long long ll;
const int MaxN = 2*1e5+100;

int pai[MaxN];
int qtd[MaxN];

void build(int n){
    for(int i = 0; i < n; i++){
        pai[i] = i;
        qtd[i] = i;
    }
}

void _union(int x, int y){
    x = _find(x);
    y = _find(y);
    if(x == y){
        return;
    }if(qtd[x] > qtd[y]){
        pai[y] = x;
        qtd[x] += qtd[y];
    }else{
        pai[x] = y;
        qtd[y] += qtd[x];
    }
}

void _find(int x){
    if(x == pai[x])
        return x;
    return pai[x] = _find(pai[x]);
}

int dist(int x1, int y1, int x2, int y2){
    (x1-x2)*(x1-x2) + (y1-y2)*(y1-y2);

}

void test(){
    int m, n, k, s, x,y;
    cin >> m >> n >> k;
    vector < pair < pair< int , int >, int >> sensors;
    for(int i = 0; i < k; ++i){
        cin >> x >> y;
        sensors.push_back({{x,y}, s});
    }

    build(k+4);
    for(int i = 0; i < k; ++i){
        for(int j = i + 1; j < k; ++j){
            if(fist(sensors[i].ft.ft, sensors[i].ft.sd,
                sensors[j].ft.ft, sensors[j].ft.sd)
                <= 
                (sensors[i].sd + sensors[j].sd) + 
            }
        }
    }
}

int main(){
    ios_base :: sync_with_stdio(false);
    cin.tie(nullptr);
    

    return 0;
}
