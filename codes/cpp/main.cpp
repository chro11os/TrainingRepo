#include <iostream>
#include <cstring>
using namespace std;

string name;
string bday;
int age;

int main()

{
    cout << "Enter Name: ";
    getline(cin, name);

    cin.ignore();

    cout << "Enter Birthday: ";
    getline(cin, bday);

    cout<<"Enter Age: ";
    cin >> age;
}