using System;
using System.Collections.Generic;
using System.IO;

namespace to_javascript_bot_sentence
{
	public class citaitonaleatoire
	{
		Random rand = new Random();

		List<string> citationList = new List<string>();
		
		public string [] ListerCitations()
		{
                   using (StreamReader streamReader = new StreamReader(@"c:\Users\Enael\Documents\ressourcesweb\citationenuage.txt"))
                   {
                      string line;
                      while ((line = streamReader.ReadLine()) != null)
                      {
                          citationList.Add(line);
                      }                                           
                   }
                   string [] citationArray = citationList[0].Split('-'); 
                   return citationArray;
		}
		
		public string CitationAleatoire()
		{
			string [] citations = ListerCitations();
			int aleatoire = rand.Next(citations.Length);
			return citations[aleatoire];
		}	
			
	}
}
