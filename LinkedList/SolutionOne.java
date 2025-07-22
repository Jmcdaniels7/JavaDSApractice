import java.util.*;

class Practice {
    public void printList(MyLinkedList<Integer> list) {
        MyLinkedList.Node<Integer> current = list.head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }
    MyLinkedList.Node<Integer> addTail(MyLinkedList.Node<Integer> head, int data)
    {
        MyLinkedList.Node<Integer> newTail = new MyLinkedList.Node<Integer>(data);
        if(head == null)
        {
            return newTail;
        }
        
        MyLinkedList.Node<Integer> current = head;

        while(current.next != null)
        {
            current = current.next;
        }

        current.next = newTail;

        return head;
    }

    MyLinkedList.Node<Integer> addNodeAtPos(MyLinkedList.Node<Integer> head, int position, int data)
    {
        MyLinkedList.Node<Integer> pos = new MyLinkedList.Node<Integer>(data);
        int count = 0;

        if(position < 1)
        {
            return pos;
        }

        MyLinkedList.Node<Integer> current = head;

        while(current.next != null)
        {
            if(count == position -1)
            {
                break;
            }
            current = current.next;
            count++;
        }

        pos.next = current.next;
        current.next = pos;

        return head;

    }

    MyLinkedList.Node<Integer> addNodeAtHead(MyLinkedList.Node<Integer> headPointer, int data)
    {
        MyLinkedList.Node<Integer> newHead = new MyLinkedList.Node<Integer>(data);
        if(headPointer == null)
        {
            return newHead;
        }

        newHead.next = headPointer;
        headPointer = newHead;

        return headPointer;
    }

    MyLinkedList.Node<Integer> deleteNode(MyLinkedList.Node<Integer> headPointer, int pos)
    {
        MyLinkedList.Node<Integer> current = headPointer;

        if(current == null)
        {
            return null;
        }

        int count = 0; 

        //O(n) runtime
        while(current.next != null)
        {
            if(count == pos)
            {
                break;
            }
            current = current.next;
            count++;
        }

        current.data = current.next.data;
        current.next = current.next.next;

        return headPointer;

    }

    public void reverseLinkList(MyLinkedList.Node<Integer> headPointer)
    {
        Stack<Integer> rev = new Stack<>();
        rev.push(headPointer.data);
        
        while(headPointer.next != null)
        {
            headPointer = headPointer.next;
            rev.push(headPointer.data);

        }
        
        while(!rev.isEmpty())
        {
            System.out.println(rev.pop());
        }

    }

    public MyLinkedList.Node<Integer> mergeTwoLists(MyLinkedList.Node<Integer> list1, MyLinkedList.Node<Integer> list2) 
    {
        //if null we return the other list
        if(list1 == null)
        {
            return list2;
        }

        if(list2 == null)
        {
            return list1;
        }

        //what happens first is we get to the end of each linked list
        // once we get to a null pointer we start to assign that 
        // lists link to the greater value and so on and so forth
        if(list1.data <= list2.data)
        {
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
        }
        else
        {
            list2.next = mergeTwoLists(list1, list2.next);
            return list2;
        }

    }

    public MyLinkedList.Node<Integer> sortLinkedList(MyLinkedList.Node<Integer> head) 
    {
        if (head == null || head.next == null) 
        {
            return head;
        }

        // Step 1: Split list into halves
        MyLinkedList.Node<Integer> mid = getMiddle(head);
        MyLinkedList.Node<Integer> nextToMid = mid.next;
        mid.next = null; // Split the list

        // Step 2: Sort both halves
        MyLinkedList.Node<Integer> left = sortLinkedList(head);
        MyLinkedList.Node<Integer> right = sortLinkedList(nextToMid);

        // Step 3: Merge sorted halves
        return mergeTwoLists(left, right);
    }

    private MyLinkedList.Node<Integer> getMiddle(MyLinkedList.Node<Integer> head) {
        if (head == null) 
        {
            return head;
        }
        
        MyLinkedList.Node<Integer> slow = head;
        MyLinkedList.Node<Integer> fast = head.next;

        while (fast != null && fast.next != null) 
        {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

}

public class SolutionOne {
    public static void main(String args[])
    {
        MyLinkedList<Integer> list = new MyLinkedList<>();
        MyLinkedList<Integer> listTwo = new MyLinkedList<>();


        MyLinkedList.Node<Integer> node1 = new MyLinkedList.Node<>(20);
        MyLinkedList.Node<Integer> node2 = new MyLinkedList.Node<>(27);
        MyLinkedList.Node<Integer> node3 = new MyLinkedList.Node<>(30);

        MyLinkedList.Node<Integer> node4 = new MyLinkedList.Node<>(24);
        MyLinkedList.Node<Integer> node5 = new MyLinkedList.Node<>(34);
        MyLinkedList.Node<Integer> node6 = new MyLinkedList.Node<>(19);

        list.head = node1;
        listTwo.head = node6;

        node6.next = node4;
        node4.next = node5;

        node1.next = node2;
        node2.next = node3;

        Practice ob = new Practice();

        // output works as a log so you can see what happend compared to the last linked list
        ob.printList(list);

        //add tail
        ob.addTail(list.head, 0);
        ob.printList(list);

        //add a MyLinkedList.node at a given position
        ob.addNodeAtPos(list.head, 2, 11);
        ob.printList(list);

        //add MyLinkedList.node at head
        MyLinkedList.Node<Integer> llist = ob.addNodeAtHead(list.head, 21);

        list.head = llist;

        ob.printList(list);

        //delete a give MyLinkedList.node
        MyLinkedList.Node<Integer> lilist = ob.deleteNode(list.head, 2);

        list.head = lilist;

        ob.printList(list);

        ob.reverseLinkList(list.head);

        //Sorting linked lists
        list.head = ob.sortLinkedList(list.head);
        listTwo.head = ob.sortLinkedList(listTwo.head);

        //merge two sorted linked lists
        System.out.println("Merged List:");

        MyLinkedList.Node<Integer> lil = ob.mergeTwoLists(list.head, listTwo.head);

        list.head = lil;

        ob.printList(list);

    }
    
}
