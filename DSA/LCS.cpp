#include <bits/stdc++.h>

using namespace std;

int mem[1000];
bool check[1000];
int endofmax = 0;
int maxres = 0;
int beginofmax = 0;

int maxSum(int i, int a[]){
    if (i == 0){
        mem[0] = a[0];
        check[0] = 1;
        return a[0];
    }
    if (check[i]) {
        return mem[i];
    }
    int result = max(a[i], maxSum(i - 1, a) + a[i]);
    check[i] = 1;
    mem[i] = result;
    if (mem[i] > maxres){
        maxres = mem[i];
        endofmax = i;
        if (mem[i] == a[i]){
            beginofmax = i;
        }
    }
    return result;

}

int main(){
    int a[] = {-2,11, -4, 13, -5, 2};
    int n = sizeof(a)/sizeof(int);
    maxres = 0;
    cout << n << endl;
    maxres = a[0];
    cout << "Hello" <<endl;
    for (int i:a)
        cout << i << " ";
    cout << endl;
    cout << maxSum(5, a) << endl;
    //cout << mem[0] << endl;
    cout << "begin: " << beginofmax << endl;
    cout << "end: " << endofmax << endl;

    cout << maxres;


    cout << endl;
    system("pause");
    return 0;
}