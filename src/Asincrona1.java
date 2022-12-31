import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class Asincrona1 {
	
	
	
	
	public static int countLanguages1(String[] locales) {
		
		Set<String> languagesSet = new TreeSet<>();
		for(String l : locales) {
			
			String var=(l.substring(0,2).toUpperCase());
			languagesSet.add(var);
			
		}
		System.out.println(languagesSet.size());
		return languagesSet.size();

	}
	
public static int countLanguages(String[] locales) {
		
		Set<String> languagesSet = new HashSet<>();
		for(String l : locales) {
			
			String var=(l.substring(0,2).toUpperCase());
			languagesSet.add(var);
			
		}
		System.out.println("desde el 2");
		System.out.println(languagesSet.size());
		return languagesSet.size();

	}

public static int findUnique(int[] array) {
	Map <Integer, Integer> numberMap = new HashMap<>();
	for(int i = 0; i<array.length; i++) {
		if(numberMap.get(array[i]) == null) 
			numberMap.put(array[i],1);
		else
			numberMap.put(array[i],numberMap.get(array[i])+1);
	}
	int unique=0;
	for(int i : numberMap.keySet()) {
		if(numberMap.get(i)==1) 
			unique=i;
	}
	
	return unique;
	
}

	
		






	public static void main(String[] args) {
		
		
		String[] locales = { "es-mx", "ru", "en-US", "fr-FR", 
								"de-ch", "ES-CO", "en-gb", 
								"en-us", "es-Mx", "FR-ca", "de-DE" };  
		
		//countLanguages(locales);

	int[] array = { 4, -5, 3, -6, 4, 2, 1, 7, 0, -5, -6, 0, 7, 1, 3, 4, -6 };
	System.out.println(findUnique(array));
	}
		

	
	}


