import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class DictionaryBuilder {
	
	static final double LOAD_FACTOR = 0.6;
	
	private String[] tempArr;
	
	private GeneralLinkedList<String>[] buckets;
	
	private String[] uniqueArr;

	public DictionaryBuilder(int estimatedEntries) {
		
		int tableSize = estimatedEntries / LOAD_FACTOR;
		
		buckets = new GeneralLinkedList[tableSize];
		
		for(int i = 0; i < buckets.length; i++) {
			
			buckets[i] = new GeneralLinkedList<>();
	}
	}
	
	public DictionaryBuilder(String fileName) throws FileNotFoundException{
		
		File file = new File(fileName);
		
		Scanner inpt = new Scanner((file));
		
		long estimatedUniqueWords = file.length() / 100;
		
		double tableSize = estimatedUniqueWords / 0.6;
		
		tempArr = new String[(int)tableSize];
		
		uniqueArr = new String[(int)tableSize];
		
		buckets = new GeneralLinkedList[(int)tableSize];
		
		for(int i = 0; i < buckets.length; i++) {
			
			buckets[i] = new GeneralLinkedList<>();
		
		inpt.useDelimiter(" ");
		
		int k = 0;
		
		while(inpt.hasNext()) {
			
			tempArr[k] = (inpt.next().replaceAll("[!.,'\"?;-]", "").toLowerCase());
			
			k++;
		}
		
		int index = 0;
		
		for(int l = 0; l < tempArr.length;l++) {
			
			String current = tempArr[l];
			
			boolean isUnique = true;
			
			for(int j = 0; j < index; j++) {
				
				if(current.equals(uniqueArr[j])) {
					
					isUnique = false;
					
					break;
				}
				
				}
			if(isUnique) {
				
				uniqueArr[index] = current;
				
				index++;
			}
		}
		
		int wordNum = uniqueArr.length;
		
		double loadFac = calcLF(wordNum, (int)tableSize);
		
			if(loadFac >= LOAD_FACTOR) {
							
				buckets = new String[fourK3Prime((int)tableSize)];
			}
			
			for(int m = 0; m < uniqueArr.length; m++) {
				
				String word = uniqueArr[m];
				
				int hashedWord = word.hashCode();
				
				int indexMap = fourK3Prime(hashedWord);
				
				indexMap = hashedWord % buckets.length;
				
				buckets[indexMap].add(hashedWord);
			}
			
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
