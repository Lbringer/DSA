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
    void insertAtBeg(int data);
    void insertAtEnd(int data);
    void createList();
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
void SingleLinkedList::insertAtBeg(int data)
{
    Node *temp = new Node(data);
    temp->link = start;
    start = temp;
}

void SingleLinkedList::insertAtEnd(int data)
{
    if (isEmpty())
    {
        insertAtBeg(data);
        return;
    }
    Node *temp = new Node(data);
    Node *p = start;
    while (p->link != NULL)
    {
        p = p->link;
    }
    p->link = temp;
}

void SingleLinkedList::createList()
{
    int n, data;
    cout << "How many elements do you want to insert?\n";
    cin >> n;

    if (n <= 0)
    {
        return;
    }
    cout << "Enter the first element\n";
    cin >> data;
    insertAtBeg(data);

    for (int i = 1; i < n; i++)
    {
        cout << "Enter next element\n";
        cin >> data;
        insertAtEnd(data);
    }
}

int main()
{
    SingleLinkedList list;
    list.createList();
    int choice, el, pos;
    while (1)
    {
        cout << "Enter you choice:\n";
        cout << "1.Display the list\n";
        cout << "2.Count the number of elements\n";
        cout << "3.Find the element\n";
        cout << "4.Insert element at beg\n";
        cout << "5.Insert element at end\n";
        cout << "-1.To quit\n";
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
                cout << "El found at " << pos << "\n";
            }
        }
        break;
        case 4:
        {
            cout << "Enter element to be inserted at starting:";
            cin >> el;
            list.insertAtBeg(el);
        }
        break;
        case 5:
        {
            cout << "Enter element to be inserted at ending:";
            cin >> el;
            list.insertAtEnd(el);
        }
        break;
        default:
        {
            cout << "Enter valid input\n";
        }
        break;
        }
    }
    cout << "Exiting \n";
    return 0;
}
