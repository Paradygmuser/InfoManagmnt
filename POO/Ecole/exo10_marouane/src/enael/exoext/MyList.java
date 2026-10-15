package enael.exoext;

public interface  MyList {
	public boolean add1(Element e) ; // parametre formel Element E 
	public void add(int index, Element e); // ajouter un element à un index donnée donc int + Element il faut contruire un objet element
	public Element get(int index); // donne l'element à l'index
	public boolean isEmpty(); //retourn vrai si la liste est vide
	public Element remove(int index) ; // eneleve l'element à l'index
	public Element set(int index, Element e); // remplace l'element à l'index
	public int size(); //retourne la taille de la liste
	/*public void indexOutOfBoundsException () {
		// string pour envoyer un message d'erreur dans la console
		if (add1(null) == false) {
			System.out.println("mauvais index ou inexistant");
		}
	}*/
}
