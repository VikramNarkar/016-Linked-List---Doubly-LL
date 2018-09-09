package com.vikram.java.innovations;

public class DoublyLinkedListRunner {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Node n1 = new Node(5);
		
		DoublyLinkedList l = new DoublyLinkedList();
		
		l.insertFirst(n1);
		l.printLinkedList(); // 5
		
		l.insertFirst(new Node(7));
		l.printLinkedList(); // 7 5
		
		l.insertLast(new Node(10));
		l.printLinkedList(); // 7 5 10
		
		l.insertAtIndex(new Node(3), 1);
		l.printLinkedList(); // 7 5 10
	
		l.insertAtIndex(new Node(13), 1);
		l.printLinkedList(); // 3 7 5 10

	}

}
