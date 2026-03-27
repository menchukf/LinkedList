/*
Problem:  Write a program that keeps and manipulates a linked list of
	    String data. The data will be provided by the user one item at a time.
      The user should be able to do the following operations:
                     -add "String"
                                adds an item to your list (maintaining alphabetical order)
                     -remove "String"
                                if the item exists removes the first instance of it
                     -show
                                should display all items in the linked list
                     -clear
                               should clear the list
	Input:  commands listed above
	Output:  the results to the screen of each menu
	    choice, and error messages where appropriate.
*/


// Alexandria Krouse
// 9/24/25
// Created a linked list that can add, remove, show, and clear values in the list.

import java.util.List;

import org.w3c.dom.Node;

public class LinkedList{
  //instance varialbes go here (think about what you need to keep track of!)

  //constructors go here
    public ListNode head = null;



  //precondition: the list has been initialized
  //postcondition: the ListNode containing the appropriate value has been added and returned
  public ListNode addAValue(String line)
  {
    ListNode newNode = new ListNode(line, null);
    
    if(head ==null){
      head = newNode;
    }
    else if (line.compareTo(head.getValue())<0){
      newNode.setNext(head);
      head = newNode;} //add to front situation
    
    else {//adding to middle or end
    //traverse until you find the right spot. When the next element is larger than you.
    ListNode next= head;
    while((next.getNext() != null) && (next.getNext().getValue().compareTo(next.getValue())<0)){
    next = next.getNext();
    }
//do something to newNode so we don't lose the rest of the list
    newNode.setNext(next.getNext());
    next.setNext(newNode);
  }
    return newNode;
  }

  //precondition: the list has been initialized
  //postcondition: the ListNode containing the appropriate value has been deleted and returned.
  //if the value is not in the list returns null
  public ListNode deleteAValue(String line)
  {
     if (head == null){
      return null;
    }
  
    if(head.getValue().equals(line)){
      head = head.getNext();
      return head;
    }

    //find the node just before the node you want gone
      ListNode next = head;
      //some sort of loop
     while(next.getNext().getValue().compareTo(line) != 0){
        next = next.getNext();
      }
      
      if(next.getNext() != null){
        ListNode temp = next.getNext();
        next.setNext(next.getNext().getNext());
        return temp;
      }
     
    
    return null;
  }

  //precondition: the list has been initialized
  //postconditions: returns a string containing all values appended together with spaces between.
  public String showValues()
  {
    ListNode next = head;
    String result = "";
    while(next != null){
      result += next.getValue() + " ";
      next = next.getNext();
    }
      return result;
  }

  //precondition: the list has been initialized
  //postconditions: clears the list.
  public void clear()
  {
   head = new ListNode(null, null);
  }
}
