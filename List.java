/*
Alberto Plata
1291980
pa3
*/


class List
{
	   private class Node {
		Object data; 
		public Node previous;
		public Node next;
		public Node(Object d){
			data = d; 
			previous = next = null;
		}
		public String toString() 
		{ return data.toString(); }	
	}  
	
	private Node front;
	private Node current;
	private Node back;
	private int length;
	
	public List(){  
	front = current = back = null;
	length = 0;
	}
	
	// ***************************Access functions***********************************
int getLength() 
{ return length; }

boolean isEmpty() 
{ return length == 0; }

boolean offEnd() 
{ return current == null;  }

int getIndex() {
	if ( offEnd() ) return -1;
	int index = 0;
	Node temp = current;
	while (temp!= null) {
		temp = temp.next;
		index++;
	}
	return length - index;
}
Object getFront(){ 
	checkEx(2, "getFront()"); 
	return front.data;
} 

Object getBack() {   
	checkEx(2, "getBack()"); 
	return back.data;
}

Object getCurrent() {
	checkEx(1, "getCurrent()"); 
	return current.data;
}

public boolean equals(Object x){
	if (x == null)								return false;
	if (this.getClass() != x.getClass())		return false;
	List temp = (List)x;
	if(this.getLength() != temp.getLength())	return false;
	Node a = this.front;
	Node b = temp.front;
	while(a != null){
		if (!a.data.equals(b.data))				return false;
		a = a.next;
		b = b.next;
	}
	return true;
} 
//************************************ Manipulation Procedures *****************************
void makeEmpty() {
	front = current = back = null;
	length = 0;
}
void moveTo(int i) {
	if (i >= 0 && i < getLength()){
		current = front;
		while (i > 0){
			moveNext();
			i--;
		}	
	}
	else
		current = null;
}

void movePrev() {
	checkEx(1, "movePrev()"); 
	current = current.previous;
}

void moveNext() {
	checkEx(1, "moveNext()");
	current = current.next;
}

void insertFront(Object data) {
	Node newNode = new Node(data);
	if ( isEmpty())
		front = back = newNode;
	else{
		newNode.next = front;
		front.previous = newNode;
		front = newNode;
	}
	length++;
}

void insertBack(Object data) {
	Node newNode = new Node(data);
	if ( isEmpty())
		front = back = newNode;
	else{
		newNode.previous = back;
		back.next = newNode;
		back = newNode;
	}
	length++;
}

void insertBeforeCurrent(Object data) {
	checkEx(1, "insertBeforeCurrent()"); 
	if (getIndex()  == 0)
		insertFront(data);
	else{
		Node newNode = new Node(data);
		newNode.next = current;
		newNode.previous = current.previous;
		current.previous.next = newNode;
		current.previous = newNode;
		length++;
	}
}
	
void insertAfterCurrent(Object data) {
	checkEx(1, "insertAfterCurrent()"); 
	if (getIndex() == (length - 1))
		insertBack(data);
	else{
		Node newNode = new Node(data);
		current.next.previous = newNode;
		newNode.next = current.next;
		newNode.previous = current;
		current.next = newNode;
		length++;
	}
}

void deleteFront() {
	checkEx(2, "deleteFront()"); 
	if (length == 1)
	{	this.makeEmpty();  }
	else if ( current == front )
	{	  
		front = front.next;
		current = null;  
		length--;
	}
	else{
		front = front.next;
		length--;
	}
}

void deleteBack() {
	checkEx(2, "deleteBack()"); 
	if (length == 1)
	{	this.makeEmpty();  }
	
	else {
		if (current == back)
			current = null;
		back = back.previous;
		back.next = null;  
		length--;
	}
}

void deleteCurrent() {
	checkEx(1, "deleteCurrent()");
	if (getIndex() == 0)
	{ 	deleteFront();	}
	else if (getIndex() == (length-1))
	{ 	deleteBack();	}
	else{
		current.previous.next = current.next;
		current.next.previous = current.previous;
		current = null;
		length--;
	}
}
// ******************************** Other Methods ***********************************
private void checkEx(int num, String s){
	switch (num){
		case 1:		if (this.offEnd() ) 
	{	throw new RuntimeException("Matrix Error: " + s + " called on undefined Current");   }
		case 2: 	if (this.isEmpty() ) 
	{   throw new RuntimeException("Matrix Error: " + s + " called on empty Queue");  }
		default:	break;
	}
}

public String toString() {
	String elements = "";
	Node temp = this.front;
	while (temp != null){
		elements += temp.toString();
		if (temp.next != null)
			elements += " ";
		temp = temp.next;
	}
	return elements;
}


}