package eu.enael;

public class Launcher {
/*We want you to write an application for the HR division of a departmement of the defense.
• Write a class to represent a member of the defense (DefensePers).
- For each defense pers, we must know: 
› the matriculation.
› the name.
› the birth year. //22102025-291288
- Write methods able to:
› calculate the age of each person.
› return a representation of the person as a string like this : "name ( matriculation)".
› determine if a person must go to the pension (by default, it is when the age is more than 65).

• Write a sub class of DefensePers: CivilianPers
- This class must know:
› The sex of the person ( i.e. if the pers is a femal).
- Write methods able to:
› return a representation of the person as a string like this : "Mr name ( matriculation)" 
  if a man and "Mm name ( matriculation)" if a femal .
› determine if a person must go to the pension (actually, the limit is 60 for the mans and 50 for the femals).

• Write a sub class of DefensePers: Military.
- This class must know:
› The rank of the military. For a military, the pension limit depends on the rank.
So, you must write a class Rank. for each rank , we must know: a name and the pension limit
- Write methods able to:
› return a representation of the person as a string like this : "RANK name ( matriculation)"
› determine if a person must go to the pension (For a military, the pension limit depends on the rank !!).

• Write a class to represent a military unit.
- Each unit has a name
- Each unit can contain personel of the defense (militaries and civilians) - Write methods to:
› add a defense pers in the unit
› remove a defense pers from the unit
› return a list containing all the defense pers that must go to pension.
HINTS:
- Use a static field to represent the actual year.
- The representation method could be the toString() method of the class Object.
 * 
 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
