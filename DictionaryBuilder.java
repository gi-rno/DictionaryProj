import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class DictionaryBuilder {
	
	static final double LOAD_FACTOR = 0.6;
	
	private String[] tempArr;
	
	private String[] buckets;
	
	private String[] uniqueArr;

	public DictionaryBuilder(int estimatedEntries) {
		
		
		
		
	}
	
	public DictionaryBuilder(String fileName) throws FileNotFoundException{
		
		File file = new File(fileName);
		
		Scanner inpt = new Scanner((file));
		
		long estimatedUniqueWords = file.length() / 100;
		
		double tableSize = estimatedUniqueWords / 0.6;
		
		tempArr = new String[(int)tableSize];
		
		uniqueArr = new String[(int)tableSize];
		
		buckets = new String[(int)tableSize];
		
		inpt.useDelimiter(" ");
		
		while(inpt.hasNext()) {
			
			int i = 0;
			
			tempArr[i] = (inpt.next().replaceAll("[!.,'\"?;-]", "").toLowerCase());
			
			i++;
		}
		
		int index = 0;
		
		for(int i = index; i < tempArr.length;i++) {
			
			String current = tempArr[i];
			
			for(int j = 0; j < uniqueArr.length; j++) {
				
				if(uniqueArr[j].equals(current)) {
					
					
				}
				uniqueArr[index] = current;
				
				index++;
			}
		}
		
		int wordNum = buckets.length;
		
		double loadFac = calcLF(wordNum, (int)tableSize);
		
			if(loadFac >= LOAD_FACTOR) {
							
				buckets = new String[fourK3Prime((int)tableSize)];
			}
			
		int i = 0;
			
		for(String word : words) {
			
			buckets[i] = word;
			
			i++;
		}
		
		
		
	    
	}
	
	public void addWord(String word) {
		
		
	}
	
	public int getFrequency(String word) {
		
		
	}
	
	public void removeWord(String word) {
		
		
	}
	
	public ArrayList<String> getAllWords() {
		
		
	}
	
	public double calcLF(int numStoredElements, int tableSize) {
		
		double LF = (double)numStoredElements / tableSize;
	    
	    return LF;
	}
	
	private int fourK3Prime(int tSize) {
		
		while(true) {
		if(tSize % 4 != 3) {
			
			tSize++;
		}
		if(isPrime(tSize) && tSize % 4 == 3) {
			
			return tSize;
		}
		tSize++;
		}
	}
	
	private boolean isPrime(int n) {
		
		if(n<=1) {
			
			return false;
		}
		if(n == 2 || n == 3) {
			
			return true;
		}
		if(n % 2 == 0 || n % 3 == 0) {
			
			return false;
		}
		for(int i = 5; i <= Math.sqrt(n); i = i + 6) {
			
			if(n % i == 0 || n % (i + 2) == 0) {
				
				return false;
			}
		}
		return true;
	}
	
}
