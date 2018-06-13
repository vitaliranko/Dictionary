package core;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Dictionary {

	static final String pathToFile = "./resources/dictionary.txt";	

	static String myDictionary(String inputText) {	
		String textResult = "";	
		String regex = "^((\\w+?)(?:\\s\\–\\s)(.*))$";		
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(inputText);
		m.find();
		String mainWord = m.group(2);
		String wordDescription = m.group(3).replaceAll(",\\s", "\n");
		textResult = mainWord + "\n" + wordDescription + "\n";
		return textResult;
	}	

	static void readFile() {
		String line = "";
		String cvsSplitBy = "\n";
		try (BufferedReader br = new BufferedReader(new FileReader(pathToFile))) {
			while ((line = br.readLine()) != null) {
				String[] country = line.split(cvsSplitBy);
				for (int i = 0; i < country.length; i++) {
					System.out.println(myDictionary(country[i]));
				}
			}
		
		} catch (FileNotFoundException e){
			System.err.printf("File \"%s\" does not exists!!!\n",pathToFile);
		}	
		 catch (IOException ex) {
				System.out.printf("File \"%s\" can not be opened!!!\n", pathToFile);
		}
		
	}
	public static void main(String[] args) {
		new Dictionary();
		Dictionary.readFile();

	}

}

