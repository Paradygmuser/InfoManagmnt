package eu.eafcevere.main;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import eu.eafcevere.*;

public class Launcher {

	public static void main(String[] args) {
		School school = new School("EAFC Evere");
		Student s1 = new Student(1, "Dupont", "Jean");
		Student s2 = new Student(2, "Dupont", "Sirius");
		Student s3 = new Student(3, "Durand", "Jean");
		Student s4 = new Student(4, "Poulet", "Jean-Hugues");
		Student s5 = new Student(5, "Romano", "Carmelo");

		Student s11 = new Student(1, "Dupont", "Jean");
		
		school.addStudent(s2);
		school.addStudent(s3);
		school.addStudent(s4);
		school.addStudent(s5);
		school.addStudent(s1);
		
		school.afficherParId();
		
		Date utilDate = new Date();

		
		String mydate = "20-03-2002";
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
		try {
			Date d = sdf.parse(mydate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

}
