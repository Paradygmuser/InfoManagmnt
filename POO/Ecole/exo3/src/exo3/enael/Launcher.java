/*
 *  3. The results of a survey of the households in your township have been made available.
• Define a class Household that contains data for one household, including a four-digit integer identification number, 
  the annual income for the household, and the number of members of the household.
• Define a class Township that stores a number of households in a collection.
• Write some methods in this class to perform the following analyses:
- Count the number of households included in the township and print a table displaying the data read in.
- Calculate the average household income, and list the identification number and income of each household
that exceeds the average.
- Determine the percentage of households having incomes below the poverty level.
› The poverty level can be computed using the formula p = $6500.00 + $750.00 (m - 2) 
   where m is the number of members of each household.
› This formula shows that the poverty level depends on the number of 
  family members, m, and that the pov- erty level increases as m gets larger.
• Test your program on the following data.
Id		nmbrAnl		incomMembers
1041	$12,180		4
1062	$13,240		3
1327	$19,800		2
1483	$22,458		8
1900	$17,000		2
2112	$18,125		7
2345	$15,623		2
3210	$3,200		6
3600	$6,500		5
3601	$11,970		2
4725	$8,900		3
6217	$10,000		2
9280	$6,200		1
Create the appropriate testClass(es).
 * */
package exo3.enael;

public class Launcher {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Region r = new Region();
		
		r.retourDonne();
		r.moyenneRevenuEtExcesList();
		r.pourcentagePauvrete();

	}

}
