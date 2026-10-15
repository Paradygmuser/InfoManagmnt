package School;

import java.util.Date;

public class Student implements Comparable<Student> {
	
	private int id;
	private String name; // prenom ou non de famille ? c'est pas claire pour un francophone qui parle a moitié francais
	private String lastname;
	private Date birthday;
	
	
	// ta classe est parfaite, ton constructeur aussi
    public Student(int id, String firstName, String lastName/*, Date birthday*/) {
    	this.id = id;
        this.name = firstName; // ok name veut dire prenom, mohim, faut garder ca en tete pour les autre classe.
        this.lastname = lastName;
        /*this.birthday = birthday;*/
    }
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	/*
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}*/ //non fait en classe mais on a vu la theorie rien a voir avec l'ennoncé...
	
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", lastname=" + lastname + ", birthday=" + birthday + "]";
	}

// alors pour l'override d'equals apparement on doit le faire systemeatiquement comme des zombie sans savoir pourquoi, ici dans mon code, j'en ai jamais beson jamais	
// je le met quand meme pour que tu n'oublie pas que les prof mmagnifique et geniaux que nous avons nous demande le faire à chaque classe...
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}

	// le trie par default grace à implements Comparable
	@Override
	public int compareTo(Student o) {
		
		return this.id-o.id; // normlmnt c'est dans cette ordre, si tu vois le tri par defaut, normlmnt chaque id est unique mais avec le hardcoding, l'erreur humaine peut intervenir.
	}
	
	
	
	
	
	

}
