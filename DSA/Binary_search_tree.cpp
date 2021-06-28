#include <bits/stdc++.h>

using namespace std;

struct Node{
    int value;
    Node* left;
    Node* right;
    Node* parent;
};

void printInOrder(Node* root){
    if (root != NULL){
        printInOrder(root -> left);
        cout << root -> value << ' ';
        printInOrder(root -> right);
    }
}

Node* createNode(int value){
    Node* node = new Node;
    node -> value = value;
    node -> left = NULL;
    node -> right = NULL;
    node -> parent = NULL;
    return node;
}

Node* treeSearch(Node* root, int value){
    if (root == NULL){
        return NULL;
    }
    else if (value == root -> value){
        return root;
    }
    else if (value < root -> value){
        return treeSearch(root -> left, value);
    }
    else{
        return treeSearch(root -> right, value);
    }
}

Node* findMin(Node* root){
    if (root == NULL)
        return NULL;
    Node* temp = root;
    while (temp -> left != NULL){
        temp = temp -> left; 
    }
    return temp;
}

Node* findMax(Node* root){
    if (root == NULL)
        return NULL;
    Node* temp = root;
    while (temp -> right != NULL){
        temp = temp -> right; 
    }
    return temp;
}

Node* insertNode(Node* root, int value){
    if (root == NULL){
        root = createNode(value);
    }
    else if (value <= root->value){
        if (root->left == NULL){
            Node* key = createNode(value);
            key -> parent = root;
            root -> left = key;
        }
        else{
        insertNode(root -> left, value);
        }
    }
    else {
        if (root->right == NULL){
            Node* key = createNode(value);
            key -> parent = root;
            root -> right = key;
        }
        else{
        insertNode(root -> right, value);
        }
    }
    return root;
}

Node* deleteNode(Node* root, int value){
    if (root == NULL){
        return NULL;
    }
    if (value < root->value){
        root->left = deleteNode(root->left, value);
    }
    else if (value > root->value){
        root->right = deleteNode(root->right, value);
    }
    else {
        // Should use temp to delete root;
        if (root->left == NULL && root->right == NULL){
            return NULL;
        }
        else if (root->left == NULL){
            root->right->parent = root->parent;
            Node* temp = root->right;
            delete root;
            return temp;
        }
        else if (root->right == NULL){
            root->left->parent = root->parent;
            Node* temp = root->left;
            delete root;
            return temp;
        }
        else {
            // Node* ceiling = root -> right;
            // while (ceiling->left != NULL){
            //     ceiling = ceiling->left;
            // }
            // ceiling->left = root -> left;
            // if (ceiling->right != NULL)
            //         ceiling -> right -> parent = ceiling-> parent;            
            // if (ceiling->parent != root){
            //     ceiling -> parent -> left = ceiling->right;
            //     root -> right -> parent = ceiling;
            //     ceiling -> right = root -> right;
            // }                
            
            // root -> left -> parent = ceiling;
            // ceiling -> parent = root -> parent;
            // delete root;
            
            // return ceiling; 
            Node* key = findMin(root->right);
            root -> value = key -> value;
            root -> right = deleteNode(root->right, key -> value);
        }
    }


    return root;
}

void printPredecessor(Node* root, int value){
    Node* search = treeSearch(root, value);
    if (search == NULL){
        cout << "There's no node with value " << value << "!\n";
    }
    else{
        if (search -> value == findMin(root) -> value){
            cout << "There's no predecessor!" << endl;
        }
        else if (search -> left != NULL){
            cout << "Predecessor of " << value << " is " << findMax(search -> left) -> value;
        } // search now is not root, in other words, it has parent. Also, search is in the right side of the tree
        else {
            
            while (search -> parent -> left == search){
                search = search -> parent;
            }
            search = search -> parent;
            if (search -> value != value){
                cout << "Predecessor of " << value << " is " << search -> value;
            } else{
                cout << "Predecessor of " << value << " is " << findMax(search -> left) -> value;
            }
        }
    }
}


int main(){
    cout << "Hello" << endl;

    Node* l = createNode(6);
    l = insertNode(l, 1);
    l = insertNode(l, 3);
    l = insertNode(l, 5);
    l = insertNode(l, 8);
    printInOrder(l);
    cout << endl;

    cout << "Min = " << findMin(l) -> value << endl;
    cout << "Max = " << findMax(l) -> value << endl;

    int value_to_search = 123;
    Node* search = treeSearch(l, value_to_search);
    if (search == NULL){
        cout << "Can't find node "<<value_to_search<<"!" << endl;
    }
    else {
        cout << search -> value << endl;
    }
    l = deleteNode(l, 6);
    printInOrder(l);
    cout << endl;
    //cout << l->right->value;
    cout << endl;
    printPredecessor(l, 8);
    
    cout << endl;
    system("pause");
    return 0;
}

//Node* deleteNode(Node* root, int value){
    // The beneath is very wrong. Care about search adress
    // Node* search = treeSearch(root, value);
    // if (search == NULL){
    //     return root;
    // }
    // if (search->left == NULL && search->right == NULL){
    //     cout << search->parent->right->value;
    //     Node* parent = search->parent;
    //     if (parent -> right ==search){
    //         cerr << 'a';
    //     }
    //     else{
    //         cerr << 'b';
    //     }
    //     cerr << ' '<< search<< ' ';
    //     if (parent -> right ==search){
    //         cerr << 'a';
    //     }
    //     else{
    //         cerr << 'b';
    //     }
    // }
    // else if (search->left == NULL){
    //     Node* parent = search->parent;
    //     cerr << parent -> right-> right-> value << endl;
    //     cerr << parent -> right -> value << endl;
    //     search = search->right;
    //     cerr << parent -> right -> value << endl;
    //     cerr << search->parent->value <<' '<<search->value << endl;
    //     search->parent = parent;
    // }
    // else if (search->right == NULL){
    //     Node* parent = search->parent;
    //     search = search->left;
    //     search->parent = parent;
    // }
    // else {
    //     Node* left_most = search->right;
    //     while (left_most != NULL){
    //         left_most = left_most -> left;
    //     }
    //     left_most->parent->left = left_most->right;
    //     left_most->right->parent = left_most->parent;
    //     left_most->left = search->left;
    //     left_most->right = search->right;
    //     left_most->parent = search->parent;
    //     delete search;
    //}
//     return root;
// }