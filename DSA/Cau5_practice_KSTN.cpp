#include <bits/stdc++.h>

using namespace std;

struct Student{
    string name;
    int year_of_birth;
    int mark;
    Student* prev;
    Student* next;
};

Student* tail;

Student* createNode(string name, int year_of_birth, int mark){
    Student* student = new Student;
    if (student == NULL){
        cout << "Not enough memory!";
        return student;
    }
    student -> next = NULL;
    student -> prev = NULL;
    student -> name = name;
    student -> year_of_birth = year_of_birth;
    student -> mark = mark;
    return student;
}

void printStudent(Student* root){
    if (root == NULL){
        cout << "Nothing to print!" << endl;
    }
    else{
        Student* temp = root;
        while (temp != NULL){
            cout << temp -> name << ' ' << temp -> year_of_birth << ' ' << temp -> mark << endl;
            temp = temp -> next;
        }
    }
}

void PrintDS(int c){
    if (tail == NULL){
        cout << "Nothing to print!" << endl;
    }
    else {
        Student* temp = tail;
        while (temp != NULL){
            int year = temp -> year_of_birth;
            if (year % 2 == 1 && year > c){
                cout << temp -> name << ' ' << temp -> year_of_birth << ' ' << temp -> mark << endl;
            }
            temp = temp -> prev;
        }
    }
}

Student* addStudent(Student* root, string name, int year_of_birth, int mark){
    Student* new_student = createNode(name, year_of_birth, mark);
    tail -> next = new_student;
    new_student -> prev = tail;
    tail = new_student;
    return root;
}

int main(){
    Student* head = createNode("a", 1, 9);
    tail = head;
    head = addStudent(head, "b", 2, 9);
    head = addStudent(head, "c", 3, 9);
    head = addStudent(head, "d", 4, 9);
    head = addStudent(head, "e", 5, 9);
    PrintDS(1);


    

    system("pause");
    return 0;
}