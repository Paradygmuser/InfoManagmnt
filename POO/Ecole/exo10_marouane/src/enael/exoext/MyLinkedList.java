package enael.exoext;

public class MyLinkedList implements MyList() {
	private Node<Element> head = null;
	private int size = 0; 
	
	
	@Override
	public void add(int index, Element e) {
	    if (index == 0) {
	    	this.head = new Node<>(e, head);
	    } 
	    else {
	        Node<Element> previous = getNode(index - 1); //recuperer le noeud precedent avec les elements ajouter
	        previous.next = new Node<>(e, previous.next); // instancie un nouveaux noeud avec le nvl element et le noeud precedent pour ecrasé la linked list actuel
	        ++size; //++augmente la taille de un	
	    }
	}
	private Node<Element> getNode(int index) {
		if (index >= 0 && index < this.size()) {
		    Node<Element> current = head;
	    	for (int i = 0; i < index; ++i) {
		        current = current.next; //next retourne un Node<Element>
		    }
		    return current;
		}
		else {
			throw new IndexOutOfBoundsException("Index " + index + " out of bounds."); //j'ai copié coller ce bloque je connais pas trow
		}
	}
	
	@Override
	public int size() {
	    return size;
	}
}