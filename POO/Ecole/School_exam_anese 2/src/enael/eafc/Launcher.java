package enael.eafc;

import java.util.Scanner;

public class Launcher {

	public static void main(String[] args) {
		School s= new School();
		Scanner scan = new Scanner(System.in);
		Menu menu = new Menu();
		menu.menuPrincipal(s, scan);
		//menu.menueAjouterStudent(s, scan);
		
		//Sa aurait ete moin lourd a voir si on le faisait dans leterminal . mais nous n'avons pas encor vu scanner
		//j'ai ameliorer l'attributiond es exam dans school
		//s.ajouterStudent(0, "Laghmich", "Anese", "2BACINFO");
		//s.ajouterStudent(1, "Laghmich", "Chadia", "2BACINFO");
		//s.ajouterStudent(2, "Laghmich", "Sabri", "2BACINFO");
		//s.ajouterStudent(3, "Laghmich","Dalila","1BACINFO");
		//s.ajouterStudent(4, "Vanderkerkove","Nicola","1BACINFO");
		//s.ajouterStudent(5, "Ponte","Antonio","1BACINFO");
		//s.ajouterStudent(6, "Dujardin","Elodie","1BACINFO");
		//s.ajouterStudent(7, "Dupont","Amelie","2BACINFO");
	//	s.ajouterStudent(8, "Pietrack","Nicolas","1BACINFO");
	//	//s.ajouterStudent(9, "Cardinal","Tony","2BACINFO");
		//s.ajouterStudent(10, "Barberouse","Jamel","1BACINFO");
		//s.ajouterStudent(11, "Pietrack","Agatha","1BACINFO");
		//s.ajouterStudent(12, "Chabane","Aldrick","2BACINFO");
		//s.ajouterStudent(13, "Cambiere","ZOE","2BACINFO");
		//s.ajouterStudent(14, "DuMoulin","Faride","2BACINFO");
		//s.ajouterStudent(15, "RaterSonIntero","Elisa","1BACINFO");
		
		//menu.menuAttribuerNote(s, scan);
		//s.ajouterExam(0, Exam.BaseWeb);
		//s.retirerExam(0, Exam.BaseWeb);
		//fair un mode encodage de point par scanner
		//s.attribuerNote(0, Exam.OperatSys, 10);
		//s.attribuerNote(0, Exam.PrograOO, 10);
		//s.attribuerNote(0, Exam.GestionProjet, 10);
		//s.attribuerNote(0, Exam.Statistique, 8);
		
		//s.attribuerNote(1, Exam.OperatSys, 10);
		//s.attribuerNote(2, Exam.OperatSys, 10);
		//s.attribuerNote(3, Exam.OperatSys, 10);
		//s.attribuerNote(4, Exam.BaseWeb, 20);
		//s.attribuerNote(5, Exam.BaseWeb, 18);
		//s.attribuerNote(6, Exam.BaseWeb, 17);
		//s.attribuerNote(7, Exam.OperatSys, 16);
		//s.attribuerNote(8, Exam.BaseWeb, 15);
		//s.attribuerNote(9, Exam.OperatSys, 14);
		//s.attribuerNote(10, Exam.StructureOrdi, 13);
		//s.attribuerNote(11, Exam.StructureOrdi, 12);
		//s.attribuerNote(12, Exam.OperatSys, 10);
		//s.attribuerNote(13, Exam.OperatSys, 10);
		//s.attribuerNote(14, Exam.OperatSys, 10);
		//s.attribuerNote(15, Exam.BaseReseau, 1);
		
		//c'est assez embetant de le faire ainsi, va falloir que je met un scanner.
		
		
		
		

	}

}
