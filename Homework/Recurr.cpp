#include<iostream>

using namespace std;

int a[1000];
int b[1000];
int n;

void Try(int k){
    for (int i = 1; i <= n; ++i){
        if (b[i] == 0){
            b[i] = 1;
            a[k] = i;
            if (k == n){
                for (int i = 1; i<=n; i++){
                    cout << a[i];
                }
                cout << ' ';
            }
            else
                Try(k + 1);
            b[i] =0;
        }
    }
}

int main(){
    cin >> n;
    for (int i =1; i<=n; i++){
        b[i] = 0;
    }
    Try(1);
    system("pause");
	return 0;
}