#include <bits/stdc++.h>

using namespace std;

void swap(int* x, int* y){
    int temp = *x;
    *x = *y;
    *y = temp;
}

int partition(int a[], int left, int right){
    int i = left;
    int j = right + 1;
    int pivot = a[left];
    while (i <= j){
        while (i <= right && a[i] < pivot)
            ++i;
        --j;
        while (j >= left && a[j] > pivot)
            --j;
        swap(&a[i], &a[j]);
    }
        return j;
}

void printArray(int a[], int n){
    for (int i = 0; i < n; ++i){
        
    }
}

int main(){
    int arr[] = {2,3,1,2,5};


    cout << endl;
    system("pause");
    return 0;
}