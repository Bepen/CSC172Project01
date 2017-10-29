/*
Bepen Neupane
Lab: Tuesday & Thursday 4:50-6:05
Project 1 - Master Mind
bneupane@u.rochester.edu
*/

public class ListLinked <AnyType> implements SimpleLinkedList<AnyType>{
	public MyNode<AnyType> first;

	public ListLinked() {
		first = new MyNode<AnyType>();
	}

	@Override
	public void insert(AnyType x) { // inserts element x into the list
		MyNode<AnyType> node = first;
		MyNode<AnyType> newNode = new MyNode<AnyType>();
		newNode.data = x;
		
		if (!contains(x)) {
			while (node.next != null) {
				node = node.next;
			}
			node.next = newNode;
		}
	}

	@Override
	public void delete(AnyType x) { // deletes element x from the list
		if (contains(x)) {
			
			MyNode<AnyType> node = first;
			while (node.next != null) {
				if (node.next.data.equals(x)) {
					node.next = node.next.next;
					break;
				} else {
					node = node.next;
				}
			}
		}
	}


	@Override
	public boolean contains(AnyType x) { // checks if an element is already in the list
		MyNode<AnyType> node = first.next;
		while (node != null) {
			if (node.data.equals(x)) {
				return true;
			}
			node = node.next;
		}
		return false;
	}

	@Override
	public AnyType lookup(AnyType x) { // looks up an element
		MyNode<AnyType> node = first.next;
		while (node != null) {
			if (node.data.equals(x)) {
				return x;
			}
			node = node.next;
		}
		return null;
	}


	@Override
	public boolean isEmpty() { // checks if the list is empty
		if (first.next == null) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public void printList() { // prints the contents of the list
		MyNode<AnyType> node = first.next;
		System.out.print("[");
		while (node != null) {
			if (node.next == null) {
				System.out.print(node.data);
				node = node.next;
			} else {
				System.out.print(node.data + ", ");
				node = node.next;
			}
		}
		System.out.println("]");
	}
	
	public AnyType firstArray() { // gets the first element that is in the linked list which just happens to be an array
		return first.next.data;
	}
	
	public AnyType get(int n) { // gets the element in the specific index
		MyNode<AnyType> node = first.next;
		for (int i = 0; i < n; i++) {
			node = node.next;
		}
		return node.data;
	}
	
	public int getLength() { // gets the length of the list
		MyNode<AnyType> node = first.next;
		int length = 0;
		while(node != null) {
			length++;
			node = node.next;
		}
		return length;
	}
	
	
	
}
