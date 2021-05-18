#include <bits/stdc++.h>

using namespace std;

struct Node{
    int data;
    Node* next;
    Node* previous;
};

Node* createNode(int data){
    Node* node = new Node;
    node->data = data;
    node->next = NULL;
    node->previous = NULL;
    return node;
}

void traverseNode(Node* head){
    if (head == NULL){
        cout << "Nothing";
        return;
    }
    else{
        Node* temp = head;
        while (temp != NULL){
            cout << temp->data << ' ';
            temp = temp->next;
        }
    }
}

void deleteNode(Node* head){
    Node* temp = head;
    while(head!=NULL){
        temp = head;
        head = head ->next;
        delete temp;
    }
}

void insertNode(Node* head, Node* tail, int pos, int value){
    Node* newNode = createNode(value);
    int length = 0;
    for (Node* temp = head; temp!=NULL; temp = temp->next){
        ++length;
    }
    if (pos < 1){
        head -> previous = newNode;
        newNode -> next = head;
        head = newNode;
    } 
    else if (pos >= length){
        tail -> next = newNode;
        newNode -> previous = tail;
        tail = newNode;
    }
}

int main(){
    Node* head = createNode(2);
    Node* tail = head;
    for (int i = 0; i < 5; ++i){
        Node* newNode = createNode(i);
        tail -> next = newNode;
        newNode -> previous = tail;
        tail = newNode;
    }
    traverseNode(head);
    cout << endl;

    deleteNode(head);
    cout << endl;
    system("pause");
    return 0;
}