
public class Node<Type> {
	private Type data;
	private Node<Type> next;
	private Node<Type> prev;	

	public Type getData() {
		return data;
	}
	public void setData(Type data) {
		this.data = data;
	}
	public Node<Type> getNext() {
		return next;
	}
	public void setNext(Node<Type> next) {
		this.next = next;
		next.prev = this;
	}
	public Node<Type> getPrev() {
		return prev;
	}

	public void setPrev(Node<Type> prev) {
		this.prev = prev; // thing1.prev = thing0
		prev.next = this; // thing0.next = thing1
	}
}
