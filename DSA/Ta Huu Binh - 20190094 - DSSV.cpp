#include <bits/stdc++.h>

using namespace std;

struct Node{
    string MSV;
    double diem;
    Node* next;
};

int main(){
    int n;
    cout << "So sinh vien n = ";
    cin >> n;
    Node* head;
    head = new Node;
    Node* temp = head;

    //Nhap thong tin
    for (int i = 0; i < n; i++){
        if (temp == NULL){
            cout << "Khong du bo nho cap phat!";
            exit(0);
        }
        cout << "Sinh vien thu " << (i + 1) << ":" << endl;
        cout << "Ma sinh vien: ";
        cin.ignore(numeric_limits<streamsize>::max(),'\n');
        
        getline(cin, temp -> MSV);
        cout << "Diem mon cau truc du lieu va giai thuat: ";
        cin >> (temp -> diem);
        temp -> next = new Node;
        temp = temp ->next;
    }
    temp = NULL;

    //In ra ket qua
    temp = head;
    for (int i = 0; i < n; i++){
        cout << "Sinh vien thu " << i+1 << " co ma so sinh vien " <<
            temp->MSV << " va diem la " << temp ->diem << endl;
        temp = temp->next;
    }

    //Xoa du lieu
    for (int i = 0; i < n; i++){
        temp = head;
        head = head->next;
        delete temp;
    }


    cout << endl;
    system("pause");
    return 0;
}