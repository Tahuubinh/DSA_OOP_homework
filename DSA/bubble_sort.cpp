#include <bits/stdc++.h>
using namespace std;
 
void swap(int *x, int *y) 
{ 
    int temp = *x; 
    *x = *y; 
    *y = temp; 
} 
 
void bubbleSort(int arr[], int n)
{
    int i, j;
    for (i = 0; i < n-1; i++) {
        int count = 1;
        for (j = 0; j < n-i-1; j++)
            if (arr[j] > arr[j+1]){
                count = 0;
                swap(&arr[j], &arr[j+1]);
            }
        if (count)
            break;
    }
}
 
void printArray(int arr[], int size)
{
    int i;
    for (i = 0; i < size; i++)
        cout << arr[i] << " ";
    cout << endl;
}
 
int main()
{
    int arr[] = {2,3,1,2,5};
    int n = sizeof(arr)/sizeof(arr[0]);
    bubbleSort(arr, n);
    cout<<"Sorted array: \n";
    printArray(arr, n);

    system("pause");
    return 0;
}