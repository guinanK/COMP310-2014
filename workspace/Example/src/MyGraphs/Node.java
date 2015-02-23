package MyGraphs;

import java.util.ArrayList;



public class Node<T> {
	Node(T data){
		this.data = data;
		neighbors = new ArrayList<Node<T>>();
	}
	final public T data;
	final public ArrayList<Node<T>> neighbors;

	
}
