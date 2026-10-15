package enael.stackoverflow.challenges;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class ReadInput  {
	private String returnedString;
	
	public ReadInput(String path) {
		this.returnedString=stringFormArray(path);
		
	}
	public String getReturnedString() {
		return returnedString;
	}
	
	private String stringFormArray(String path) {
		StringBuilder sb = new StringBuilder();
		//System.out.println("ready to print file from "+path);
		try(BufferedReader br = new BufferedReader(new FileReader(path))){
			String line;
			while((line= br.readLine()) != null) {
				if(line.length()>1) {
					sb.append(line);
					sb.append("\n"); //to preserve lines
				}
			}			
		}
		catch(IOException e) {
			 e.getMessage();
		}
		return sb.toString();
	}
	@Override
	public String toString() {
		return "ReadInput [returnedString=" + returnedString + "]";
	}
}
