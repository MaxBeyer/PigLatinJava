package englishToPig;

import java.util.ArrayList;
import java.util.List;

public class Translator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public String translateSentance(String stringToTranslate) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public String translateWord(String word) {
		int firstVowelIndex = findFirstVowel(word);
		String pigString = "";
		if(firstVowelIndex > 0) {
			pigString = word.substring(firstVowelIndex) + "-" + word.substring(0, firstVowelIndex) + "ay";
		} else {
			pigString = word + "-yay";
		}
		return pigString;
	}

	//if word has a vowel, return value will be greater than -1
	public Integer findFirstVowel(String word) {
		int vowelIndex= -1;
		List<String> vowels = new ArrayList<String>();
		vowels.add("a");
		vowels.add("e");
		vowels.add("i");
		vowels.add("o");
		vowels.add("u");
		vowels.add("A");
		vowels.add("E");
		vowels.add("I");
		vowels.add("O");
		vowels.add("U");
		for(String vowel:vowels) {
			if(word.indexOf(vowel) > 0) {
				vowelIndex =  word.indexOf(vowel);
				break;
			}
		}
		return vowelIndex;
	}

}
 