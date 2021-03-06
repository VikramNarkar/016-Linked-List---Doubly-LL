package com.vikram.java.innovations;

public class Node {
	private int data;
	private Node next;
	private Node previous; //DLL has previous!
	
	public Node() {
		
	}
	
	public Node(int data) {
		this.data = 	data;
		this.next = 	null;
		this.previous = null;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}

	public Node getPrevious() {
		return previous;
	}

	public void setPrevious(Node previous) {
		this.previous = previous;
	}

}
