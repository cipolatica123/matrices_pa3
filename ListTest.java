/*
Alberto Plata
1291980
pa3
*/

class ListTest {
	public static void main(String[] args){
	List L = new List();
	List P = new List();
	System.out.println("L.isEmpty()	: " + L.isEmpty());
	System.out.println("L.offEnd()	: " + L.offEnd());
    L.insertFront(50);
	System.out.println("L.equals(P)	: " + L.equals(P));
	System.out.println("P.equals(L)	: " + P.equals(L));
	P.insertBack(50);
	System.out.println("L.equals(P)	: " + L.equals(P));
	System.out.println("P.equals(L)	: " + P.equals(L));
	L.insertFront(40);
	L.insertFront(30);
	L.insertFront(20);
	L.insertFront(10);
	L.insertBack(60);
	L.insertBack(70);
	L.insertBack(80);
	L.insertBack(90);
	L.insertBack(100);
	System.out.println("Original List   : " + L.toString());



	  
	System.out.println("L.isEmpty()	: " + L.isEmpty());
	System.out.println("L.offEnd()  	: " + L.offEnd());
	
	System.out.println("L.toString()   	: " + L.toString());
	System.out.println("P.toString()	: " + P.toString());

	
	System.out.println("L.getLength()	: " + L.getLength());
	System.out.println("L.getFront()	: " + L.getFront());
	L.deleteFront();
	System.out.println("L.getLength()	: " + L.getLength());
	//System.out.println("L.getCurrent(): " + L.getCurrent());
 	L.moveTo(0);
	System.out.println("L.getCurrent()	: " + L.getCurrent());
	L.deleteFront();
	L.moveTo(2);
	System.out.println("L.getCurrent()	: " + L.getCurrent());
	//System.out.println("L.getCurrent()	: " + L.getCurrent());
	System.out.println("L.getFront()	: " + L.getFront());
	  
	System.out.println("L.isEmpty()	: " + L.isEmpty());
	
	System.out.println("L.toString()   	: " + L.toString());
	L.moveTo(3);
	L.deleteCurrent();
	System.out.println("L.toString()   	: " + L.toString());
	L.moveTo(3);
	L.insertBeforeCurrent(60);	
	L.movePrev();
    L.insertAfterCurrent(65);
	System.out.println("L.toString()   	: " + L.toString());
	L.deleteBack();
	System.out.println("L.toString()   	: " + L.toString());
	System.out.println("L.isEmpty()	: " + L.isEmpty());
    System.out.println("L.getBack()	: " + L.getBack());
	L.moveTo(3);
	System.out.println("L.toString()   	: " + L.toString());
	L.deleteCurrent();
	System.out.println("L.toString()   	: " + L.toString());
	//L.deleteCurrent();
	L.makeEmpty();
	L.insertFront(40);
	System.out.println("L.getFront()	: " + L.getFront());
	//L.deleteFront();
	//System.out.println("L.getFront()	: " + L.getFront());
	L.insertFront(50);
	L.moveTo(1);
	System.out.println("L.getBack()	: " + L.getBack());
	System.out.println("L.getCurrent()	: " + L.getCurrent());
	System.out.println("L.toString()   	: " + L.toString());
	L.deleteBack();
	System.out.println("L.toString()   	: " + L.toString());
	//System.out.println("L.getCurrent()	: " + L.getCurrent());
	System.out.println("L.isEmpty()	: " + L.isEmpty());
	L.insertFront(60);
	L.moveTo(0);
	System.out.println("L.toString()   	: " + L.toString());
	System.out.println("L.getCurrent()	: " + L.getCurrent());
	System.out.println("L.getFront()	: " + L.getFront());
	//L.deleteFront();
	L.deleteCurrent();
	System.out.println("L.toString()   	: " + L.toString());
	//System.out.println("L.getCurrent()	: " + L.getCurrent());
	System.out.println("L.getFront()	: " + L.getFront());
	L.makeEmpty();
	L.insertBack(111);
	System.out.println("L.toString()   	: " + L.toString());
	
		
		
		
	}
}