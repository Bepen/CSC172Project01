/*
Bepen Neupane
Lab: Tuesday & Thursday 4:50-6:05
Project 1 - Master Mind
bneupane@u.rochester.edu
*/

public interface SimpleLinkedList <AnyType>{
	public void insert(AnyType x);
	public void delete(AnyType x);
	public boolean contains(AnyType x);
	public AnyType lookup(AnyType x);
	public boolean isEmpty();
	public void printList();
}
