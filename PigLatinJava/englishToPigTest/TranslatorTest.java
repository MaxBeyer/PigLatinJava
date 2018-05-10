package englishToPigTest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import englishToPig.Translator;

public class TranslatorTest {
	
	@Test
	public void translateSentanceTest() {
		Translator translator = new Translator();
		String result = translator.translateSentance("This is a test sentance.");
		assertEquals("Is-thay is-yay a-yay est-tay entance-say.", result);
	}
	
	@Test
	public void translateWordTest() {
		Translator translator = new Translator();
		String result = translator.translateWord("test");
		assertEquals("est-tay", result);
	}
	
	@Test
	public void translateWord2Test() {
		Translator translator = new Translator();
		String result = translator.translateWord("strength");
		assertEquals("ength-stray", result);
	}
	
	@Test
	public void findFirstVowelTest() {
		Translator translator = new Translator();
		int result = translator.findFirstVowel("Strength");
		assertEquals(3, result);
	}
	@Test
	public void findFirstVowelOfNonWordTest() {
		Translator translator = new Translator();
		int result = translator.findFirstVowel("Strngth");
		assertEquals(-1, result);
	}

}
