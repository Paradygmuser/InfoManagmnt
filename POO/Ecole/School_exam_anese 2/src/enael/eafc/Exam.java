package enael.eafc;
import java.util.*;

public enum Exam {
	/*
	 * J'ai voulu m'aumser avec l'enum selon votre pdf et deux trois ligne sur w3school avec le constructeur
	 * https://www.w3schools.com/java/java_enum_constructor.asp	 * 
	 * j'ai fait ca parce que je trouve ca fastudieux de creer les classe dans le main	 * 
	 * il ya trois classe dans l'ecole les preimere deuxieme et troiseme, dans l'ordre les examens
	 * l'idée est que la liste des examen est immuable ne bougerons jamais , donc pourquoi pas profiter de faire une enum, je ne sais pas si je vais reussir a attribuer des point.
	 */
	
	StructureOrdi(0,"SO","Structure d'ordinateur","Cour sur la comprehension d'un ordinateur et son fonctionnement basé sur le codage de signal en langage binaire"),
	PrincipeAna (1,"PAN","Principe d'analyse","Cour sur la sur la conception d'un objet et systeme a travers les diagram uml"),
	InitBD(2,"IBD","Initiation Base de donnée","Cour sur l'algebre relationnel et leur application dans les base de données avec les base de syntaxe SQL et les structure des données"),
	GestionBD(3,"GEBD","Gestion et Exploitation de Base de Donnee","Cour sur la gestion d'une base de donnée a travers des routine ou autre methode utile a la gestion d'une base de donnée avec les authorisations ainsi que l'exploitation de la base de donnée "),
	PrincipeAlgo(4,"PAL","Principe d'Algorithmie","Cour sur la comprehension d'un algorithme, les instructions en langages informatique et des application pratique"),
	BaseWeb(5,"BW","Base Web","Initiation aux protocole et langage web a travers internet a travers la creation d'une page web"),
	BaseReseau(6,"BR","Base de Réseaux","Cour sur la comprehnsion des transfert de donnée et l'interconnectivité a travers un reseaux partant du model OSI"),
	GestionProjet(7,"TGP","Technique de Gestion de Projet","Cour sur les methodologie et cadre de gestion de projet, a travers le cycle de vie d'un projet, les base d'une gestion de projet et de son bon déroulement"),
	OperatSys(8,"SE","System d'Exploitation","Cour sur la comprehnsion du fonctionnement d'un systeme d'exploitation et de son role entre l'ordinateur et l'utilisateur par des application pratique"),
	PrograOO(9,"POO","Programation Orientée Objet","Cour sur la comprehension d'un ordinateur et son fonctionnement basé sur le codage de signal en langage binaire"),
	PrincipeAnalysEtConception(10,"PAC","Principe d'Analyse et de Conception","description de projet d'analyse et conception"),
	Statistique(11,"ES","Element de Statistique","description de element statistique"),
	ProjetWEB(12,"PW","Projet Web","description de Projet Web");	
	private int id;
	private String raccourci;
	private String titre;
	private String description;
	//je creer le constructeur pour que ca reste enregistré dans l'ordre de construction de chaque element de l'enum type reference à une classe static public(mais le constructeur private?) et final appeler dans une interface generalmnt.
	private  Exam(int i, String r,String t, String desc) {
		this.id=i;
		this.raccourci=r;
		this.titre=t;
		this.description=desc;	
	}
	// j'ai appeler un seul set car a part les point rien ne doit etre changé.
	
	public int getId() {
		return id;
	}
	public String getTitre() {
		return titre;
	}
	
	public String getRaccourci() {
		return raccourci;
	}

	public String getDescription() {
		return description;
	}
}
