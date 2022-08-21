#include <iostream>

using namespace std;

class Node
{
public:
    int info;
    Node *link;

    Node(int i)
    {
        info = i;
        link = NULL;
    }
};

class SingleLinkedList
{
    Node *start;
    bool isEmpty() const;

public:
    SingleLinkedList();
    void displayList() const;
    int countNodes() const;
    int find(int data) const;
};

SingleLinkedList::SingleLinkedList()
{
    start = NULL;
}

inline bool SingleLinkedList::isEmpty() const
{
    return start == NULL;
}

void SingleLinkedList::displayList() const
{
    if (isEmpty())
    {
        cout << "List is Empty\n";
        return;
    }
    Node *p = start;
    cout << "List is:";
    while (p != NULL)
    {
        cout << p->info << " ";
        p = p->link;
    }
    cout << "\n";
}

int SingleLinkedList::countNodes() const
{
    Node *p = start;
    int count = 0;
    while (p != NULL)
    {
        count++;
        p = p->link;
    }
    return count;
}

int SingleLinkedList::find(int data) const
{
    Node *p = start;
    int pos = 1;
    while (p != NULL)
    {
        if (data == p->info)
        {
            return pos;
        }
        pos++;
        p = p->link;
    }
    return -1;
}

int main()
{
    SingleLinkedList list;
    int choice, el, pos;
    while (1)
    {
        cout << "Enter you choice:\n(press -1 to quit)\n";
        cout << "1.Display the list\n";
        cout << "2.Count the number of elements\n";
        cout << "3.Find the element\n";
        cin >> choice;
        if (choice == -1)
        {
            break;
        }
        switch (choice)
        {
        case 1:
        {
            list.displayList();
        }
        break;
        case 2:
        {
            cout << "Number of elements are:" << list.countNodes() << "\n";
        }
        break;
        case 3:
        {
            cout << "Element to be searched?\n";
            cin >> el;
            pos = list.find(el);
            if (pos == -1)
            {
                cout << "El not in list\n";
            }
            else
            {
                cout << "El found at" << pos << "\n";
            }
        }
        }
    }
    cout << "Exiting \n";
    return 0;
}
