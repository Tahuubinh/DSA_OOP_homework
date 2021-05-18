#include <bits/stdc++.h>

using namespace std;
int a[10001];
int b[10001];
int n;
int length;

void print(int n){
    for (int i = 0; i < n; i++){
        cout << a[i] << ' ';
    }
    cout << endl;
}

void BackTracking(int m){
    if (m == length){
        print(length);
    } else{
        for (int i = 1; i <= n; i++){
            if (b[i] == 0){
                b[i] = 1;
                a[m] = i;
                BackTracking(m + 1);
                b[i] = 0;
            }
        }
    }
}

int main(){
    cout << "Nhap n: ";
    cin >> n;
    cout << "Length: ";
    cin >> length;
    for (int i = 1; i <= n; i++){
        b[i] = 0;
    }
    BackTracking(0);


    cout << endl;
    system("pause");
    return 0;
}