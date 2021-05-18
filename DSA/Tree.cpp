#include <bits/stdc++.h>

using namespace std;

struct Node{
    int data;
    Node *left;
    Node *right;
};

Node* insertNode(Node* t, int x){
    // No node
    if (t == NULL){
        t = new Node;
        t -> data = x;
        t -> left = NULL;
        t->right = NULL;
        return t;
    }
    if (t->data > x){
        t ->left = insertNode (t->left, x);
    }
    else{
        t ->right = insertNode (t -> right, x);
    }
}

void printTree(Node* t){
    if (t!=NULL){ 
    printTree(t->left);
    cout << t->data << ' ';
    printTree(t->right);
    }
}

bool isLeafNode(Node *l){
    if (l==NULL)
        return false;
	return (l->left == NULL && l->right == NULL);
}

int countLeafNode(Node *t){
    if (t==NULL)
        return 0;
    if (t->left == NULL && t->right ==NULL){
        return 1;
    }
    return countLeafNode(t->left) + countLeafNode(t->right);
}

int treeLevel(Node *t){
    if (t==NULL)
        return -1;
    if (isLeafNode(t))
        return 0;
    return 1 + max( treeLevel(t->left), treeLevel(t->right) );
}

int main(){
    int n, x;
	cin >> n;
	Node * t = NULL;
	for (int i = 0; i < n; i++){
		cin >> x;
		t = insertNode(t, x);
	}
	printTree(t);
    cout << endl;
    cout << countLeafNode(t) << endl;
    cout << treeLevel(t) << endl;



    cout << endl;
    system("pause");
    return 0;
}