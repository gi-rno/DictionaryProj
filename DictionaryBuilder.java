import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class DictionaryBuilder {
	
	private final double LF = 0.6;
	
	Set<String> words = new HashSet<String>();
	
	File file;
	
	private class Node{
		
		private T data;
		
		Node next;
	}

	public DictionaryBuilder(int estimatedEntries) {
		
		int n = 10;
		
		if(calcLF(estimatedEntries) >= 0.6) {
			
			String array[] = new String[n*2];
		}
	}
	
	public DictionaryBuilder(String fileName) throws FileNotFoundException{
		
		Scanner inpt = new Scanner(new File(fileName));
		
		long eUW = estimatedUniqueWords(file.length());
		
		inpt.useDelimiter(" ");
		
		while(inpt.hasNext()) {
			
			words.add(inpt.next().strip().toLowerCase());
		}
		
		int wordNum = words.size();
		
		calcLF(wordNum);
		
	    
	}
	
	public void addWord(String word) {
		
		
	}
	
	public int getFrequency(String word) {
		
		
	}
	
	public void removeWord(String word) {
		
		
	}
	
	public ArrayList<String> getAllWords() {
		
		
	}
	
	public double calcLF(int estimatedEntries) {
		//recommended table size
		double tableSize = (estimatedEntries / 0.6);
	    //load factor
	    double lF = estimatedEntries / tableSize;
	    
	    return lF;
	    
	    
	}
	
	public double estimatedUniqueWords(long fileSize) {
		
		
	}
}
