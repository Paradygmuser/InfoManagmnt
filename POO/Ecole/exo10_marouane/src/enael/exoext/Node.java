package enael.exoext;

public class Node<Element> {
    protected Element element; /// j'ai mis private car je n'ai pas creer de package.
	protected Node<Element> next;
	
	//constructeur
	public Node (Element e, Node<Element> next){
		this.element = e;
		this.next=next;		
	}

}
