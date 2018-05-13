package englishToPig;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Translator {
	
	//private String[] vowelStringArray = {"a", "e", "i", "o", "u", "A", "E", "I", "O", "U"};
	private List<String> vowels = new ArrayList<String>(Arrays.asList(new String[] {"a", "e", "i", "o", "u", "y", "A", "E", "I", "O", "U", "Y"}));

	public static void main(String[] args) {
		Translator translator = new Translator();
		String test = "And now, for my first trick, I shall perform an act that has never been seen before!  Witness, Terry's Turnaround!";
		String translation = translator.translateSentence(test);
		System.out.print(translation);

	}
	
	//save each word of the string into an array using the word regular expression. This ensures punctuation remains.
	//loop through the string, replacing each matched word from the array with a pig latin translation
	public String translateSentence(String stringToTranslate) {
		Translator translator = new Translator();
		String translatedString = stringToTranslate;
		List<String> wordsArray = new ArrayList<String>(Arrays.asList(stringToTranslate.split("[^\\w\'+]")));
		translatedString = translatedString.replaceFirst(wordsArray.get(0), translator.translateWord(wordsArray.get(0)));
		for(int i = 1; i < wordsArray.size(); i++) { //iterator starts at 1, because first word has been translated
			//replacing with a space character before the regex SHOULD be the thing that eliminates the possibility of translating an already translated word
			translatedString = translatedString.replaceFirst(" " + wordsArray.get(i), " " + translator.translateWord(wordsArray.get(i)));
		}
		return translatedString;
	}
	
	public String translateWord(String word) {
		if(word.matches("[^\\w+]") || "".equals(word)) {
			return word;
		}
		String pigString = "";
		int firstVowelIndex = findFirstVowel(word);
		if(firstVowelIndex > 0) { //word does not begin with vowel
			pigString = word.substring(firstVowelIndex) + "-" + word.substring(0, firstVowelIndex) + "ay";
			if(!pigString.equals(pigString.toLowerCase())) {
				pigString = pigString.toLowerCase();
				pigString = pigString.substring(0, 1).toUpperCase() + pigString.substring(1);
			}
		} else { //word begins with vowel
			pigString = word + "-yay";
		}
		return pigString;
	}

	//if word has a vowel, return value will be greater than -1
	public Integer findFirstVowel(String word) {
		int vowelIndex= -1;
		int initialIndex = 100; //this value allows us to check words with multiple vowels, since no word in english will have 100 consanants before a vowel shows up
		for(String vowel:vowels) {
				if(word.indexOf(vowel) >= 0 && word.indexOf(vowel) < initialIndex) {
				initialIndex =  word.indexOf(vowel);
				vowelIndex =  word.indexOf(vowel);
			}
		}
		return vowelIndex;
	}
}
 