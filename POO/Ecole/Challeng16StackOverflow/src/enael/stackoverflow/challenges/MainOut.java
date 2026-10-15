package enael.stackoverflow.challenges;

import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class MainOut {

	public static void main(String[] args) {
		//0. Get content of file in a string and calculate number of lines
		String path ="/Users/emac/ECLIPSEPROJECTS/Ecole/Challeng16StackOverflow/input.txt";
		ReadInput ri = new ReadInput(path);
		String recup = ri.getReturnedString().replaceAll(" ",""); // we recup a String with some \n, each line is one input
		int nbrOfLines = recup.split("\n").length; //split lines * count lines
		//0.1 Variables for algo
		//rows number correspond to numbre of line, and 3 collumn for each attribut(coin, count, target)
		String [] line =recup.split("\n"); //split lines
		
		for(int hh=0;hh<20;hh++) {
			System.out.println(line[hh]);
		}
		
		int [] answer = new int[nbrOfLines];
		int target =0;
		int totalBankLine = 0;
		
		
		
		for(int ii=0; ii<nbrOfLines;ii++) {
			totalBankLine=0;
			String [] toAdd =  line[ii].split("],");
			ArrayList<Integer> coins = new ArrayList<Integer>();
			ArrayList<Integer> counts = new ArrayList<Integer>();
			target = Integer.parseInt(toAdd[(toAdd.length-1)]);
			System.out.println("target : "+target);
            for(int clef = 0; clef<(toAdd.length-1)/2;clef++) {
            	String coin0 = toAdd[clef].replaceAll("\\[", ""); // one or a list of coin
            	String count1 = toAdd[clef+1].replaceAll("\\[", ""); // one value or list of value of number coin present in bank
            	if(coin0.contains(",")) {
            		String [] coin00 =coin0.split(",");
            		String [] count01 =count1.split(",");
            		for(int coiny=0;coiny<coin00.length;coiny++) {
                    	coins.add(Integer.parseInt(coin00[coiny]));
                    	counts.add(Integer.parseInt(count01[coiny]));
                    	totalBankLine+=coins.get(coiny)*counts.get(coiny);
            		}
            		
            	}
            	else {
                	coins.add(Integer.parseInt(coin0));
                	counts.add(Integer.parseInt(count1));
                	totalBankLine+=coins.get(clef)*counts.get(clef);	
            	}
            }
            if(totalBankLine>=target) {
     			int counter=0;
         		for(int i=coins.size()-1;i>=0;i--) {
         			if(combinaison(i,target,coins,counts)) {
         				for(int q=0;q<counts.size();q++) {
         					counter++;
             				target-=coins.get(i);
         				}
         				
         			}
         		}
         		if(target==0) {
         			answer[ii]=counter;
         		}
         		else {
         			answer[ii]=-12;
         		}

                
         	}
         	else {
         		answer[ii]=-1;
         	}
     		System.out.println(answer[ii]+" : reponse");
		}
		
	}
	public static boolean combinaison(int index, int target, ArrayList<Integer>coins, ArrayList<Integer> counts) {
		boolean succes= false;
		int newTarget = 0;
		
		if(target==0) {
			succes= true;
		}
		else if(target<0 || index==coins.size()) {
			succes= false;
		}
		else {
			for(int k=0;k<counts.get(index);k++) {
				if(target-k*coins.get(index)>=0) {
					newTarget=target-k*coins.get(index);
					succes=true;
				}
			}
		}
		return succes;
		
	}
}
