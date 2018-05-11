package englishToPig;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Translator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public String translateSentence(String stringToTranslate) {
		// is it possible to use the replace function instead of deconstructing and reconstructing the sentence?
		//stringToTranslate.replaceAll("regex for words including ' character", thatWordRunThroughTheWordTranslator);
		String pigSentence = "";
		List<String> wordsArray = new ArrayList<String>(Arrays.asList(stringToTranslate.split(" ")));
		int arrayLength = wordsArray.size();
		for(int i = 0; i < arrayLength - 1; i++) { //spaces out each word up until the last word
			pigSentence += translateWord(wordsArray.get(i)) + " ";
			//strip ending punctuation out with regex
			//bring puntuation to end of word using -1 index
		}
		pigSentence += translateWord(wordsArray.get(-1)); // appends final word without a trailing space
		return pigSentence;
	}
	
	public String translateWord(String word) {
		int firstVowelIndex = findFirstVowel(word);
		String pigString = "";
		if(firstVowelIndex > 0) {
			pigString = word.substring(firstVowelIndex) + "-" + word.substring(0, firstVowelIndex) + "ay";
			if(!pigString.equals(pigString.toLowerCase())) {
				pigString = pigString.toLowerCase();
				pigString = pigString.substring(0, 1).toUpperCase() + pigString.substring(1);
			}
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
			int initialIndex = 100; //this value allows us to check words with multiple vowels, since no word in english will have 100 consanants before a vowel shows up
			if(word.indexOf(vowel) > 0 && word.indexOf(vowel) < initialIndex) {
				vowelIndex =  word.indexOf(vowel);
			}
		}
		return vowelIndex;
	}

	public String[] scrapeWords(String sentance) {
		String[] wordsArray = sentance.split(" ");
		return wordsArray;
	}

	public String findAndMovePunctuation(String word) {
		int punctuationIndex = word.indexOf("[.,;:?!]");
		if(punctuationIndex >= 0) {
			char punctuation = word.charAt(punctuationIndex);
			word.replaceAll("[.,;:?!]", "");
			word += punctuation;
		}
		return word;
	}

}
 