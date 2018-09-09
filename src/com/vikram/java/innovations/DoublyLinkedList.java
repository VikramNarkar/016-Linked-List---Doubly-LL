package com.vikram.java.innovations;

/**
 * @author Vikram
 * 
 * @category This is written by me. Verified a bit from 
 * http://homepage.cs.uiowa.edu/~sriram/21/fall05/ExamplePrograms/ReaderFiles/Chap05/linkList/linkList.java
 * 
 * That program is also saved as 'DLLBySriram' (for your reference)
 * 
 * This program may not be complete. Complete it.
 */

public class DoublyLinkedList {
	
	private Node first;
	private Node last;
	private int size;
	
	public DoublyLinkedList () {
		this.first = null;
		this.last = null;
		size = 0;
	}
	
	public void insertFirst (Node node) {
		if (isEmpty()) {
			first = node;
			last = node;
		} else {
			node.setNext(first);
			
			first.setPrevious(node);
			first = node;
		}
		
		size++;
	}
	
	public void insertLast (Node node) {
		if (isEmpty()) {
			first = node;
			last = node;
		} else {
			node.setPrevious(last);
			
			last.setNext(node);
			last = node;
		}
		
		size++;
	}
	
	/* Note: As we know the size of DLL and as this is DLL, we can check whether the 
	 * node to be inserted is near from the start or the end of the DLL and can 
	 * traverse accordingly (I have not actually done that in here though) */
	
	public void insertAtIndex (Node node, int index) {
		if (index <= 0) {
			System.out.println("Please enter the index as a positive integer.");
		} else {
			if (isEmpty()) {
				first = node;
				last = node;
			} else {
				int currIndex = 1;
				Node curr = first;
				
				while (curr.getNext() != null && currIndex < index-1) {
					curr = curr.getNext();
					currIndex++;
				}
				
				if (index == 1) { 					// This condition was not covered earlier
					node.setNext(first);
					
					first.setPrevious(node);
					
					first = node;
				} else if(curr.getNext() == null) { //The nodes already in the DLL were less than the index;
													//hence inserting at last position
					node.setPrevious(curr);
					
					curr.setNext(node);
					
					last = node;
				} else if (currIndex == index-1){
					node.setNext(curr.getNext());
					node.setPrevious(curr);
					
					curr.setNext(node);
				} 
			}
			
			size++;
		}		
		
	}
	
	
	public void removeFirst () {
		if (!isEmpty()) {

			if (size == 1) {
				first = null;
				last = null;
			} else {
				first = first.getNext();
				first.setPrevious(null);
			}
			size--;
		}
			
	}
	
	public void removeLast () {		
		if (!isEmpty()) {
			
			if(size == 1) {
				first = null;
				last = null;
			} else {
				last = last.getPrevious();
				last.setNext(null);
			}
			
			size--;
		}
	}
	
	public Node removeAtIndex (int index) {
		if (index <= 0) {
			System.out.println("Please enter the index as a positive integer.");
			return null;
		} else {
			if (isEmpty() || size < index) {
				return null;
			} else {
				int currIndex = 1;
				Node curr = first;
				Node nodeToBeRemoved;
				
				while (currIndex < index-1) {
					curr = curr.getNext();
					currIndex++;
				}
				
				if (index == 1) {
					nodeToBeRemoved = first;
					
					if (first.getNext() != null) {
						first = first.getNext();
						first.setPrevious(null);
					} else {
						first = null;
						last = null;
					}
					
					size--;
					
					return nodeToBeRemoved;
				}
				
				if (currIndex == index-1){
					nodeToBeRemoved = curr.getNext();
					curr.setNext(nodeToBeRemoved.getNext());
					nodeToBeRemoved.getNext().setPrevious(curr);
					
					nodeToBeRemoved.setNext(null);
					size--;
					
					return nodeToBeRemoved;
				} else {
					return null;
				}
			}
			
			
		}		
		
	}
	
	public boolean isEmpty(){
		return (size == 0);
	}
	
	public void printLinkedList () {
		System.out.println("Linked list is:");
		
		Node curr = first;
		while (curr!=null) {
			System.out.print(curr.getData() +" ");
			curr = curr.getNext();
		}
		System.out.println();
	}
	
}
